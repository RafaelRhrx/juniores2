package com.santander.juniores2.produto.repository;

import com.santander.juniores2.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
