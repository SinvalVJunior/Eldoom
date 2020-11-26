package com.example.demo.dao;

import com.example.demo.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository("postgresAluno")
public class AlunoDataAccessService implements AlunoDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AlunoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertAluno(Aluno aluno) throws IOException{
        final String sql = "INSERT INTO aluno ( \"Matricula\", \"Nome\") VALUES ('"
                + aluno.getMatricula() + "', '" + aluno.getNome() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Aluno> getAllAluno()  throws IOException{
        final String sql = "SELECT \"Matricula\", \"Nome\" FROM aluno;";
        List<Aluno> alunoList = jdbcTemplate.query(sql, (resultSet, i) -> {
            int matricula = Integer.parseInt(resultSet.getString("matricula"));
            String nome = resultSet.getString("nome");

            return new Aluno(matricula, nome);
        });

        return alunoList;    }

    @Override
    public Optional<Aluno> getAlunoByMatricula(int matricula)  throws IOException{
        final String sql = "SELECT \"Matricula\", \"Nome\" FROM aluno WHERE aluno.\"Matricula\" = '" + matricula + "';";
        List<Aluno> alunoSelected = jdbcTemplate.query(sql, (resultSet, i) -> {
            int matriculaFound = Integer.parseInt(resultSet.getString("matricula"));
            String nome = resultSet.getString("nome");
            return new Aluno(matriculaFound, nome);
        });

        return alunoSelected.stream().findFirst();    }

    @Override
    public void deleteAluno(int matricula)  throws IOException{
        final String sql = "DELETE FROM aluno WHERE aluno.\"Matricula\" = '" + matricula + "';";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateAluno(Aluno aluno)  throws IOException{
        final String sql = "UPDATE aluno SET \"Nome\" = '" + aluno.getNome() + "' WHERE aluno.\"Matricula\" = '" + aluno.getMatricula() + "';";
        jdbcTemplate.execute(sql);
    }
}
