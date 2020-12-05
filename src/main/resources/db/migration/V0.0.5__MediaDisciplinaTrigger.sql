create or replace function "Eldoom".media_disciplina_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
    UPDATE "Eldoom".disciplina
    SET MediaNotasDisciplina= (SELECT avg(turma.MediaNotaTurma)
                    FROM "Eldoom".turma turma
                    WHERE turma.id = NEW.id
                    GROUP BY turma.id
                    LIMIT 1)
    WHERE "Eldoom".disciplina.id = New.id;

    RETURN NEW;
END ;
$$;

create trigger media_disciplina
    after insert or update of MediaNotaTurma
    on "Eldoom".turma
    for each row
execute
    procedure "Eldoom".media_disciplina_procedure();
