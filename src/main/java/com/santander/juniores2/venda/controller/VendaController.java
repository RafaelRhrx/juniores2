package com.santander.juniores2.venda.controller;

import com.santander.juniores2.venda.dto.VendaRequestDTO;
import com.santander.juniores2.venda.dto.VendaResponseDTO;
import com.santander.juniores2.venda.service.VendaService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public VendaResponseDTO criar(@RequestBody VendaRequestDTO dto) {
        return service.criarVenda(dto);
    }

    @GetMapping
    public List<VendaResponseDTO> listar() {
        return service.listar();
    }
}
