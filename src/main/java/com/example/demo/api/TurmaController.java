package com.example.demo.api;


import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.Turma;
import com.example.demo.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.AlunoTurma;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Tag( name = "Turmas", description = "API para gerenciamento das turmas")
@RequestMapping("api/v1/turma")
@RestController
public class TurmaController {

    private final TurmaService turmaService;


    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @Operation(summary = "Retorna todas as turmas", description = "Utilize esta rota para consultar todas as turmas cadastradas.")
    @GetMapping
    public List<Turma> getAllTurma() throws IOException {
        return turmaService.getAllTurma();
    }

    @Operation(summary = "Retorna uma turma selecionada", description = "Utilize esta rota para consultar uma turma pelo seu código.")
    @GetMapping(path = "{codigo}")
    public Optional<Turma> getTurmaByCodigo(@PathVariable("codigo") String codigo) throws IOException {
        return turmaService.getTurmaByCodigo(codigo);
    }

    @Operation(summary = "Remova uma turma do sistema", description = "Utilize esta rota para remover uma turma cadastrada.")
    @DeleteMapping(path = "{codigo}")
    public void deleteTurma(@PathVariable("codigo") String codigo) throws IOException {
        turmaService.deleteTurma(codigo);
    }

    @Operation(summary = "Altera um turma", description = "Utilize esta rota para alterar os dados de uma turma.")
    @PutMapping
    public void updateTurma(@Valid @NonNull @RequestBody Turma turma) throws IOException {
        turmaService.updateTurma(turma);
    }

    @Operation(summary = "Adiciona uma turma", description = "Utilize esta rota para adicionar uma turma.")
    @PostMapping
    public void createTurma(@Valid @NonNull @RequestBody Turma turma) throws IOException {
        turmaService.insertTurma(turma);
    }

    @Operation(summary = "Adiciona um aluno a uma turma", description = "Utilize esta rota para adicionar um aluno para uma turma.")
    @PostMapping(path = "/alunos")
    public void cadastrarAluno(@Valid @NonNull @RequestBody AlunoTurma alunoTurma) throws IOException {
        turmaService.cadastrarAluno(alunoTurma);
    }

    @Operation(summary = "Remova um aluno da turma", description = "Utilize esta rota para remover um aluno de uma turma.")
    @DeleteMapping(path = "/alunos")
    public void removerAluno(AlunoTurmaRequest alunoTurmaRequest) throws IOException {
        turmaService.removerAluno(alunoTurmaRequest);
    }

}
