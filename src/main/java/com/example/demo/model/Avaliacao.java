package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Avaliacao {
    private float nota;
    private int id;
    private String dataAvaliacao;

    public Avaliacao(@JsonProperty("nota") float nota, @JsonProperty("id") int id, @JsonProperty("dataAvaliacao") String dataAvaliacao) {
        this.nota = nota;
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
