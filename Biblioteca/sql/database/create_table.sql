CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(200) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL CHECK (limite_itens > 0)
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id),
    usuario_id INT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) DEFAULT 0
);
