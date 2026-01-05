CREATE TABLE produtos (
    id BIGSERIAL PRIMARY KEY,

    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    editora VARCHAR(150) NOT NULL,

    preco_base NUMERIC(10,2) NOT NULL,
    estoque INTEGER NOT NULL,

    tipo_produto VARCHAR(20) NOT NULL,

    peso NUMERIC(10,2),
    tamanho_arquivo_mb BIGINT
);