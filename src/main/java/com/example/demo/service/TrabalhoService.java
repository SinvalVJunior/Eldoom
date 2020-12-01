package com.example.demo.service;

import java.io.IOException;

import com.example.demo.dao.Trabalhos.TrabalhoDAO;
import com.example.demo.model.Trabalho;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TrabalhoService {

    public final TrabalhoDAO trabalhoDAO;


    public TrabalhoService(@Qualifier("postgresTrabalho") TrabalhoDAO trabalhoDAO) {
        this.trabalhoDAO = trabalhoDAO;
    }

    public void insertTrabalho(Trabalho trabalho) throws IOException {
        trabalhoDAO.insertTrabalho(trabalho);
    }

    public void deleteTrabalho(int id) throws IOException {
        trabalhoDAO.deleteTrabalho(id);
    }

    public void updateTrabalho(float nota, int id) throws IOException {
        trabalhoDAO.updateTrabalho(nota, id);
    }

}
