package ru.zateev.service;

import com.jcraft.jsch.JSchException;
import org.springframework.stereotype.Service;
import ru.zateev.Entity.Person;
import ru.zateev.connection.ConnectionByDatabase;
import ru.zateev.dao.PersonDao;
import ru.zateev.dao.PersonDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
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
        connectionByDatabase = new ConnectionByDatabase();
        try {
            Connection connection = connectionByDatabase.connectByDatabase();
            Statement statement = connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public void deletePerson(int id) {

    }
}
