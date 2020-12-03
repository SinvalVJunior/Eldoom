package com.example.demo.dao.Curso;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Curso;

public interface CursoDAO {
    void insertCurso(Curso curso) throws IOException;

    List<Curso> getAllCurso() throws IOException;

}
