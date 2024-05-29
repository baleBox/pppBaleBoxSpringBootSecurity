package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll(String personlist);

    Person getById(Long id);

    void add(Person person);

    void edit(Person newDataPerson);

    void delete(Long id);
}
