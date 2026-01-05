CREATE TABLE vendas (
    id BIGSERIAL PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    valor_total NUMERIC(10,2) NOT NULL
);

CREATE TABLE itens_venda (
    id BIGSERIAL PRIMARY KEY,

    venda_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,

    quantidade INTEGER NOT NULL,
    preco_unitario NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_item_venda_venda
        FOREIGN KEY (venda_id)
        REFERENCES vendas (id),

    CONSTRAINT fk_item_venda_produto
        FOREIGN KEY (produto_id)
        REFERENCES produtos (id)
);
