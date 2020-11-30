package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunoTurmaRequest {

    private int alunoId;
    private int turmaId;

    public AlunoTurmaRequest(@JsonProperty("alunoId") int alunoId, @JsonProperty("turmaId") int turmaId) {
        this.alunoId = alunoId;
        this.turmaId = turmaId;
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
}
