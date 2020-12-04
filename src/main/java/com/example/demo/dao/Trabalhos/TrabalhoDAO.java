package com.example.demo.dao.Trabalhos;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.*;

public interface TrabalhoDAO {
    void insertTrabalho(TrabalhoCreateRequest trabalhoCreateRequest) throws IOException;

    void deleteTrabalho(int id) throws IOException;

    void avaliarTrabalho(Avaliacao avaliacao) throws IOException;

    List<TrabalhoAlunoM2MResponse> getTrabalhoAuthors() throws IOException;

    void addTrabalhoAlthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException;

    void removeTrabalhoAuthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException;

}
