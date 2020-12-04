package com.example.demo.api;

import com.example.demo.model.Aluno;
import com.example.demo.model.AlunoAprovado;
import com.example.demo.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Tag( name = "Alunos", description = "API para gerenciamento de alunos")
@RequestMapping("api/v1/aluno")
@RestController
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @Operation(summary = "Retorna todos os alunos", description = "Utilize esta rota para consultar todos os alunos cadastrados.")
    @GetMapping
    public List<Aluno> getAllAluno() throws IOException {
        return alunoService.getAllAluno();
    }

    @Operation(summary = "Retorna o aluno selecionado por sua matricula", description = "Utilize esta rota para consultar um aluno por sua matricula.")
    @GetMapping(path = "{matricula}")
    public Optional<Aluno> getAlunoByMatricula(@PathVariable("matricula") int matricula) throws IOException {
        return alunoService.getAlunoByMatricula(matricula);
    }

    @Operation(summary = "Remova um aluno do sistema", description = "Utilize esta rota para remover um aluno cadastrado.")
    @DeleteMapping(path = "{matricula}")
    public void deleteAluno(@PathVariable("matricula") int matricula) throws IOException {
        alunoService.deleteAluno(matricula);
    }

    @Operation(summary = "Altere um aluno", description = "Utilize esta rota para alterar os dados de um aluno.")
    @PutMapping
    public void updateAluno(@Valid @NonNull @RequestBody Aluno aluno) throws IOException {
        alunoService.updateAluno(aluno);
    }

    @Operation(summary = "Adiciona um aluno", description = "Utilize esta rota para adicionar um aluno.")
    @PostMapping
    public void insertAluno(@Valid @NonNull @RequestBody Aluno aluno) throws IOException {
        alunoService.insertAluno(aluno);
    }

    @Operation(summary = "Retorna todos os alunos aprovados de uma turma", description = "Utilize esta rota para consultar todos os alunos aprovados de uma turma.")
    @GetMapping(path = "/aluno/aprovado")
    @ResponseBody
    public List<AlunoAprovado> getAlunoAprovadoGroupByTurma( @Nullable Integer idTurma) throws IOException {
        return alunoService.getAlunoAprovadoGroupByTurma(idTurma);
    }
}
