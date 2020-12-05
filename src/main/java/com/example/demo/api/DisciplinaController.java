package com.example.demo.api;


import com.example.demo.model.Disciplina;
import com.example.demo.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Tag( name = "Disciplinas", description = "API para gerenciamento das disciplinas")
@RequestMapping("api/v1/disciplina")
@RestController
public class DisciplinaController {

    private final DisciplinaService disciplinaService;


    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @Operation(summary = "Retorna todos as disciplinas", description = "Utilize esta rota para consultar todas as disciplinas cadastradas.")
    @GetMapping
    public List<Disciplina> getAllDisciplina() throws IOException {
        return disciplinaService.getAllDisciplina();
    }


    @Operation(summary = "Adiciona uma disciplina", description = "Utilize esta rota para adicionar uma disciplina.")
    @PostMapping
    public void insertDisciplina(@Valid @NonNull @RequestBody Disciplina disciplina) throws IOException {
        disciplinaService.insertDisciplina(disciplina);
    }

    @Operation(summary = "Remova uma disciplina do sistema", description = "Utilize esta rota para remover uma disciplina cadastrada.")
    @DeleteMapping(path = "{id}")
    public void deleteDisciplina(@RequestParam int id) throws IOException {
        disciplinaService.deleteDisciplina(id);
    }

    @Operation(summary = "Altere uma disciplina", description = "Utilize esta rota para alterar os dados de uma disciplina.")
    @PutMapping(path = "{id}")
    public void updateDisciplina(@RequestBody Disciplina disciplina, @RequestParam int id) throws IOException {
        disciplinaService.updateDiscilpina(disciplina, id);
    }

}
