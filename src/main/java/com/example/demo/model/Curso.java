package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Curso {

    public final String codigo;
    public final int id;
    public final String nome;


    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    public Curso(
    @JsonProperty("codigo") String codigo, 
    @JsonProperty("nome") String nome, 
    @JsonProperty("id") int id) {
        this.codigo = codigo;
        this.nome = nome;
        this.id = id;
    }
}
