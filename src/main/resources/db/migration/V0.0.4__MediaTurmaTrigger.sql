create or replace function "Eldoom".media_turma_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
    UPDATE "Eldoom".turma
    SET MediaNotaTurma= (SELECT avg(aluno_turma.NotaTotal)
                    FROM "Eldoom".aluno_turma aluno_turma
                    WHERE aluno_turma.Turmaid = NEW.Turmaid
                    GROUP BY aluno_turma.turmaid
                    LIMIT 1)
    WHERE "Eldoom".turma.id = New.Turmaid;

    RETURN NEW;
END ;
$$;

create trigger media_turma
    after update of NotaTotal
    on "Eldoom".aluno_turma
    for each row
execute
    procedure "Eldoom".media_turma_procedure();
