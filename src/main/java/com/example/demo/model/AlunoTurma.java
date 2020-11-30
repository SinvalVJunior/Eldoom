package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunoTurma {

    private int alunoId;
    private int turmaId;
    private float notaTotal;

    public AlunoTurma(@JsonProperty("alunoId") int alunoId, @JsonProperty("turmaId") int turmaId, @JsonProperty("notaTotal") float notaTotal) {
        this.alunoId = alunoId;
        this.turmaId = turmaId;
        this.notaTotal = notaTotal;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public float getNotaTotal() {
        return notaTotal;
    }

    public void setNotaTotal(float notaTotal) {
        this.notaTotal = notaTotal;
    }
}
