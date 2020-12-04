package com.example.demo.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.model.Professor;
import com.example.demo.service.ProfessorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag( name = "Professores", description = "API para gerenciamento dos professores")
@RequestMapping("api/v1/professor")
@RestController
public class ProfessorController {
    public final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Operation(summary = "Retorna todos os professores", description = "Utilize esta rota para consultar todos os prefessores cadastrados.")
    @GetMapping
    public List<Professor> getAllProfessor() throws IOException {
        return professorService.getAllProfessor();
    }

    @Operation(summary = "Retorna um professor selecionado", description = "Utilize esta rota para consultar um professor pelo seu id.")
    @GetMapping(path = "{id}")
    public Optional<Professor> getProfessorById(@PathVariable("id") int id) throws IOException {
        return professorService.getProfessorById(id);
    }

    @Operation(summary = "Remova um professor do sistema", description = "Utilize esta rota para remover um professor cadastrado.")
    @DeleteMapping(path = "{id}")
    public void deleteProfessor(@PathVariable("id") int id) throws IOException {
        professorService.deleteProfessor(id);
    }

    @Operation(summary = "Altere um professor", description = "Utilize esta rota para alterar os dados de um professor.")
    @PutMapping
    public void updateProfessor(@Valid @NonNull @RequestBody Professor professor, int id) throws IOException {
        professorService.updateProfessor(professor, id);
    }

    @Operation(summary = "Adiciona um professor", description = "Utilize esta rota para adicionar um professor.")
    @PostMapping
    public void insertProfessor(@Valid @NonNull @RequestBody Professor professor) throws IOException {
        professorService.insertProfessor(professor);
    }
}
