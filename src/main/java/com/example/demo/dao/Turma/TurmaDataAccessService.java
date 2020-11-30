package com.example.demo.dao.Turma;

import com.example.demo.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository("postgresTurma")
public class TurmaDataAccessService implements TurmaDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TurmaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insertTurma(Turma turma) throws IOException {

        final String sql = "INSERT INTO turma ( Codigo, ProfessorId) VALUES ('"
                + turma.getCodigo() + "', '" + turma.getProfessorId() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Turma> getAllTurma() throws IOException {
        final String sql = "SELECT Codigo, ProfessorId FROM turma;";
        List<Turma> turmaList = jdbcTemplate.query(sql, (resultSet, i) -> {
            int professorId = Integer.parseInt(resultSet.getString("professorId"));
            String codigo = resultSet.getString("codigo");

            return new Turma(codigo, professorId);
        });

        return turmaList;
    }


    @Override
    public Optional<Turma> getTurmaByCodigo(String codigo) throws IOException {
        final String sql = "SELECT Codigo, ProfessorId FROM turma WHERE turma.Codigo = '" + codigo + "';";
        List<Turma> turmaSelected = jdbcTemplate.query(sql, (resultSet, i) -> {
            String codigoFound = resultSet.getString("codigo");
            int professorId = Integer.parseInt(resultSet.getString("professorId"));
            return new Turma(codigoFound, professorId);
        });

        return turmaSelected.stream().findFirst();
    }

    @Override
    public void deleteTurma(String codigo) throws IOException {
        final String sql = "DELETE FROM turma WHERE turma.Codigo = '" + codigo + "';";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateTurma(Turma turma) throws IOException {
        final String sql = "UPDATE turma SET ProfessorId = '" + turma.getProfessorId() + "' WHERE turma.Codigo = '" + turma.getCodigo() + "';";
        jdbcTemplate.execute(sql);
    }
}
