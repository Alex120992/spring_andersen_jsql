package ru.zateev.service;

import ru.zateev.Entity.Person;

import java.util.List;

public interface PersonService {


    public List<Person> getAllPersons();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);

}
