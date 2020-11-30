package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrabalhoAlunoM2MResponse {

    private String alunoNome;
    private String trabalhoTitulo;

    public TrabalhoAlunoM2MResponse(@JsonProperty("alunoNome") String alunoNome,@JsonProperty("trabalhoTitulo") String trabalhoTitulo) {
        this.alunoNome = alunoNome;
        this.trabalhoTitulo = trabalhoTitulo;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getTrabalhoTitulo() {
        return trabalhoTitulo;
    }

    public void setTrabalhoTitulo(String trabalhoTitulo) {
        this.trabalhoTitulo = trabalhoTitulo;
    }
}
