package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.Curso.CursoDAO;
import com.example.demo.model.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    public final CursoDAO cursoDAO;

    @Autowired
    public CursoService(@Qualifier("postgresCurso")CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<Curso> getAllCurso() throws IOException {
        return cursoDAO.getAllCurso();
    }

    public void insertCurso(Curso curso) throws IOException {
        cursoDAO.insertCurso(curso);
    }

    public void updateCurso(Curso cursoNew, int id) throws IOException {
        cursoDAO.updateCurso(cursoNew, id);
    }

    public void deleteCurso(int id) throws IOException {
        cursoDAO.deleteCurso(id);
    }

}
