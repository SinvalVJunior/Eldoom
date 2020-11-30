package com.example.demo.dao.Trabalhos;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.TrabalhoAlunoM2M;
import com.example.demo.model.TrabalhoAlunoM2MResponse;

public interface TrabalhoAlunoM2MDAO {

    void insertTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException;

    List<TrabalhoAlunoM2MResponse> getAllTrabalhoAluno() throws IOException;

    void deleteTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException;

    void updateTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2MNew, TrabalhoAlunoM2M trabalhoAlunoM2MOld) throws IOException;

}
