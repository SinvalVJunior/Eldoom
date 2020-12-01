package com.example.demo.dao.Professor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Professor;

public interface ProfessorDAO {
    void insertProfessor(Professor professor) throws IOException;

    List<Professor> getAllProfessor() throws IOException;

    Optional<Professor> getProfessorById(int id) throws IOException;

    void deleteProfessor(int id) throws IOException;

    void updateProfessor(Professor professor, int id) throws IOException;

}
