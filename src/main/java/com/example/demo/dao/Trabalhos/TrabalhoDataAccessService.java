package com.example.demo.dao.Trabalhos;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.example.demo.model.*;

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
            String sqlInsertAlunoTrabalho = "INSERT INTO trabalho_aluno (alunoid, trabalhoid) VALUES (" + alunoId + ", " + newTrabalhoId.get(0) + ");";
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
    public void avaliarTrabalho(Avaliacao avaliacao) throws IOException {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        final String sql = "UPDATE trabalho SET Nota = " + avaliacao.getNota() + " , dataavaliacao = '"+ nowAsISO + "' WHERE id = " + avaliacao.getId() + ";";
        System.out.println(sql);
        jdbcTemplate.execute(sql);
    }


    @Override
    public List<TrabalhoAlunoM2MResponse> getTrabalhoAuthors() throws IOException {
        final String sql = "SELECT a.Nome, t.Titulo FROM Trabalho_Aluno inner join aluno a on a.id = Trabalho_Aluno.AlunoId inner join trabalho t on t.id = Trabalho_Aluno.TrabalhoId;";
        List<TrabalhoAlunoM2MResponse> trabalhoAlunoList = jdbcTemplate.query(sql, (resultSet, i) -> {
            String alunoNome = resultSet.getString("nome");
            String trabalhoTitulo = resultSet.getString("titulo");


            return new TrabalhoAlunoM2MResponse(alunoNome, trabalhoTitulo);
        });
        return trabalhoAlunoList;
    }

    @Override
    public void addTrabalhoAlthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        final String sql = "INSERT INTO Trabalho_Aluno(AlunoId, TrabalhoId) VALUES ('"
                + trabalhoAlunoM2M.getAlunoId() + "', '" + trabalhoAlunoM2M.getTrabalhoId() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public void removeTrabalhoAuthor(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        final String sql = "DELETE FROM Trabalho_Aluno WHERE (Trabalho_Aluno.AlunoId = " + trabalhoAlunoM2M.getAlunoId() + " and Trabalho_Aluno.TrabalhoId = " + trabalhoAlunoM2M.getTrabalhoId() + ");";
        jdbcTemplate.execute(sql);
    }
}
