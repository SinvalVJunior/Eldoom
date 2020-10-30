package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    public final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public boolean addPerson(Person person) {
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDAO.getPersonById(id);
    }

    public boolean deletePersonById(UUID id) {
        return personDAO.deletePersonById(id);
    }

    public boolean updatePersonById(UUID id, Person person) {
        return personDAO.updatePersonById(id, person);
    }
}
