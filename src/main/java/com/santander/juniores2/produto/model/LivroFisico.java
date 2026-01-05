package com.santander.juniores2.produto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("FISICO")
@NoArgsConstructor
@Getter
public class LivroFisico extends Produto{

    private BigDecimal peso;

    public LivroFisico(String titulo, String autor, String editora, Integer estoque, BigDecimal precoBase, BigDecimal peso) {
        super(titulo, autor, editora, estoque, precoBase);

        if (peso == null || peso.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Produto físico deve ter peso válido");
        }

        this.peso = peso;
    }

    @Override
    public BigDecimal calcularPrecoFinal() {
        return getPrecoBase().multiply(BigDecimal.valueOf(1.15));
    }

    @Override
    public TipoProduto getTipo() {
        return TipoProduto.FISICO;
    }
}
