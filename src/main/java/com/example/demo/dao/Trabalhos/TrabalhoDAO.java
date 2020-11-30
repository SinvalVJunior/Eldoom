package com.example.demo.dao.Trabalhos;

import java.io.IOException;

import com.example.demo.model.Trabalho;

public interface TrabalhoDAO {
    void insertTrabalho(Trabalho trabalho) throws IOException;

    void deleteTrabalho(int id) throws IOException;

    void updateTrabalho(float nota, int id) throws IOException;
}
