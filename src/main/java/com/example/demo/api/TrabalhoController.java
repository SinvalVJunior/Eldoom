package com.example.demo.api;


import com.example.demo.model.*;
import com.example.demo.service.TrabalhoService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequestMapping("api/v1/trabalho")
@RestController
public class TrabalhoController {

    private final TrabalhoService trabalhoService;


    public TrabalhoController(TrabalhoService trabalhoService) {
        this.trabalhoService = trabalhoService;
    }

    @PostMapping
    public void cadastrarTrabalho(@Valid @NonNull @RequestBody TrabalhoCreateRequest trabalhoCreateRequest) throws IOException {
        trabalhoService.insertTrabalho(trabalhoCreateRequest);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTrabalho(@PathVariable("id") int id) throws IOException {
        trabalhoService.deleteTrabalho(id);
    }

    @PutMapping
    public void avaliarTrabalho(@Valid @NonNull @RequestBody Avaliacao avaliacao ) throws IOException {
        trabalhoService.avaliarTrabalho(avaliacao);
    }

    @GetMapping(path = "/authors")
    public List<TrabalhoAlunoM2MResponse> getTrabalhoAuthors() throws IOException {
        return trabalhoService.getTrabalhoAuthors();
    }

    @PostMapping(path = "/authors")
    public void addTrabalhoAlthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoService.addTrabalhoAlthor(trabalhoAlunoM2M);
    }

    @DeleteMapping(path = "/authors")
    public void removeTrabalhoAuthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoService.removeTrabalhoAuthor(trabalhoAlunoM2M);
    }

}
