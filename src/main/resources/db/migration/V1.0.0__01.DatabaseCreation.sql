create table aluno
(
    id        serial  not null
        constraint PK_aluno primary key,
    Nome      text    not null,
    Matricula integer not null
        constraint UQ_aluno_matricula unique
);

create table professor
(
    id   serial not null
        constraint PK_professor primary key,
    Nome text   not null
);

create table turma
(
    id          serial not null
        constraint PK_turma primary key,
    Codigo      text,
    ProfessorId integer
        constraint FK_turma_professor_id references professor
            on delete set default
);

create table aluno_turma
(
    AlunoId   integer
        constraint FK_aluno_turma__aluno references aluno
            on delete cascade,
    TurmaId   integer
        constraint FK_aluno_turma__turma references turma
            on delete cascade,
    NotaTotal numeric(10, 4),
    constraint PK_aluno_turma primary key (AlunoId, TurmaId)
);

create table trabalho
(
    id            serial    not null
        constraint PK_trabalhos primary key,
    Titulo        text,
    Conteudo      text,
    ProfessorId   integer   not null
        constraint FK_trabalho_professor references professor
            on delete cascade,
    DataEnvio     timestamp not null,
    DataAvaliacao timestamp,
    Nota          numeric(10, 4)
);

create table trabalho_aluno
(
    AlunoId    integer
        constraint FK_trabalho_aluno_m2m__aluno references aluno
            on delete cascade,
    TrabalhoId integer
        constraint FK_trabalho_aluno_m2m__trabalho references trabalho
            on delete cascade,
  constraint PK_trabalho_aluno primary key (AlunoId, TrabalhoId)
);
