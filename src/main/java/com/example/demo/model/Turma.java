package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Turma {


    private final String codigo;
    private final int professorId;
    private final int id;
    private final Float medianotaturma;
    private final String professorNome;
    private final int disciplinaId;

    public Turma(@JsonProperty("codigo") String codigo, @JsonProperty("professorId") int professorId, @JsonProperty("id") int id, @JsonProperty("medianotaturma") Float medianotaturma, @JsonProperty("nome") String nome, @JsonProperty("disciplinaId") int disciplinaId) {
        this.codigo = codigo;
        this.professorId = professorId;
        this.id = id;
        this.medianotaturma = medianotaturma;
        this.professorNome = nome;
        this.disciplinaId = disciplinaId;
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

    public int getId() {
        return id;
    }

    public float getMedianotaturma() {
        return medianotaturma;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }
}
