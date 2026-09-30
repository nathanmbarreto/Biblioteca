--  Listar todo o acervo, com código, título, tipo e disponibilidade.
SELECT codigo, titulo, tipo, disponivel
FROM item;

--  Listar os empréstimos em aberto, com o nome do usuário e o título do item.
SELECT u.nome, i.titulo
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;

-- Calcular o total de multas acumuladas por usuário.
SELECT u.nome, SUM(e.valor_multa) AS total_multas
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
GROUP BY u.nome;

-- Lstar os itens que nunca foram emprestados.
SELECT i.codigo, i.titulo, i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL;