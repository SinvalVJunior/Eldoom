--Inserção Curso
INSERT INTO curso (id, codigo, nome, medianotacurso) VALUES (default, 'ECOMP', 'Engenharia de Computacao', null);

INSERT INTO curso (id, codigo, nome, medianotacurso) VALUES (default, 'EELET', 'Engenharia Elétrica', null);

INSERT INTO curso (id, codigo, nome, medianotacurso) VALUES (default, 'EMEC', 'Engenharia Mecânica', null);

INSERT INTO curso (id, codigo, nome, medianotacurso) VALUES (default, 'LETR', 'Letras', null);

INSERT INTO curso (id, codigo, nome, medianotacurso) VALUES (default, 'ADM', 'Administracao', null);


--Inserção dos alunos
INSERT INTO aluno (id, nome, matricula, cursoid, DataNascimento, DataMatricula) VALUES (default, 'Jorge', 123456, 1,'1998-12-02 23:59:48.000000', '2007-11-20 23:59:48.000000');

INSERT INTO aluno (id, nome, matricula, cursoid, DataNascimento, DataMatricula) VALUES (default, 'Carlos', 234567, 1,'1995-08-08 23:59:48.000000', '2012-10-18 23:59:48.000000');

INSERT INTO aluno (id, nome, matricula, cursoid, DataNascimento, DataMatricula) VALUES (default, 'Marcus', 345678, 2,'1997-09-09 23:59:48.000000', '2010-06-17 23:59:48.000000');

INSERT INTO aluno (id, nome, matricula, cursoid, DataNascimento, DataMatricula) VALUES (default, 'Matheus', 456789, 3,'1993-07-05 23:59:48.000000', '2008-07-15 23:59:48.000000');

INSERT INTO aluno (id, nome, matricula, cursoid, DataNascimento, DataMatricula) VALUES (default, 'Lucas', 012345, 4,'2000-03-02 23:59:48.000000', '2009-05-16 23:59:48.000000');

--Inserção dos Professores
INSERT INTO professor (id, nome, DataNascimento) VALUES (default, 'Natalia', '1983-03-02 23:59:48.000000');

INSERT INTO professor (id, nome, DataNascimento) VALUES (default, 'Evandrino', '1966-09-15 23:59:48.000000');

INSERT INTO professor (id, nome, DataNascimento) VALUES (default, 'Edson', '1971-05-07 23:59:48.000000');

INSERT INTO professor (id, nome, DataNascimento) VALUES (default, 'Thiago', '1973-06-10 23:59:48.000000');

INSERT INTO professor (id, nome, DataNascimento) VALUES (default, 'Bruno', '1955-01-01 23:59:48.000000');


--Insercao Disciplina
INSERT INTO disciplina (id, codigo, nome, descricao, medianotasdisciplina, cursoid) VALUES (default, 'ECOMP101', 'Introdução a Eng. Comp', 'Introduz as possibilidades relacionadas ao curso', null, 1);

INSERT INTO disciplina (id, codigo, nome, descricao, medianotasdisciplina, cursoid) VALUES (default, 'ELET201', 'Circuitos', 'Permitir o entendimento e produção de circuitos elétricos', null, 2);

INSERT INTO disciplina (id, codigo, nome, descricao, medianotasdisciplina, cursoid) VALUES (default, 'EMEC301', 'AR Condicionados', 'Discutir o funcionamento mecânico de sistemas de ar condicionados', null, 3);

INSERT INTO disciplina (id, codigo, nome, descricao, medianotasdisciplina, cursoid) VALUES (default, 'LETR101', 'Alfabeto', 'Discutir a origem e funcionalidades do alfabeto ', null, 4);

INSERT INTO disciplina (id, codigo, nome, descricao, medianotasdisciplina, cursoid) VALUES (default, 'ADM202', 'Excel Avançado', 'Discutir conhecimentos sobre o uso do Excel', null, 5);


--Inserção de Turmas
INSERT INTO turma (id, codigo, professorid, disciplinaid) VALUES (default, '101', 1, 1);

INSERT INTO turma (id, codigo, professorid, disciplinaid) VALUES (default, '201', 2, 1);

INSERT INTO turma (id, codigo, professorid, disciplinaid) VALUES (default, '301', 3, 2);

INSERT INTO turma (id, codigo, professorid, disciplinaid) VALUES (default, '401', 4, 3);

INSERT INTO turma (id, codigo, professorid, disciplinaid) VALUES (default, '501', 5, 4);

--Inserção de Trabalhos
INSERT INTO trabalho (id, titulo, conteudo, professorid, turmaid, dataenvio, dataavaliacao, nota) VALUES (default, 'Estruturas de Dados', 'Filas, Listas e Pilhas', 1, 2, '2020-12-01 23:59:40.000000', '2020-12-02 13:00:23.000000', 100.0000);

INSERT INTO trabalho (id, titulo, conteudo, professorid, turmaid, dataenvio, dataavaliacao, nota) VALUES (default, 'Banco de Dados', 'Modelo Objeto-Relacional', 2, 2, '2020-12-02 23:59:48.000000', '2020-12-03 16:40:04.000000', 60.0000);

INSERT INTO trabalho (id, titulo, conteudo, professorid, turmaid, dataenvio, dataavaliacao, nota) VALUES (default, 'Modelagem de Software', 'Metodologia SCRUM', 3, 2, '2020-12-03 23:59:54.000000', '2020-12-13 23:59:26.000000',57.0000);

INSERT INTO trabalho (id, titulo, conteudo, professorid, turmaid, dataenvio, dataavaliacao, nota) VALUES (default, 'Estruturas de Dados II', 'Arvore B', 4, 2, '2020-12-04 23:59:04.000000', '2020-12-13 23:59:31.000000', 95.0000);

INSERT INTO trabalho (id, titulo, conteudo, professorid, turmaid, dataenvio, dataavaliacao, nota) VALUES (default, 'Sistemas Operacionais', 'Kernel', 5, 2, '2020-12-05 23:59:08.000000', null, null);

--Inserção Aluno-Turma
INSERT INTO aluno_turma (alunoid, turmaid, notatotal) VALUES (2, 2, null);

INSERT INTO aluno_turma (alunoid, turmaid, notatotal) VALUES (3, 2, null);

INSERT INTO aluno_turma (alunoid, turmaid, notatotal) VALUES (4, 2, null);

INSERT INTO aluno_turma (alunoid, turmaid, notatotal) VALUES (5, 2, null);

INSERT INTO aluno_turma (alunoid, turmaid, notatotal) VALUES (1, 2, null);

--Inserção Trabalho-Aluno
INSERT INTO trabalho_aluno (alunoid, trabalhoid) VALUES (3, 1);

INSERT INTO trabalho_aluno (alunoid, trabalhoid) VALUES (2, 2);

INSERT INTO trabalho_aluno (alunoid, trabalhoid) VALUES (5, 3);

INSERT INTO trabalho_aluno (alunoid, trabalhoid) VALUES (1, 4);

INSERT INTO trabalho_aluno (alunoid, trabalhoid) VALUES (2, 5);