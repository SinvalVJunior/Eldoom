package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresPerson")
public class PersonDataAccessService implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES ('"
                + id + "', '" + person.getName() + "');";
        jdbcTemplate.execute(sql);
        return true;

    }

    @Override
    public List<Person> getAllPerson() {
        final String sql = "SELECT id, name FROM person;";
        List<Person> personList = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");

            return new Person(id, name);
        });

        return personList;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE person.id = '" + id + "';";
        List<Person> personSelected = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID idBD = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(idBD, name);
        });

        return personSelected.stream().findFirst();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        final String sql = "DELETE FROM person WHERE person.id = '" + id + "';";
        jdbcTemplate.execute(sql);
        return true;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE person SET name = '" + person.getName() + "' WHERE person.id = '" + id + "';";
        jdbcTemplate.execute(sql);
        return true;
    }
}
