package com.example.demo.dao;

import com.example.demo.model.Aluno;
import com.example.demo.model.Professor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProfessorDAO {
    void insertProfessor(Professor professor) throws IOException;

    List<Professor> getAllProfessor() throws IOException;

    Optional<Professor> getProfessorById(int id) throws IOException;

    void deleteProfessor(int id) throws IOException;

    void updateProfessor(Professor professor, int id) throws IOException;

}
