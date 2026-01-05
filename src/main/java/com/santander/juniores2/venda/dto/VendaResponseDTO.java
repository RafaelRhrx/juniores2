package com.santander.juniores2.venda.dto;

import com.santander.juniores2.venda.model.Venda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VendaResponseDTO(
        Long id,
        LocalDateTime data,
        BigDecimal valorTotal
) {
    public static VendaResponseDTO fromEntity(Venda venda) {
        return new VendaResponseDTO(
                venda.getId(),
                venda.getData(),
                venda.getValorTotal()
        );
    }
}