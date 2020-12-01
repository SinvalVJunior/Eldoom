package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.dao.Trabalhos.TrabalhoAlunoM2MDAO;
import com.example.demo.model.TrabalhoAlunoM2M;
import com.example.demo.model.TrabalhoAlunoM2MResponse;

import org.springframework.stereotype.Service;

@Service
public class TrabalhoAlunoM2MService {

    public final TrabalhoAlunoM2MDAO trabalhoAlunoM2MDAO;

    public TrabalhoAlunoM2MService(TrabalhoAlunoM2MDAO trabalhoAlunoM2MDAO) {
        this.trabalhoAlunoM2MDAO = trabalhoAlunoM2MDAO;
    }


    public void inserTrabalhoAlunoM2M(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoAlunoM2MDAO.insertTrabalhoAluno(trabalhoAlunoM2M);
    }

    public void updateTrabalhoAlunoM2M(TrabalhoAlunoM2M trabalhoAlunoM2MNew, TrabalhoAlunoM2M trabalhoAlunoM2MOld) throws IOException {
        trabalhoAlunoM2MDAO.updateTrabalhoAluno(trabalhoAlunoM2MNew, trabalhoAlunoM2MOld);
    }

    public void deleteTrabalhoAlunoM2M(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoAlunoM2MDAO.deleteTrabalhoAluno(trabalhoAlunoM2M);
    }

    public List<TrabalhoAlunoM2MResponse> getAllTrabalhoM2M() throws IOException {
        return trabalhoAlunoM2MDAO.getAllTrabalhoAluno();
    }


}
