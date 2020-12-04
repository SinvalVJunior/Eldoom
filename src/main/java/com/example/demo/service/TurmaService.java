package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.Turma.TurmaDAO;
import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.Turma;
import com.example.demo.model.AlunoTurma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    public final TurmaDAO turmaDAO;


    @Autowired
    public TurmaService(@Qualifier("postgresTurma") TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

    public List<Turma> getAllTurma() throws IOException {
        return turmaDAO.getAllTurma();
    }

    public Optional<Turma> getTurmaByCodigo(String codigo) throws IOException {
        return turmaDAO.getTurmaByCodigo(codigo);
    }

    public void deleteTurma(String codigo) throws IOException {
        turmaDAO.deleteTurma(codigo);
    }

    public void updateTurma(Turma turma) throws IOException {
        turmaDAO.updateTurma(turma);
    }

    public void insertTurma(Turma turma) throws IOException {
        turmaDAO.insertTurma(turma);
    }

    public void cadastrarAluno(AlunoTurma alunoTurma) throws IOException {
        turmaDAO.cadastrarAluno(alunoTurma);
    }

    public void removerAluno(AlunoTurmaRequest alunoTurmaRequest) throws IOException {
        turmaDAO.removerAluno(alunoTurmaRequest);
    }
}
