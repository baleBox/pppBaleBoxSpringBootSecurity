package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Person;
import ru.kata.spring.boot_security.demo.repositories.PersonDao;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonDao personDao;
@Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    @Override
    public List<Person> getAll(String personlist) {
        return personDao.getAll(personlist);
    }

    @Transactional
    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Transactional
    @Override
    public void add(Person person) {
        personDao.add(person);
    }

    @Transactional
    @Override
    public void edit(Person newDataPerson) {
        personDao.edit(newDataPerson);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Person person = personDao.getById(id);
        personDao.delete(person.getId());
    }
}