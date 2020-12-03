package com.example.demo.dao.Disciplina;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import com.example.demo.model.Disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("postgresDisciplina")
public class DisciplinaDataAccessService implements DisciplinaDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DisciplinaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertDisciplina(Disciplina disciplina) throws IOException {
        final String sql = "INSERT INTO disciplina (codigo, nome, descricao, cursoId) VALUES ('"
                + disciplina.getCodigo() + "', '" + disciplina.getNome() + "', '" + disciplina.getDescricao() + "', '" + disciplina.getCursoId() + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Disciplina> getAllDisciplina() throws IOException {
        final String sql = "SELECT codigo, nome, descricao, cursoId, id FROM Disciplina;";
        List<Disciplina> DisciplinaList = jdbcTemplate.query(sql, (resultSet, i) -> {
            int cursoId = Integer.parseInt(resultSet.getString("cursoId"));
            int id = Integer.parseInt(resultSet.getString("id"));
            String nome = resultSet.getString("nome");
            String codigo = resultSet.getString("codigo");
            String descricao = resultSet.getString("descricao");

            return new Disciplina(codigo, nome, id, descricao, cursoId);
        });

        return DisciplinaList;
    }

    
}
