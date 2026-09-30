INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista)
VALUES (1, 1, '2026-09-20', '2026-09-30');

UPDATE emprestimo
SET data_devolucao = '2026-10-06', valor_multa = 10.00
WHERE item_id = 1 AND usuario_id = 1;



INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista)
VALUES (5, 2, '2026-09-20', '2026-09-28');

UPDATE emprestimo
SET data_devolucao = '2026-09-28', valor_multa = 0
WHERE item_id = 5 AND usuario_id = 2;


INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista)
VALUES (4, 1, '2026-09-25', '2026-10-05');