package com.example.demo.dao.Aluno;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import com.example.demo.model.Aluno;

import com.example.demo.model.AlunoAprovado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("postgresAluno")
public class AlunoDataAccessService implements AlunoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AlunoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertAluno(Aluno aluno) throws IOException {
        final String sql = "INSERT INTO aluno (Matricula, Nome) VALUES ('"
                + aluno.getMatricula() + "', '" + aluno.getNome() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Aluno> getAllAluno() throws IOException {
        final String sql = "SELECT Matricula, Nome, dataNascimento, dataMatricula, id FROM aluno;";
        List<Aluno> alunoList = jdbcTemplate.query(sql, (resultSet, i) -> {
            int matricula = Integer.parseInt(resultSet.getString("matricula"));
            int id = Integer.parseInt(resultSet.getString("id"));
            String nome = resultSet.getString("nome");
            Date dataNascimento = resultSet.getDate("dataNascimento");
            Date dataMatricula = resultSet.getDate("dataMatricula");

            return new Aluno(matricula, nome, dataNascimento, dataMatricula, id);
        });

        return alunoList;
    }

    @Override
    public Optional<Aluno> getAlunoByMatricula(int matricula) throws IOException {
        final String sql = "SELECT Matricula, Nome, dataNascimento, dataMatricula  FROM aluno WHERE aluno.Matricula = '" + matricula + "';";
        List<Aluno> alunoSelected = jdbcTemplate.query(sql, (resultSet, i) -> {
            int matriculaFound = Integer.parseInt(resultSet.getString("matricula"));
            int id = Integer.parseInt(resultSet.getString("id"));
            String nome = resultSet.getString("nome");
            Date dataNascimento = resultSet.getDate("dataNascimento");
            Date dataMatricula = resultSet.getDate("dataMatricula");

            return new Aluno(matricula, nome, dataNascimento, dataMatricula, id);
        });

        return alunoSelected.stream().findFirst();
    }

    @Override
    public void deleteAluno(int matricula) throws IOException {
        final String sql = "DELETE FROM aluno WHERE aluno.Matricula = '" + matricula + "';";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateAluno(Aluno aluno) throws IOException {
        final String sql = "UPDATE aluno SET Nome = '" + aluno.getNome() + "' WHERE aluno.Matricula = '" + aluno.getMatricula() + "';";
        jdbcTemplate.execute(sql);
    }

    @Override
    public List<AlunoAprovado> getAlunoAprovadoGroupByTurma() throws IOException {
        final String sql = "SELECT t.id as turmaId, a.id as alunoId, max(t.codigo) as codigoTurma, max(a.nome) as nomeAluno\n" +
                "FROM aluno a,\n" +
                "     turma t,\n" +
                "     aluno_turma al\n" +
                "where al.alunoid = a.id\n" +
                "  and t.id = al.turmaid\n" +
                "group by t.id, a.id\n" +
                "having avg(al.notatotal) > 60;";

        List<AlunoAprovado> alunoAprovadoList = jdbcTemplate.query(sql, (resultSet, i) -> {
            int turmaId = Integer.parseInt(resultSet.getString("turmaId"));
            int alunoId = Integer.parseInt(resultSet.getString("alunoId"));
            String nomeAluno = resultSet.getString("nomeAluno");
            String codigoTurma = resultSet.getString("codigoTurma");

            return new AlunoAprovado(turmaId, alunoId, codigoTurma, nomeAluno);
        });

        return alunoAprovadoList;
    }

}
