package ru.zateev.dao;

import com.jcraft.jsch.JSchException;
import org.springframework.stereotype.Repository;
import ru.zateev.Entity.Person;
import ru.zateev.connection.ConnectionByDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    ConnectionByDatabase connectionByDatabase ;
    @Override
    public List<Person> getAllPersons() {
        connectionByDatabase = new ConnectionByDatabase();
        List<Person> personList = new ArrayList<>();

        try {
            Connection  connection = connectionByDatabase.connectByDatabase();

            Statement ps = connection.createStatement();
            ResultSet resultSet = ps.executeQuery("SELECT * FROM andersen");
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setFamily(resultSet.getString("family"));
                personList.add(person);

            }
            connectionByDatabase.closeSession();
            connectionByDatabase.closeConnetion();
            return personList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void savePerson(Person person) {

    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public void deletePerson(int id) {

    }
}
