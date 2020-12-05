package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
public class TrabalhoAlunoM2MResponse {

    private String alunoNome;
    private String trabalhoTitulo;
    private Date dataEnvio;
    private Date DataAvaliacao;
    private float nota;

    public TrabalhoAlunoM2MResponse(@JsonProperty("alunoNome") String alunoNome,@JsonProperty("trabalhoTitulo") String trabalhoTitulo,@JsonProperty("dataEnvio") Date dataEnvio, @JsonProperty("dataAvaliacao") Date dataAvaliacao, @JsonProperty("nota") float nota) {
        this.alunoNome = alunoNome;
        this.trabalhoTitulo = trabalhoTitulo;
        DataAvaliacao = dataAvaliacao;
        this.dataEnvio = dataEnvio;
        this.nota = nota;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getTrabalhoTitulo() {
        return trabalhoTitulo;
    }

    public void setTrabalhoTitulo(String trabalhoTitulo) {
        this.trabalhoTitulo = trabalhoTitulo;
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
        return nota;
    }

    public void setNota(float nota) {
        nota = nota;
    }
}