package com.example.demo.service;

import com.example.demo.dao.AlunoTurmaDAO;
import com.example.demo.model.AlunoTurma;
import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.AlunoTurmaResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AlunoTurmaService {

    public final AlunoTurmaDAO alunoTurmaDAO;

    public AlunoTurmaService(@Qualifier("postgresAlunoTurma") AlunoTurmaDAO alunoTurmaDAO) {
        this.alunoTurmaDAO = alunoTurmaDAO;
    }


    public void insertAlunoTurma(AlunoTurma alunoTurma) throws IOException {
        alunoTurmaDAO.insertAlunoTurma(alunoTurma);
    }

    public void updateAlunoTurma(AlunoTurma alunoTurmaNew, AlunoTurma alunoTurmaOld) throws IOException {
        alunoTurmaDAO.updateAlunoTurma(alunoTurmaNew, alunoTurmaOld);
    }

    public void deleteAlunoTurma(AlunoTurmaRequest alunoTurmaRequest) throws IOException {
        alunoTurmaDAO.deleteAlunoTurma(alunoTurmaRequest);
    }

    public List<AlunoTurmaResponse> getAllAlunoTurma() throws IOException {
        return alunoTurmaDAO.getAllAlunoTurma();
    }

}
