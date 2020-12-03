package com.example.demo.api;


import com.example.demo.model.Disciplina;
import com.example.demo.service.DisciplinaService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/Disciplina")
@RestController
public class DisciplinaController {

    private final DisciplinaService disciplinaService;


    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public List<Disciplina> getAllDisciplina() throws IOException {
        return disciplinaService.getAllDisciplina();
    }

    @PostMapping
    public void insertDisciplina(@Valid @NonNull @RequestBody Disciplina disciplina) throws IOException {
        disciplinaService.insertDisciplina(disciplina);
    }
}
