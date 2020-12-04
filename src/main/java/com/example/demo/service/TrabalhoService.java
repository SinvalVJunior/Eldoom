package com.example.demo.service;

import java.io.IOException;

import com.example.demo.dao.Trabalhos.TrabalhoDAO;
import com.example.demo.model.Avaliacao;
import com.example.demo.model.Trabalho;

import com.example.demo.model.TrabalhoCreateRequest;
import com.example.demo.model.TrabalhoRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TrabalhoService {

    public final TrabalhoDAO trabalhoDAO;


    public TrabalhoService(@Qualifier("postgresTrabalho") TrabalhoDAO trabalhoDAO) {
        this.trabalhoDAO = trabalhoDAO;
    }

    public void insertTrabalho(TrabalhoCreateRequest trabalhoCreateRequest) throws IOException {
        trabalhoDAO.insertTrabalho(trabalhoCreateRequest);
    }

    public void deleteTrabalho(int id) throws IOException {
        trabalhoDAO.deleteTrabalho(id);
    }

    public void avaliarTrabalho(Avaliacao avaliacao) throws IOException {
        trabalhoDAO.avaliarTrabalho(avaliacao);
    }

}
