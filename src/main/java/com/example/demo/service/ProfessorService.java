package com.example.demo.service;

import com.example.demo.dao.ProfessorDAO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    public final ProfessorDAO professorDAO;

    @Autowired
    public ProfessorService(@Qualifier("postgresProfessor")ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    public List<Professor> getAllProfessor() throws IOException {
        return professorDAO.getAllProfessor();
    }

    public Optional<Professor> getProfessorById(int id) throws IOException{
        return professorDAO.getProfessorById(id);
    }

    public void deleteProfessor(int id) throws IOException{
        professorDAO.deleteProfessor(id);
    }

    public void updateProfessor(Professor professor, int id) throws IOException{
        professorDAO.updateProfessor(professor, id);
    }

    public void insertProfessor(Professor professor) throws IOException{
        professorDAO.insertProfessor(professor);
    }



}
