package com.example.demo.dao.Aluno;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Aluno;

public interface AlunoDAO {
    void insertAluno(Aluno aluno) throws IOException;

    List<Aluno> getAllAluno() throws IOException;

    Optional<Aluno> getAlunoByMatricula(int matricula) throws IOException;

    void deleteAluno(int matricula) throws IOException;

    void updateAluno(Aluno aluno) throws IOException;
}
