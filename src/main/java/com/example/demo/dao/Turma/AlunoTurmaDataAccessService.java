package com.example.demo.dao.Turma;

import com.example.demo.model.AlunoTurma;
import com.example.demo.model.AlunoTurmaRequest;
import com.example.demo.model.AlunoTurmaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository("postgresAlunoTurma")
public class AlunoTurmaDataAccessService implements AlunoTurmaDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AlunoTurmaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertAlunoTurma(AlunoTurma alunoTurma) throws IOException {
        final String sql = "INSERT INTO Aluno_Turma (AlunoId, TurmaId, NotaTotal) VALUES ('"
                + alunoTurma.getAlunoId() + "', '" + alunoTurma.getTurmaId() + "','" + alunoTurma.getNotaTotal()
                + "');";

        jdbcTemplate.execute(sql);
    }

    @Override
    public List<AlunoTurmaResponse> getAllAlunoTurma() throws IOException {
        final String sql = "SELECT a.Nome, t.Codigo "
                + "FROM Aluno_Turma inner join aluno a on a.id = Aluno_Turma.AlunoId inner join turma t on t.id = Aluno_Turma.TurmaId;";
        List<AlunoTurmaResponse> alunoTurmaResponseList = jdbcTemplate.query(sql, (resultSet, i) -> {
            String alunoNome = resultSet.getString("nome");
            String turmaCodigo = resultSet.getString("codigo");

            return new AlunoTurmaResponse(alunoNome, turmaCodigo);
        });

        return alunoTurmaResponseList;
    }

    @Override
    public void deleteAlunoTurma(AlunoTurmaRequest alunoTurmaRequest) throws IOException {
        final String sql = "DELETE FROM Aluno_Turma WHERE (Aluno_Turma.AlunoId = '" + alunoTurmaRequest.getAlunoId()
                + "' and Aluno_Turma.TurmaId = " + alunoTurmaRequest.getTurmaId() + ");";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateAlunoTurma(AlunoTurma alunoTurmaNew, AlunoTurma alunoTurmaOld) throws IOException {
        final String sql = "UPDATE Aluno_Turma SET AlunoId = " + alunoTurmaNew.getAlunoId() + ", TurmaId = "
                + alunoTurmaNew.getTurmaId() + ", NotaTotal = " + alunoTurmaNew.getNotaTotal()
                + "   WHERE (Aluno_Turma.AlunoId = " + alunoTurmaOld.getAlunoId() + " and Aluno_Turma.TurmaId = "
                + alunoTurmaOld.getTurmaId() + " );";
        jdbcTemplate.execute(sql);
    }
}