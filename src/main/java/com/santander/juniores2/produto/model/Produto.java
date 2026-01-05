package com.santander.juniores2.produto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto")
@NoArgsConstructor
@Getter
public abstract class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String editora;

    private Integer estoque;
    private BigDecimal precoBase;

    public Produto(String titulo, String autor, String editora, Integer estoque, BigDecimal precoBase) {

        if (estoque == null || estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.estoque = estoque;
        this.precoBase = precoBase;
    }

    public abstract BigDecimal calcularPrecoFinal();

    public abstract TipoProduto getTipo();

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
