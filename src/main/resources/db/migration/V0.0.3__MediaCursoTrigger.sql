create or replace function "Eldoom".media_curso_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
    UPDATE "Eldoom".Curso
    SET MediaNotaCurso= (SELECT avg(discip.MediaNotasDisciplina)
                    FROM "Eldoom".Disciplina discip
                    WHERE discip.id = NEW.id
                    GROUP BY discip.id
                    LIMIT 1)
    WHERE "Eldoom".Curso.id = New.id;

    RETURN NEW;
END ;
$$;

create trigger media_curso
    after insert or update of MediaNotasDisciplina
    on "Eldoom".Disciplina
    for each row
execute
    procedure "Eldoom".media_Curso_procedure();
