create table curso
(
    id      serial not null
        constraint PK_Curso primary key,
    Codigo  text,
    Nome    text,
    MediaNotaCurso numeric(10,4)
);

create table aluno
(
    id             serial  not null
        constraint PK_aluno primary key,
    Nome           text    not null,
    Matricula      integer not null
        constraint UQ_aluno_matricula unique,
    CursoId integer not null
        constraint FK_aluno_curso references curso,
    DataNascimento date,
    DataMatricula  date
);

create table professor
(
    id             serial not null
        constraint PK_professor primary key,
    Nome           text   not null,
    DataNascimento date
);


create table disciplina
(
    id                      serial not null
        constraint PK_Disciplina primary key,
    Codigo                  text,
    Nome                    text,
    Descricao               text,
    MediaNotasDisciplina    numeric(10,4),
    CursoId                 integer
        constraint FK_disciplina_curso references curso
            on delete cascade
);


create table turma
(
    id          serial not null
        constraint PK_turma primary key,
    Codigo      text,
    MediaNotaTurma numeric(10,4),
    ProfessorId integer
        constraint FK_turma_professor_id references professor
        on delete set default,
    DisciplinaId     integer
        constraint FK_turma_disciplina_id references disciplina
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
    TurmaId integer not null
        constraint FK_trabalho_turma references turma,
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

alter table disciplina
add constraint  limite_MediaDisciplina_check
check (MediaNotasDisciplina >= 0 AND MediaNotasDisciplina <= 100);

alter table curso
add constraint limite_MediaCurso_check
check (MediaNotaCurso >= 0 AND MediaNotaCurso <= 100);

alter table turma
add constraint limite_MediaTurma_check
check (MediaNotaTurma >= 0 AND MediaNotaTurma <= 100);

alter table aluno_turma
add constraint limite_NotaFinal_check
check (NotaTotal >= 0 AND NotaTotal <= 100);