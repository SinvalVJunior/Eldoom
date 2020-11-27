package com.example.demo.dao;

import com.example.demo.model.Aluno;
import com.example.demo.model.Turma;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TurmaDAO {
    void insertTurma(Turma turma) throws IOException;

    List<Turma> getAllTurma() throws IOException;

    Optional<Turma> getTurmaByCodigo(String codigo) throws IOException;

    void deleteTurma(String codigo) throws IOException;

    void updateTurma(Turma turma) throws IOException;

}
