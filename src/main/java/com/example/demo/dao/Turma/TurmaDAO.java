package com.example.demo.dao.Turma;

import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.Turma;
import com.example.demo.model.AlunoTurma;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TurmaDAO {
    void insertTurma(Turma turma) throws IOException;

    List<Turma> getAllTurma() throws IOException;

    Optional<Turma> getTurmaByCodigo(String codigo) throws IOException;

    void deleteTurma(String codigo) throws IOException;

    void updateTurma(Turma turma) throws IOException;

    void cadastrarAluno(AlunoTurma alunoTurma) throws IOException;

    void removerAluno(AlunoTurmaRequest alunoTurmaRequest) throws IOException;

}
