package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.Aluno.AlunoDAO;
import com.example.demo.model.Aluno;

import com.example.demo.model.AlunoAprovado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    public final AlunoDAO alunoDAO;

    @Autowired
    public AlunoService(@Qualifier("postgresAluno")AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public List<Aluno> getAllAluno() throws IOException {
        return alunoDAO.getAllAluno();
    }

    public Optional<Aluno> getAlunoByMatricula(int matricula) throws IOException{
        return alunoDAO.getAlunoByMatricula(matricula);
    }

    public void deleteAluno(int matricula) throws IOException{
        alunoDAO.deleteAluno(matricula);
    }

    public void updateAluno(Aluno aluno) throws IOException{
        alunoDAO.updateAluno(aluno);
    }

    public void insertAluno(Aluno aluno) throws IOException{
        alunoDAO.insertAluno(aluno);
    }
    public List<AlunoAprovado> getAlunoAprovadoGroupByTurma() throws IOException {
        return alunoDAO.getAlunoAprovadoGroupByTurma();
    }

}
