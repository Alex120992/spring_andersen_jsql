package ru.zateev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zateev.Entity.Person;
import ru.zateev.connection.ConnectionByDatabase;
import ru.zateev.dao.PersonDao;
import ru.zateev.dao.PersonDaoImpl;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonDao personDao;

    ConnectionByDatabase connectionByDatabase;
    @Override
    public List<Person> getAllPersons() {
        personDao = new PersonDaoImpl();
        List<Person> persons = personDao.getAllPersons();
        System.out.println(persons);
        return persons;
    }

    @Override
    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    @Override
    public Person getPerson(int id) {
        return personDao.getPerson(id);
    }

    @Override
    public void deletePerson(int id) {
        personDao.deletePerson(id);
    }
}
