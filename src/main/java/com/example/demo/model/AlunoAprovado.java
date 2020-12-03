package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunoAprovado {

    private int trabalhoId;
    private int alunoId;
    private String codigoTurma;
    private String nomeAluno;

    public AlunoAprovado(@JsonProperty("turmaId") int turmaId,@JsonProperty("alunoId") int alunoId,
                         @JsonProperty("codigoTurma") String codigoTurma, @JsonProperty("nomeAluno") String nomeAluno) {
        this.trabalhoId = trabalhoId;
        this.alunoId = alunoId;
        this.codigoTurma = codigoTurma;
        this.nomeAluno = nomeAluno;
    }

    public int getTrabalhoId() {
        return trabalhoId;
    }

    public void setTrabalhoId(int trabalhoId) {
        this.trabalhoId = trabalhoId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
