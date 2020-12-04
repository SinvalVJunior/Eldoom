package com.example.demo.dao.Curso;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import com.example.demo.model.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("postgresCurso")
public class CursoDataAccessService implements CursoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CursoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertCurso(Curso curso) throws IOException {
        final String sql = "INSERT INTO Curso (codigo, nome) VALUES ('"
                + curso.getCodigo() + "', '" + curso.getNome() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Curso> getAllCurso() throws IOException {
        final String sql = "SELECT id, codigo, nome FROM Curso;";
        List<Curso> CursoList = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            String nome = resultSet.getString("nome");
            String codigo = resultSet.getString("codigo");

            return new Curso(codigo, nome, id);
        });

        return CursoList;
    }

    @Override
    public void updateCurso(Curso cursoNew, int id) throws IOException {
        final String sql = "UPDATE curso SET nome = '"+ cursoNew.getNome() + "', codigo = '"+ cursoNew.getCodigo() +
                "WHERE id = " + cursoNew.getId() + ";";

        jdbcTemplate.execute(sql);
    }

    @Override
    public void deleteCurso(int id) throws IOException {
        final String sql = "DELETE FROM curso WHERE curso.id = " + id + ";";
        jdbcTemplate.execute(sql);
    }


}
