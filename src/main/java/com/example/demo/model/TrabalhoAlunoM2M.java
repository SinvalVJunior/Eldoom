package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrabalhoAlunoM2M {

    private int alunoId;
    private int trabalhoId;

    public TrabalhoAlunoM2M(@JsonProperty("alunoId") int alunoId, @JsonProperty("trabalhoId") int trabalhoId) {
        this.alunoId = alunoId;
        this.trabalhoId = trabalhoId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getTrabalhoId() {
        return trabalhoId;
    }

    public void setTrabalhoId(int trabalhoId) {
        this.trabalhoId = trabalhoId;
    }
}
