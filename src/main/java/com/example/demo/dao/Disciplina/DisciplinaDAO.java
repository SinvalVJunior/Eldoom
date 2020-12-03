package com.example.demo.dao.Disciplina;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Disciplina;

public interface DisciplinaDAO {
    void insertDisciplina(Disciplina disciplina) throws IOException;

    List<Disciplina> getAllDisciplina() throws IOException;

}
