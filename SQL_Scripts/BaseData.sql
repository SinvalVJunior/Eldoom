--Inserção dos alunos
INSERT INTO "Eldoom".aluno (id, nome, matricula) VALUES (default, 'Jorge', 123456);

INSERT INTO "Eldoom".aluno (id, nome, matricula) VALUES (default, 'Carlos', 234567);

INSERT INTO "Eldoom".aluno (id, nome, matricula) VALUES (default, 'Marcus', 345678);

INSERT INTO "Eldoom".aluno (id, nome, matricula) VALUES (default, 'Matheus', 456789);

INSERT INTO "Eldoom".aluno (id, nome, matricula) VALUES (default, 'Lucas', 012345);

--Inserção dos Professores
INSERT INTO "Eldoom".professor (id, nome) VALUES (default, 'Natalia');

INSERT INTO "Eldoom".professor (id, nome) VALUES (default, 'Evandrino');

INSERT INTO "Eldoom".professor (id, nome) VALUES (default, 'Edson');

INSERT INTO "Eldoom".professor (id, nome) VALUES (default, 'Thiago');

INSERT INTO "Eldoom".professor (id, nome) VALUES (default, 'Bruno');


--Inserção de Turmas
INSERT INTO "Eldoom".turma (id, codigo, professorid) VALUES (1, '101', 1);

INSERT INTO "Eldoom".turma (id, codigo, professorid) VALUES (2, '201', 2);

INSERT INTO "Eldoom".turma (id, codigo, professorid) VALUES (3, '301', 3);

INSERT INTO "Eldoom".turma (id, codigo, professorid) VALUES (4, '401', 4);

INSERT INTO "Eldoom".turma (id, codigo, professorid) VALUES (5, '501', 5);

--Inserção de Trabalhos
INSERT INTO "Eldoom".trabalho (id, titulo, conteudo, professorid, dataenvio, dataavaliacao, nota) VALUES (1, 'Estruturas de Dados', 'Filas, Listas e Pilhas', 1, '2020-12-01 23:59:40.000000', '2020-12-02 13:00:23.000000', 100.0000);

INSERT INTO "Eldoom".trabalho (id, titulo, conteudo, professorid, dataenvio, dataavaliacao, nota) VALUES (2, 'Banco de Dados', 'Modelo Objeto-Relacional', 2, '2020-12-02 23:59:48.000000', '2020-12-03 16:40:04.000000', 60.0000);

INSERT INTO "Eldoom".trabalho (id, titulo, conteudo, professorid, dataenvio, dataavaliacao, nota) VALUES (3, 'Modelagem de Software', 'Metodologia SCRUM', 3, '2020-12-03 23:59:54.000000', '2020-12-13 23:59:26.000000', null);

INSERT INTO "Eldoom".trabalho (id, titulo, conteudo, professorid, dataenvio, dataavaliacao, nota) VALUES (4, 'Estruturas de Dados II', 'Arvore B', 4, '2020-12-04 23:59:04.000000', '2020-12-13 23:59:31.000000', null);

INSERT INTO "Eldoom".trabalho (id, titulo, conteudo, professorid, dataenvio, dataavaliacao, nota) VALUES (5, 'Sistemas Operacionais', 'Kernel', 5, '2020-12-05 23:59:08.000000', '2020-12-13 23:59:39.000000', null);

--Inserção Aluno-Turma
INSERT INTO "Eldoom".aluno_turma (alunoid, turmaid, notatotal) VALUES (2, 1, null);

INSERT INTO "Eldoom".aluno_turma (alunoid, turmaid, notatotal) VALUES (3, 2, null);

INSERT INTO "Eldoom".aluno_turma (alunoid, turmaid, notatotal) VALUES (4, 3, null);

INSERT INTO "Eldoom".aluno_turma (alunoid, turmaid, notatotal) VALUES (5, 4, null);

INSERT INTO "Eldoom".aluno_turma (alunoid, turmaid, notatotal) VALUES (6, 5, null);

--Inserção Trabalho-Aluno
INSERT INTO "Eldoom".trabalho_aluno (alunoid, trabalhoid) VALUES (3, 1);

INSERT INTO "Eldoom".trabalho_aluno (alunoid, trabalhoid) VALUES (2, 2);

INSERT INTO "Eldoom".trabalho_aluno (alunoid, trabalhoid) VALUES (5, 3);

INSERT INTO "Eldoom".trabalho_aluno (alunoid, trabalhoid) VALUES (6, 4);

INSERT INTO "Eldoom".trabalho_aluno (alunoid, trabalhoid) VALUES (2, 5);