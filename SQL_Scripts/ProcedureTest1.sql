CREATE TRIGGER Nota_Final
    AFTER UPDATE OF "Nota"
    ON "Trabalho"
    FOR EACH ROW
EXECUTE PROCEDURE Nota_Final_Procedure();


CREATE FUNCTION Nota_Final_Procedure()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    IF NEW."Nota" <> OLD."Nota" THEN
        UPDATE "AlunoTurma"
        SET "NotaTotal"= (SELECT avg("Nota")
                          from "Trabalho"
                                   JOIN "TrabalhoAlunoM2M" TAM2M on "Trabalho".id = TAM2M."TrabalhoId"
                          WHERE "AlunoTurma"."AlunoId" = TAM2M."AlunoId"
                          GROUP BY "AlunoTurma"."AlunoId")
        WHERE "AlunoId" IN (SELECT "AlunoId"
                            from "TrabalhoAlunoM2M"
                                     join "Trabalho" T on T.id = "TrabalhoAlunoM2M"."TrabalhoId"
                            WHERE "TrabalhoId" = NEW.id);
    END IF;

    RETURN NEW;
END ;
$$

