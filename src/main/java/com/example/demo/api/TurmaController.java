package com.example.demo.api;


import com.example.demo.model.Turma;
import com.example.demo.service.TurmaService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/turma")
@RestController
public class TurmaController {

    private final TurmaService turmaService;


    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Turma> getAllTurma() throws IOException {
        return turmaService.getAllTurma();
    }

    @GetMapping(path = "{codigo}")
    public Optional<Turma> getTurmaByCodigo(@PathVariable("codigo") String codigo) throws IOException {
        return turmaService.getTurmaByCodigo(codigo);
    }

    @DeleteMapping(path = "{codigo}")
    public void deleteTurma(@PathVariable("codigo") String codigo) throws IOException {
        turmaService.deleteTurma(codigo);
    }

    @PutMapping
    public void updateTurma(@Valid @NonNull @RequestBody Turma turma) throws IOException {
        turmaService.updateTurma(turma);
    }

    @PostMapping
    public void insertTurma(@Valid @NonNull @RequestBody Turma turma) throws IOException {
        turmaService.insertTurma(turma);
    }
}
