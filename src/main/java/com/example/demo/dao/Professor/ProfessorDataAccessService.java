package com.example.demo.dao.Professor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
        final String sql = "SELECT Nome FROM professor;";
        List<Professor> professorList = jdbcTemplate.query(sql, (resultSet, i) -> {
            String nome = resultSet.getString("nome");

            return new Professor(nome);
        });

        return professorList;
    }

    @Override
    public Optional<Professor> getProfessorById(int id) throws IOException {
        final String sql = "SELECT Nome FROM professor WHERE professor.id = " + id + ";";
        List<Professor> professorSelected = jdbcTemplate.query(sql, (resultSet, i) -> {
            String nome = resultSet.getString("nome");
            return new Professor(nome);
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
