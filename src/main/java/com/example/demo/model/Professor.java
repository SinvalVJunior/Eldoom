package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Professor {

    public String getNome() {
        return nome;
    }

    public final String nome;


    public Professor(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }
}
