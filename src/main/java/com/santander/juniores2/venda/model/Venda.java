package com.santander.juniores2.venda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas")
@Getter
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    private BigDecimal valorTotal = BigDecimal.ZERO;

    @OneToMany(
            mappedBy = "venda",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda(List<ItemVenda> itens) {
        this.data = LocalDateTime.now();

        itens.forEach(this::adicionarItem);
        recalcularTotal();
    }

    private void adicionarItem(ItemVenda item) {
        item.setVenda(this);
        this.itens.add(item);
    }

    private void recalcularTotal() {
        this.valorTotal = itens.stream()
                .map(ItemVenda::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}