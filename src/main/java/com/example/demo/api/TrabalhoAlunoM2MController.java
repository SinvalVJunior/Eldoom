package com.example.demo.api;

import com.example.demo.model.TrabalhoAlunoM2M;
import com.example.demo.model.TrabalhoAlunoM2MResponse;
import com.example.demo.service.TrabalhoAlunoM2MService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RequestMapping("api/v1/trabalhoAluno")
@RestController
public class TrabalhoAlunoM2MController {

    private final TrabalhoAlunoM2MService trabalhoAlunoM2MService;

    public TrabalhoAlunoM2MController(TrabalhoAlunoM2MService trabalhoAlunoM2MService) {
        this.trabalhoAlunoM2MService = trabalhoAlunoM2MService;
    }

    @GetMapping
    public List<TrabalhoAlunoM2MResponse> getAllTrabalhoAlunoM2M() throws IOException {
        return trabalhoAlunoM2MService.getAllTrabalhoM2M();
    }

    @PostMapping
    public void insertTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoAlunoM2MService.inserTrabalhoAlunoM2M(trabalhoAlunoM2M);
    }

    @PutMapping
    public void updateTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2MNew, TrabalhoAlunoM2M trabalhoAlunoM2MOld) throws IOException {
        trabalhoAlunoM2MService.updateTrabalhoAlunoM2M(trabalhoAlunoM2MNew, trabalhoAlunoM2MOld);
    }

    @DeleteMapping
    public void deleteTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoAlunoM2MService.deleteTrabalhoAlunoM2M(trabalhoAlunoM2M);
    }
}
