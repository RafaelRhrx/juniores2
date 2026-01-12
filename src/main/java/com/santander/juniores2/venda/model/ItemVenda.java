package com.santander.juniores2.venda.model;

import com.santander.juniores2.exception.VendaException;
import com.santander.juniores2.produto.model.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_venda")
@Getter
@NoArgsConstructor
public class ItemVenda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

    private Integer quantidade;

    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    public ItemVenda(Produto produto, Integer quantidade) {
        if (quantidade <= 0) {
            throw new VendaException("Quantidade inválida");
        }

        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.calcularPrecoFinal();
        this.subtotal = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    void setVenda(Venda venda) {
        this.venda = venda;
    }
}
