package com.santander.juniores2.produto.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("DIGITAL")
@Getter
@NoArgsConstructor
public class Ebook extends Produto{

    private Long tamanhoArquivoMb;

    public Ebook(String titulo, String autor, String editora, Integer estoque, BigDecimal precoBase, Long tamanhoArquivoMb) {
        super(titulo, autor, editora, estoque, precoBase);

        if (tamanhoArquivoMb == null || tamanhoArquivoMb <= 0) {
            throw new IllegalArgumentException("Ebook deve ter tamanho de arquivo válido");
        }

        this.tamanhoArquivoMb = tamanhoArquivoMb;
    }

    @Override
    public BigDecimal calcularPrecoFinal() {
        return getPrecoBase().multiply(BigDecimal.valueOf(0.95));
    }

    @Override
    public TipoProduto getTipo() {
        return TipoProduto.DIGITAL;
    }
}
