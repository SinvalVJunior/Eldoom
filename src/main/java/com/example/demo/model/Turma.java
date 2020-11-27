package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Turma {


    private final String codigo;
    private final int professorId;

    public Turma(@JsonProperty("codigo") String codigo, @JsonProperty("professorId") long professorId) {
        this.codigo = codigo;
        this.professorId = professorId;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getProfessorId() {
        return professorId;
    }
}
