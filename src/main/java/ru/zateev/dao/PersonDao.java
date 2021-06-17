package ru.zateev.dao;

import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.UserImpl;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPersons(User user);

    boolean savePerson(Person person, User user);

    Person getPerson(int id, User user);

    boolean deletePerson(int id, User user);
}
