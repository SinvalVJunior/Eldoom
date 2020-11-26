package com.example.demo.api;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


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
}
