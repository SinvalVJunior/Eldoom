package com.example.demo.dao;

import com.example.demo.model.AlunoTurma;
import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.AlunoTurmaResponse;
import com.example.demo.model.Trabalho;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AlunoTurmaDAO {

    void insertAlunoTurma(AlunoTurma alunoTurma) throws IOException;

    List<AlunoTurmaResponse> getAllAlunoTurma() throws IOException;

    void deleteAlunoTurma(AlunoTurmaRequest alunoTurmaRequest) throws IOException;

    void updateAlunoTurma(AlunoTurma alunoTurmaNew, AlunoTurma alunoTurmaOld) throws IOException;

}
