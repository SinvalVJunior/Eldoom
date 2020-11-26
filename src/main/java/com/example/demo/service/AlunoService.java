package com.example.demo.service;

import com.example.demo.dao.AlunoDAO;
import com.example.demo.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
}
