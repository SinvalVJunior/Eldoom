package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Disciplina {

    public final String codigo;
    public final int id;
    public final String descricao;
    public final String nome;
    public final int cursoId;


    public String getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public int getCursoId() {
        return cursoId;
    }

    public Disciplina(
    @JsonProperty("codigo") String codigo, 
    @JsonProperty("nome") String nome, 
    @JsonProperty("id") int id, 
    @JsonProperty("descricao") String descricao, 
    @JsonProperty("cursoId") int cursoId) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao =  descricao;
        this.id = id;
        this.cursoId = cursoId;
    }
}
