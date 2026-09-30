INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
('L001', 'Clean Code', 'livro', 'Robert C. Martin', '1ª', TRUE),
('L002', 'Refactoring', 'livro', 'Martin Fowler', '1ª', TRUE),
('L003', 'Domain-Driven Design', 'livro', 'Eric Evans', '1ª', TRUE),
('L004', 'Effective Java', 'livro', 'Joshua Bloch', '1ª', TRUE),
('R001', 'O Cavaleiro das Trevas', 'revista', 'Frank Miller', '1ª', TRUE);

INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
('Ana', 'aluno', 3),
('Jorge', 'professor', 5);
