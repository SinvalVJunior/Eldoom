package com.example.demo.api;


import com.example.demo.model.Aluno;
import com.example.demo.model.Professor;
import com.example.demo.service.ProfessorService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/professor")
@RestController
public class ProfessorController {
    public final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessor() throws IOException {
        return professorService.getAllProfessor();
    }

    @GetMapping(path = "{id}")
    public Optional<Professor> getProfessorById(@PathVariable("id") int id) throws IOException {
        return professorService.getProfessorById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProfessor(@PathVariable("id") int id) throws IOException {
        professorService.deleteProfessor(id);
    }

    @PutMapping
    public void updateProfessor(@Valid @NonNull @RequestBody Professor professor, int id) throws IOException {
        professorService.updateProfessor(professor, id);
    }

    @PostMapping
    public void insertProfessor(@Valid @NonNull @RequestBody Professor professor) throws IOException {
        professorService.insertProfessor(professor);
    }
}
