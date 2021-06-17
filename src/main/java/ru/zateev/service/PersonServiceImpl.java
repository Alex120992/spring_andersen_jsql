package ru.zateev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.dao.PersonDao;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonDao personDao;


    @Override
    public List<Person> getAllPersons(User userImpl) {
        List<Person> persons = personDao.getAllPersons(userImpl);

        return persons;
    }

    @Override
    public void savePerson(Person person, User userImpl) {
        if (!personDao.savePerson(person, userImpl)) {
            throw new RuntimeException("Проблемы с сохранением");
        }

    }

    @Override
    public Person getPerson(int id, User userImpl) {
        return personDao.getPerson(id, userImpl);
    }

    @Override
    public void deletePerson(int id, User userImpl) {
        if (!personDao.deletePerson(id, userImpl)) {
            throw new RuntimeException("Проблемы с удалением");
        }

    }
}
