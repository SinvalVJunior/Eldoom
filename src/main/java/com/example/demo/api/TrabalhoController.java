package com.example.demo.api;


import com.example.demo.model.Trabalho;
import com.example.demo.model.TrabalhoRequest;
import com.example.demo.service.TrabalhoService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("api/v1/trabalho")
@RestController
public class TrabalhoController {

    private final TrabalhoService trabalhoService;


    public TrabalhoController(TrabalhoService trabalhoService) {
        this.trabalhoService = trabalhoService;
    }

    @PostMapping
    public void insereTrabalho(@Valid @NonNull @RequestBody Trabalho trabalho) throws IOException {
        trabalhoService.insertTrabalho(trabalho);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTrabalho(@PathVariable("id") int id) throws IOException {
        trabalhoService.deleteTrabalho(id);
    }

    @PutMapping
    public void updateTrabalho(TrabalhoRequest trabalhoRequest ) throws IOException {
        trabalhoService.updateTrabalho(trabalhoRequest.getNota(), trabalhoRequest.getId());
    }

}
