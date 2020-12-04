package com.example.demo.api;


import com.example.demo.model.*;
import com.example.demo.service.TrabalhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Tag( name = "Trabalhos", description = "API para gerenciamento dos trabalhos")
@RequestMapping("api/v1/trabalho")
@RestController
public class TrabalhoController {

    private final TrabalhoService trabalhoService;


    public TrabalhoController(TrabalhoService trabalhoService) {
        this.trabalhoService = trabalhoService;
    }

    @Operation(summary = "Adiciona um trabalho", description = "Utilize esta rota para adicionar um trabalho.")
    @PostMapping
    public void cadastrarTrabalho(@Valid @NonNull @RequestBody TrabalhoCreateRequest trabalhoCreateRequest) throws IOException {
        trabalhoService.insertTrabalho(trabalhoCreateRequest);
    }

    @Operation(summary = "Remova um trabalho do sistema", description = "Utilize esta rota para remover um trabalho cadastrado.")
    @DeleteMapping(path = "{id}")
    public void deleteTrabalho(@PathVariable("id") int id) throws IOException {
        trabalhoService.deleteTrabalho(id);
    }

    @Operation(summary = "Avalia um trabalho", description = "Utilize esta rota para avaliar um trabalho.")
    @PutMapping
    public void avaliarTrabalho(@Valid @NonNull @RequestBody Avaliacao avaliacao ) throws IOException {
        trabalhoService.avaliarTrabalho(avaliacao);
    }

    @Operation(summary = "Retorna todos os autores e seus trabalhos", description = "Utilize esta rota para consultar todos os autores e seus trabalhos cadastrados.")
    @GetMapping(path = "/autores")
    public List<TrabalhoAlunoM2MResponse> getTrabalhoAuthors() throws IOException {
        return trabalhoService.getTrabalhoAuthors();
    }

    @Operation(summary = "Adiciona um autor", description = "Utilize esta rota para adicionar um autor para um trabalho.")
    @PostMapping(path = "/autores")
    public void addTrabalhoAlthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoService.addTrabalhoAlthor(trabalhoAlunoM2M);
    }
    @Operation(summary = "Remova um autor de um trabalho", description = "Utilize esta rota para remover um autor de um trabalho cadastrado.")
    @DeleteMapping(path = "/autores")
    public void removeTrabalhoAuthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoService.removeTrabalhoAuthor(trabalhoAlunoM2M);
    }

}
