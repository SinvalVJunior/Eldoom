package com.example.demo.dao;

import com.example.demo.model.Trabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository("postgresTrabalho")
public class TrabalhoDataAccessService implements TrabalhoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrabalhoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insertTrabalho(Trabalho trabalho) throws IOException {
        final String sql = "INSERT INTO trabalho ( \"Titulo\", \"Conteudo\", \"ProfessorId\", \"DataEnvio\", \"DataAvaliacao\", \"Nota\") VALUES ('"
                + trabalho.getTitulo() + "', '" + trabalho.getConteudo() + "' , '" + trabalho.getProfessorId() + "', '"
                + trabalho.getDataEnvio() + "' , '" + trabalho.getDataAvaliacao() + "' , '" + trabalho.getNota() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public void deleteTrabalho(int id) throws IOException {
        final String sql = "DELETE FROM trabalho WHERE trabalho.id = " + id + ";";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateTrabalho(float nota, int id) throws IOException {
        final String sql = "UPDATE trabalho SET \"Nota\" = " + nota + " WHERE id = " + id + ";";
        jdbcTemplate.execute(sql);
    }
}
