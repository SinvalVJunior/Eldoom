package com.example.demo.api;

import com.example.demo.model.Aluno;
import com.example.demo.model.AlunoAprovado;
import com.example.demo.service.AlunoService;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RequestMapping("api/v1/aluno")
@RestController
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping
    public List<Aluno> getAllAluno() throws IOException {
        return alunoService.getAllAluno();
    }

    @GetMapping(path = "{matricula}")
    public Optional<Aluno> getAlunoByMatricula(@PathVariable("matricula") int matricula) throws IOException {
        return alunoService.getAlunoByMatricula(matricula);
    }

    @DeleteMapping(path = "{matricula}")
    public void deleteAluno(@PathVariable("matricula") int matricula) throws IOException {
        alunoService.deleteAluno(matricula);
    }

    @PutMapping
    public void updateAluno(@Valid @NonNull @RequestBody Aluno aluno) throws IOException {
        alunoService.updateAluno(aluno);
    }

    @PostMapping
    public void insertAluno(@Valid @NonNull @RequestBody Aluno aluno) throws IOException {
        alunoService.insertAluno(aluno);
    }

    @GetMapping(path = "/aluno/aprovado")
    @ResponseBody
    public List<AlunoAprovado> getAlunoAprovadoGroupByTurma( @Nullable Integer idTurma) throws IOException {
        return alunoService.getAlunoAprovadoGroupByTurma(idTurma);
    }
}
