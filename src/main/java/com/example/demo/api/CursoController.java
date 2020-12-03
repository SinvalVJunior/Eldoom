package com.example.demo.api;


import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/Curso")
@RestController
public class CursoController {

    private final CursoService CursoService;


    public CursoController(CursoService CursoService) {
        this.CursoService = CursoService;
    }

    @GetMapping
    public List<Curso> getAllCurso() throws IOException {
        return CursoService.getAllCurso();
    }

    @PostMapping
    public void insertCurso(@Valid @NonNull @RequestBody Curso Curso) throws IOException {
        CursoService.insertCurso(Curso);
    }
}
