package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {

    boolean insertPerson(UUID id, Person person);

    default boolean insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPerson();

    Optional<Person> getPersonById(UUID id);
    boolean deletePersonById(UUID id);

    boolean updatePersonById(UUID id, Person person);
}
