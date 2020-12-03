package com.example.demo.dao.Professor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import com.example.demo.model.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgresProfessor")
public class ProfessorDataAccessService implements ProfessorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfessorDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insertProfessor(Professor professor) throws IOException {
        final String sql = "INSERT INTO professor (Nome) VALUES ('"
                + professor.getNome() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Professor> getAllProfessor() throws IOException {
        final String sql = "SELECT Nome, dataNascimento, id FROM professor;";
        List<Professor> professorList = jdbcTemplate.query(sql, (resultSet, i) -> {
            String nome = resultSet.getString("nome");
            Date dataNascimento = resultSet.getDate("dataNascimento");
            int id = Integer.parseInt(resultSet.getString("id"));

            return new Professor(nome, id, dataNascimento);
        });

        return professorList;
    }

    @Override
    public Optional<Professor> getProfessorById(int id) throws IOException {
        final String sql = "SELECT Nome, dataNascimento, id as idProfessor FROM professor WHERE professor.id = " + id + ";";
        List<Professor> professorSelected = jdbcTemplate.query(sql, (resultSet, i) -> {
            String nome = resultSet.getString("nome");
            Date dataNascimento = resultSet.getDate("dataNascimento");
            int idProfessor = Integer.parseInt(resultSet.getString("idProfessor"));

            return new Professor(nome, idProfessor, dataNascimento);
        });

        return professorSelected.stream().findFirst();
    }

    @Override
    public void deleteProfessor(int id) throws IOException {
        final String sql = "DELETE FROM professor WHERE professor.id = " + id + ";";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateProfessor(Professor professor, int id) throws IOException {
        final String sql = "UPDATE professor SET Nome = '" + professor.getNome() + "' WHERE professor.id = " + id + ";";
        jdbcTemplate.execute(sql);
    }
}
