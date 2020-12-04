package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Turma {


    private final String codigo;
    private final int professorId;
    private final String professorNome;

    public Turma(@JsonProperty("codigo") String codigo, @JsonProperty("professorId") int professorId, @JsonProperty("nome") String nome) {
        this.codigo = codigo;
        this.professorId = professorId;
        this.professorNome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public int getProfessorId() {
        return professorId;
    }
}
