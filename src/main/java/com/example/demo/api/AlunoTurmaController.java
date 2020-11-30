package com.example.demo.api;


import com.example.demo.model.AlunoTurma;
import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.AlunoTurmaResponse;
import com.example.demo.service.AlunoTurmaService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("api/v1/alunoTurma")
@RestController
public class AlunoTurmaController {

    private final AlunoTurmaService alunoTurmaService;

    public AlunoTurmaController(AlunoTurmaService alunoTurmaService) {
        this.alunoTurmaService = alunoTurmaService;
    }


    @PostMapping
    public void insertAlunoTurma(AlunoTurma alunoTurma) throws IOException {
        alunoTurmaService.insertAlunoTurma(alunoTurma);
    }

    @DeleteMapping
    public void deleteAlunoTurma(AlunoTurmaRequest alunoTurmaRequest) throws IOException {
        alunoTurmaService.deleteAlunoTurma(alunoTurmaRequest);
    }

    @PutMapping
    public void updateAlunoTurma(AlunoTurma alunoTurmaNew, AlunoTurma alunoTurmaOld) throws IOException {
        alunoTurmaService.updateAlunoTurma(alunoTurmaNew, alunoTurmaOld);
    }

    @GetMapping
    public List<AlunoTurmaResponse> getAllAlunoTurma() throws IOException {
        return alunoTurmaService.getAllAlunoTurma();
    }

}
