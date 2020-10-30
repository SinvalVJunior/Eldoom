package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public boolean insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return true;
    }

    @Override
    public List<Person> getAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        Optional<Person> personOptional = getPersonById(id);

        return DB.remove(personOptional.get());
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return getPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

}
