package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Aluno {

    private final int matricula;
    private final int id;
    private String nome;
    private Date dataNascimento;
    private Date dataMatricula;

    public Aluno(
            @JsonProperty("matricula") int matricula,
            @JsonProperty("nome") String nome,
            @JsonProperty("dataNascimento") Date dataNascimento,
            @JsonProperty("dataMatricula") Date dataMatricula,
            @JsonProperty("id") int id
            ) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataMatricula = dataMatricula;
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getId() {
        return id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
