package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunoTurmaResponse {

    private String alunoNome;
    private String turmaCodigo;

    public AlunoTurmaResponse(@JsonProperty("alunoNome") String alunoNome, @JsonProperty("turmaCodigo") String turmaCodigo) {
        this.alunoNome = alunoNome;
        this.turmaCodigo = turmaCodigo;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getTurmaCodigo() {
        return turmaCodigo;
    }

    public void setTurmaCodigo(String turmaCodigo) {
        this.turmaCodigo = turmaCodigo;
    }
}
