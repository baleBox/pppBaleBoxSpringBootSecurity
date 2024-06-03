package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Person;

import javax.persistence.*;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getAll(String personlist) {
        return entityManager.createQuery("From Person", Person.class).getResultList();
    }

    @Override
    public Person getById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void add(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void edit(Person newDataPerson) {
        entityManager.merge(newDataPerson);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
