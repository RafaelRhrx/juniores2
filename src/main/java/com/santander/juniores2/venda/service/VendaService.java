package com.santander.juniores2.venda.service;

import com.santander.juniores2.exception.EstoqueException;
import com.santander.juniores2.exception.ProdutoException;
import com.santander.juniores2.produto.model.Produto;
import com.santander.juniores2.produto.repository.ProdutoRepository;
import com.santander.juniores2.venda.dto.ItemVendaRequestDTO;
import com.santander.juniores2.venda.dto.VendaRequestDTO;
import com.santander.juniores2.venda.dto.VendaResponseDTO;
import com.santander.juniores2.venda.model.ItemVenda;
import com.santander.juniores2.venda.model.Venda;
import com.santander.juniores2.venda.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;

    public VendaService(ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    public VendaResponseDTO criarVenda(VendaRequestDTO dto) {
        List<ItemVenda> itens = new ArrayList<>();

        for (ItemVendaRequestDTO itemDTO : dto.itens()) {
            Produto produto = produtoRepository.findById(itemDTO.produtoId())
                    .orElseThrow(() -> new ProdutoException("Produto não encontrado"));

            if (produto.getEstoque() < itemDTO.quantidade()) {
                throw new EstoqueException("Estoque insuficiente");
            }

            if (produto.getEstoque() <= 0) {
                throw new EstoqueException("Quantidade deve ser maior que 0");
            }

            produto.setEstoque(produto.getEstoque() - itemDTO.quantidade());
            itens.add(new ItemVenda(produto, itemDTO.quantidade()));
        }

        Venda venda = new Venda(itens);
        return VendaResponseDTO.fromEntity(vendaRepository.save(venda));
    }

    public List<VendaResponseDTO> listar() {
        return vendaRepository.findAll().stream().map(VendaResponseDTO::fromEntity).toList();
    }
}
