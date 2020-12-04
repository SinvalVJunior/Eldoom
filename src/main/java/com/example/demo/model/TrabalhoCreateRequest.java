package com.example.demo.model;

import java.util.List;

public class TrabalhoCreateRequest {

    private String titulo;
    private String conteudo;
    private int professorId;
    private List<Integer> alunoList;
    private int turmaid;

    public TrabalhoCreateRequest(String titulo, String conteudo, int professorId, List<Integer> alunoList, int turmaid) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.professorId = professorId;
        this.alunoList = alunoList;
        this.turmaid = turmaid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public List<Integer> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Integer> alunoList) {
        this.alunoList = alunoList;
    }

    public int getTurmaid() {
        return turmaid;
    }

    public void setTurmaid(int turmaid) {
        this.turmaid = turmaid;
    }
}
