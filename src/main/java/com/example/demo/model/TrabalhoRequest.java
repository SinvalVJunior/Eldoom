package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrabalhoRequest {

    private int id;
    private float nota;

    public TrabalhoRequest(@JsonProperty("id")int id, @JsonProperty("nota") float nota) {
        this.id = id;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
