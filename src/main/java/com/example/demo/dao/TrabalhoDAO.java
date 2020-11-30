package com.example.demo.dao;

import com.example.demo.model.Trabalho;
import com.example.demo.model.Turma;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TrabalhoDAO {
    void insertTrabalho(Trabalho trabalho) throws IOException;

    void deleteTrabalho(int id) throws IOException;

    void updateTrabalho(float nota, int id) throws IOException;
}
