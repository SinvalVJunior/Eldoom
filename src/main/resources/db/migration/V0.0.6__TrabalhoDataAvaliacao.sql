create or replace function "Eldoom".trabalho_data_avaliacao() returns trigger
    language plpgsql
as
$$
BEGIN
    IF ((NEW.dataavaliacao IS NOT NULL AND NEW.nota IS NULL) OR
        (NEW.dataavaliacao IS NULL AND NEW.nota IS NOT NULL)) THEN
        RAISE EXCEPTION USING MESSAGE = 'Para inserir a nota é necessario uma data de avaliacao';
    END IF;

    IF (NEW.dataavaliacao IS NOT NULL) THEN
        IF (NEW.dataenvio IS NULL) THEN
            IF (OLD.dataenvio IS NOT NULL AND NEW.dataavaliacao >= OLD.dataenvio) THEN
                RETURN NEW;
            ELSE
                RAISE EXCEPTION USING MESSAGE = 'A data de avaliacao nao pode ocorrer antes da data de envio';
            END IF;
        ELSEIF (NEW.dataavaliacao < NEW.dataenvio) THEN
            RAISE EXCEPTION USING MESSAGE = 'A data de avaliacao nao pode ocorrer antes da data de envio';
        END IF;
    END IF;

    RETURN NEW;
END;
$$;

create trigger trabalho_data_avaliacao
    after insert or update of dataavaliacao, nota
    on "Eldoom".trabalho
    for each row
execute
    procedure "Eldoom".trabalho_data_avaliacao();
