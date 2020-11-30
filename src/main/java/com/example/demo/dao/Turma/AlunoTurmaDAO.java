package com.example.demo.dao.Turma;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.AlunoTurma;
import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.AlunoTurmaResponse;

public interface AlunoTurmaDAO {

    void insertAlunoTurma(AlunoTurma alunoTurma) throws IOException;

    List<AlunoTurmaResponse> getAllAlunoTurma() throws IOException;

    void deleteAlunoTurma(AlunoTurmaRequest alunoTurmaRequest) throws IOException;

    void updateAlunoTurma(AlunoTurma alunoTurmaNew, AlunoTurma alunoTurmaOld) throws IOException;

}
