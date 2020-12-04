package com.example.demo.dao.Trabalhos;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.example.demo.model.Trabalho;

import com.example.demo.model.TrabalhoAlunoM2MResponse;
import com.example.demo.model.TrabalhoCreateRequest;
import com.example.demo.model.TrabalhoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("postgresTrabalho")
public class TrabalhoDataAccessService implements TrabalhoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrabalhoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertTrabalho(TrabalhoCreateRequest trabalhoCreateRequest) throws IOException {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        final String sql = "INSERT INTO trabalho ( Titulo, Conteudo, ProfessorId, DataEnvio, TurmaId) VALUES ('"
                + trabalhoCreateRequest.getTitulo() + "', '" + trabalhoCreateRequest.getConteudo() + "' , " + trabalhoCreateRequest.getProfessorId() + " , '"
                + nowAsISO + "' , "+ trabalhoCreateRequest.getTurmaid() + " ) RETURNING id; ";

        List<Integer> newTrabalhoId = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer trabalhoId = Integer.parseInt(resultSet.getString("id"));
            return trabalhoId;
        });


        trabalhoCreateRequest.getAlunoList().forEach( alunoId -> {
            String sqlInsertAlunoTrabalho = "INSERT INTO aluno_trabalho (alunoid, trabalhoid) VALUES (" + alunoId + ", " + newTrabalhoId + ");";
            System.out.println(sqlInsertAlunoTrabalho);
            jdbcTemplate.execute(sqlInsertAlunoTrabalho);
        });

    }

    @Override
    public void deleteTrabalho(int id) throws IOException {
        final String sql = "DELETE FROM trabalho WHERE trabalho.id = " + id + ";";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateTrabalho(float nota, int id) throws IOException {
        final String sql = "UPDATE trabalho SET Nota = " + nota + " WHERE id = " + id + ";";
        jdbcTemplate.execute(sql);
    }
}
