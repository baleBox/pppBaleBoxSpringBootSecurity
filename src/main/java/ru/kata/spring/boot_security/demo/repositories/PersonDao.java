package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAll(String personlist);

    Person getById(Long id);

    void add(Person person);

    void edit(Person newDataPerson);

    void delete(Long id);

}

