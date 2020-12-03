package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.Disciplina.DisciplinaDAO;
import com.example.demo.model.Disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    public final DisciplinaDAO disciplinaDAO;

    @Autowired
    public DisciplinaService(@Qualifier("postgresDisciplina")DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    public List<Disciplina> getAllDisciplina() throws IOException {
        return disciplinaDAO.getAllDisciplina();
    }

    public void insertDisciplina(Disciplina Disciplina) throws IOException{
        disciplinaDAO.insertDisciplina(Disciplina);
    }

}
