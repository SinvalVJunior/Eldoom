package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Avaliacao {
    private float nota;
    private int id;

    public Avaliacao(@JsonProperty("nota") float nota, @JsonProperty("id") int id) {
        this.nota = nota;
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
