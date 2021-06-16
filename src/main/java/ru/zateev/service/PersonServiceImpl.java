package ru.zateev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.UserImpl;
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
    public List<Person> getAllPersons(User userImpl) {
        personDao = new PersonDaoImpl();
        List<Person> persons = personDao.getAllPersons(userImpl);

        return persons;
    }

    @Override
    public void savePerson(Person person, User userImpl) {
        personDao.savePerson(person, userImpl);
    }

    @Override
    public Person getPerson(int id, User userImpl) {
        return personDao.getPerson(id, userImpl);
    }

    @Override
    public void deletePerson(int id, User userImpl) {
        personDao.deletePerson(id, userImpl);
    }
}
