package com.example.demo.api;


import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Tag( name = "Cursos", description = "API para gerenciamento dos cursos")
@RequestMapping("api/v1/Curso")
@RestController
public class CursoController {

    private final CursoService CursoService;


    public CursoController(CursoService CursoService) {
        this.CursoService = CursoService;
    }

    @Operation(summary = "Retorna todos os cursos", description = "Utilize esta rota para consultar todos os cursos cadastrados.")
    @GetMapping
    public List<Curso> getAllCurso() throws IOException {
        return CursoService.getAllCurso();
    }

    @Operation(summary = "Adiciona um curso", description = "Utilize esta rota para adicionar um curso.")
    @PostMapping
    public void insertCurso(@Valid @NonNull @RequestBody Curso Curso) throws IOException {
        CursoService.insertCurso(Curso);
    }

    @Operation(summary = "Altere um curso", description = "Utilize esta rota para alterar os dados de um curso.")
    @PutMapping(path = "{id}")
    public void updateCurso(@RequestBody Curso cursoNew, @RequestParam int id) throws IOException {
        CursoService.updateCurso(cursoNew, id);
    }

    @Operation(summary = "Remova um curso do sistema", description = "Utilize esta rota para remover um curso cadastrado.")
    @DeleteMapping(path = "{id}")
    public void deleteCurso(@RequestParam int id) throws IOException {
        CursoService.deleteCurso(id);
    }
}
