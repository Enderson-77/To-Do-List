INSERT INTO tb_todo (text) VALUES ('My task');
INSERT INTO tb_todo (text) VALUES ('Another task');

INSERT INTO tb_list (name) VALUES ('My list');

INSERT INTO tb_belonging (list_id, todo_id, position) VALUES (1, 1, 0);
INSERT INTO tb_belonging (list_id, todo_id, position) VALUES (1, 2, 1);