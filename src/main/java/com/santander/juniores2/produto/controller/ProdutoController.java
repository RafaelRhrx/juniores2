package com.santander.juniores2.produto.controller;

import com.santander.juniores2.produto.dto.AtualizarEstoqueDTO;
import com.santander.juniores2.produto.dto.EbookRequestDTO;
import com.santander.juniores2.produto.dto.LivroFisicoRequestDTO;
import com.santander.juniores2.produto.dto.ProdutoResponseDTO;
import com.santander.juniores2.produto.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/fisicos")
    @Transactional
    public ProdutoResponseDTO criarFisico(@RequestBody LivroFisicoRequestDTO dto) {
        return  service.criarFisico(dto);
    }

    @PostMapping("/digitais")
    @Transactional
    public ProdutoResponseDTO criarFisico(@RequestBody EbookRequestDTO dto) {
        return  service.criarEbook(dto);
    }

    @GetMapping
    public Page<ProdutoResponseDTO> listar(Pageable paginacao) {
        return service.listar(paginacao);
    }

    @PatchMapping("/{id}/estoque")
    public ProdutoResponseDTO atualizarEstoque(@PathVariable Long id, @RequestBody AtualizarEstoqueDTO dto) {
        return service.atualizarEstoque(id, dto);
    }

}
