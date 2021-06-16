package ru.zateev.dao;

import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.UserImpl;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPersons(User user);

    void savePerson(Person person, User user);

    Person getPerson(int id, User user);

    void deletePerson(int id, User user);
}
