package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Trabalho {

    private String titulo;
    private String Conteudo;
    private int professorId;
    private Date dataEnvio;
    private Date DataAvaliacao;
    private float Nota;

    public Trabalho(@JsonProperty("titulo") String titulo, @JsonProperty("conteudo") String conteudo,
                    @JsonProperty("professorId") int professorId, @JsonProperty("dataEnvio") Date dataEnvio,
                    @JsonProperty("dataAvaliacao") Date dataAvaliacao, @JsonProperty("nota") float nota) {
        this.titulo = titulo;
        Conteudo = conteudo;
        this.professorId = professorId;
        this.dataEnvio = dataEnvio;
        DataAvaliacao = dataAvaliacao;
        Nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String conteudo) {
        Conteudo = conteudo;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Date getDataAvaliacao() {
        return DataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        DataAvaliacao = dataAvaliacao;
    }

    public float getNota() {
        return Nota;
    }

    public void setNota(float nota) {
        Nota = nota;
    }
}
