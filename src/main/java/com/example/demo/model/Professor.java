package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Professor {

    public final String nome;
    public final int id;
    public final Date dataNascimento;


    public String getNome() {
        return nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public int getId() {
        return id;
    }

    public Professor(@JsonProperty("nome") String nome, @JsonProperty("id") int idProfessor, @JsonProperty("dataNascimento") Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento =  dataNascimento;
        this.id = idProfessor;
    }
}
