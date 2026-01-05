package com.santander.juniores2.venda.repository;

import com.santander.juniores2.venda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
