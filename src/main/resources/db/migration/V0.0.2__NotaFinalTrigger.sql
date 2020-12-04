create or replace function nota_final_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
    UPDATE "Eldoom".aluno_turma
    SET NotaTotal= (SELECT avg(Trab.Nota)
                    FROM "Eldoom".Trabalho Trab
                             JOIN "Eldoom".trabalho_aluno TRAB_ALUN ON Trab.id = TRAB_ALUN.TrabalhoId
                    WHERE "Eldoom".aluno_turma.AlunoId = TRAB_ALUN.AlunoId
                      AND "Eldoom".aluno_turma.Turmaid = Trab.turmaid
                    GROUP BY "Eldoom".aluno_turma.AlunoId, "Eldoom".aluno_turma.turmaid
                    LIMIT 1)
    WHERE (AlunoId, Turmaid) = (SELECT TRAB_ALUN.AlunoId, T.turmaid
                                FROM "Eldoom".trabalho_aluno TRAB_ALUN
                                         JOIN "Eldoom".Trabalho T ON T.id = TRAB_ALUN.TrabalhoId
                                WHERE TRAB_ALUN.TrabalhoId = NEW.id
                                LIMIT 1);

    RETURN NEW;
END ;
$$;

create trigger nota_final
    after update of Nota
    on trabalho
    for each row
execute
    procedure nota_final_procedure();