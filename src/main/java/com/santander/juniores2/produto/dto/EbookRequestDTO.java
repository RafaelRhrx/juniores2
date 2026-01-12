package com.santander.juniores2.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record EbookRequestDTO(

        @NotBlank(message = "Campo título é obrigatório")
        String titulo,

        @NotBlank(message = "Campo autor é obrigatório")
        String autor,

        @NotBlank(message = "Campo editora é obrigatório")
        String editora,

        @NotNull(message = "Campo estoque é obrigatório")
        @Positive(message = "Quantidade do estoque inválida")
        Integer estoque,

        @NotNull(message = "Campo preço é obrigatório")
        @Positive(message = "Valor do preço inválido")
        BigDecimal precoBase,

        @NotNull(message = "Campo tamanho do arquivo é obrigatório")
        @Positive(message = "Tamanho do arquivo inválido")
        Long tamanhoArquivoMb) {

}
