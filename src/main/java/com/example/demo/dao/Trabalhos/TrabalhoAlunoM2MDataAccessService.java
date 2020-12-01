package com.example.demo.dao.Trabalhos;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.TrabalhoAlunoM2M;
import com.example.demo.model.TrabalhoAlunoM2MResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgresTrabalhoAlunoM2M")
public class TrabalhoAlunoM2MDataAccessService implements TrabalhoAlunoM2MDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrabalhoAlunoM2MDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insertTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        final String sql = "INSERT INTO Trabalho_Aluno(AlunoId, TrabalhoId) VALUES ('"
                + trabalhoAlunoM2M.getAlunoId() + "', '" + trabalhoAlunoM2M.getTrabalhoId() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<TrabalhoAlunoM2MResponse> getAllTrabalhoAluno() throws IOException {
        final String sql = "SELECT a.Nome, t.Titulo FROM Trabalho_Aluno inner join aluno a on a.id = Trabalho_Aluno.AlunoId inner join trabalho t on t.id = Trabalho_Aluno.TrabalhoId;";
        List<TrabalhoAlunoM2MResponse> trabalhoAlunoList = jdbcTemplate.query(sql, (resultSet, i) -> {
            String alunoNome = resultSet.getString("nome");
            String trabalhoTitulo = resultSet.getString("titulo");


            return new TrabalhoAlunoM2MResponse(alunoNome, trabalhoTitulo);
        });

        return trabalhoAlunoList;
    }

    @Override
    public void deleteTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2M) throws IOException {
        final String sql = "DELETE FROM Trabalho_Aluno WHERE (Trabalho_Aluno.AlunoId = " + trabalhoAlunoM2M.getAlunoId() + " and Trabalho_Aluno.TrabalhoId = " + trabalhoAlunoM2M.getTrabalhoId() + ");";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateTrabalhoAluno(TrabalhoAlunoM2M trabalhoAlunoM2MNew, TrabalhoAlunoM2M trabalhoAlunoM2MOld) throws IOException {
        final String sql = "UPDATE Trabalho_Aluno SET AlunoId = " + trabalhoAlunoM2MNew.getAlunoId() + ", TrabalhoId = " + trabalhoAlunoM2MNew.getTrabalhoId() + " WHERE (Trabalho_Aluno.AlunoId = " + trabalhoAlunoM2MOld.getAlunoId() + " and Trabalho_Aluno.AlunoId = " + trabalhoAlunoM2MOld.getTrabalhoId() + " );";
        jdbcTemplate.execute(sql);
    }
}
