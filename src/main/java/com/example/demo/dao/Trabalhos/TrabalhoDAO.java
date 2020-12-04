package com.example.demo.dao.Trabalhos;

import java.io.IOException;

import com.example.demo.model.Trabalho;
import com.example.demo.model.TrabalhoCreateRequest;

public interface TrabalhoDAO {
    void insertTrabalho(TrabalhoCreateRequest trabalhoCreateRequest) throws IOException;

    void deleteTrabalho(int id) throws IOException;

    void updateTrabalho(float nota, int id) throws IOException;
}
