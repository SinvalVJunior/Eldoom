create function nota_final_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
    IF NEW.Nota <> OLD.Nota THEN
        UPDATE aluno_turma
        SET NotaTotal= (SELECT avg(Nota)
                        from Trabalho
                                 JOIN trabalho_aluno TAM2M on Trabalho.id = TAM2M.TrabalhoId
                        WHERE aluno_turma.AlunoId = TAM2M.AlunoId
                        GROUP BY aluno_turma.AlunoId)
        WHERE AlunoId IN (SELECT AlunoId
                          from trabalho_aluno
                                   join Trabalho T on T.id = trabalho_aluno.TrabalhoId
                          WHERE TrabalhoId = NEW.id);
    END IF;

    RETURN NEW;
END ;
$$;

create trigger nota_final
    after update of Nota
    on trabalho
    for each row
execute
    procedure nota_final_procedure();
