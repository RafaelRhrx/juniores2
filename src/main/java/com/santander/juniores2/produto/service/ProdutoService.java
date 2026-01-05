package com.santander.juniores2.produto.service;

import com.santander.juniores2.produto.dto.AtualizarEstoqueDTO;
import com.santander.juniores2.produto.dto.EbookRequestDTO;
import com.santander.juniores2.produto.dto.LivroFisicoRequestDTO;
import com.santander.juniores2.produto.dto.ProdutoResponseDTO;
import com.santander.juniores2.produto.model.Ebook;
import com.santander.juniores2.produto.model.LivroFisico;
import com.santander.juniores2.produto.model.Produto;
import com.santander.juniores2.produto.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponseDTO criarFisico(LivroFisicoRequestDTO dto) {
        LivroFisico livro = new LivroFisico(dto.titulo(), dto.autor(), dto.editora(), dto.estoque(), dto.precoBase(), dto.peso());
        return ProdutoResponseDTO.fromEntity(repository.save(livro));
    }

    public ProdutoResponseDTO criarEbook(EbookRequestDTO dto) {
        Ebook ebook = new Ebook(dto.titulo(), dto.autor(), dto.editora(), dto.estoque(), dto.precoBase(), dto.tamanhoArquivoMb());
        return ProdutoResponseDTO.fromEntity(repository.save(ebook));
    }

    public Page<ProdutoResponseDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ProdutoResponseDTO::fromEntity);
    }

    public ProdutoResponseDTO atualizarEstoque(Long id, AtualizarEstoqueDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (dto.quantidade() < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }

        produto.setEstoque(dto.quantidade());

        return ProdutoResponseDTO.fromEntity(repository.save(produto));
    }
}
