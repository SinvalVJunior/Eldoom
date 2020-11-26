package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aluno {

    private final int matricula;
    private String nome;

    public Aluno(
            @JsonProperty("matricula") int matricula,
            @JsonProperty("nome") String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
