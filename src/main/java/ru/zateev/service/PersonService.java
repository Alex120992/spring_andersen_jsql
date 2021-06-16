package ru.zateev.service;

import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.UserImpl;

import java.util.List;

public interface PersonService {


    public List<Person> getAllPersons(User userImpl);

    public void savePerson(Person person, User userImpl);

    public Person getPerson(int id, User userImpl);

    public void deletePerson(int id, User userImpl);

}
