package ru.zateev.dao;

import ru.zateev.Entity.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPersons();

    void savePerson(Person person);

    Person getPerson(int id);

    void deletePerson(int id);
}
