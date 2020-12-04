package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.dao.Trabalhos.TrabalhoDAO;
import com.example.demo.model.*;

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

    public List<TrabalhoAlunoM2MResponse> getTrabalhoAuthors() throws IOException {
        return trabalhoDAO.getTrabalhoAuthors();
    }

    public void addTrabalhoAlthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoDAO.addTrabalhoAlthor(trabalhoAlunoM2M);
    }

    public void removeTrabalhoAuthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        trabalhoDAO.removeTrabalhoAuthor(trabalhoAlunoM2M);
    }
}
