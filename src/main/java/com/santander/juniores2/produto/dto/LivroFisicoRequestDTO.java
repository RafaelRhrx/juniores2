package com.santander.juniores2.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record LivroFisicoRequestDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String editora,
        @NotBlank
        @Positive
        Integer estoque,
        @NotBlank
        @Positive
        BigDecimal precoBase,
        @NotBlank
        @Positive
        BigDecimal peso) {

}
