package ru.zateev.dao;

import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.zateev.Entity.Person;
import ru.zateev.connection.ConnectionByDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    ConnectionByDatabase connectionByDatabase;

    @Override
    public List<Person> getAllPersons() {
        connectionByDatabase = new ConnectionByDatabase();
        List<Person> personList = new ArrayList<>();

        try {
            Connection connection = connectionByDatabase.connectByDatabase();

            Statement ps = connection.createStatement();
            ResultSet resultSet = ps.executeQuery("SELECT * FROM andersen ");
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setFamily(resultSet.getString("family"));
                personList.add(person);
            }


            return personList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionByDatabase.closeConnetion();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public void savePerson(Person person) {
        String sql;
        PreparedStatement ps;


        connectionByDatabase = new ConnectionByDatabase();

        try {
            Connection connection = connectionByDatabase.connectByDatabase();
            if (person.getId() != 0) {
                sql = "UPDATE andersen SET  name = ?," +
                        "family = ?, age = ? " +
                        "WHERE id ="+person.getId();
                ps = connection.prepareStatement(sql);
            } else {
                sql = "INSERT INTO andersen (name,family,age) VALUES (?,?,?)";
                ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            }


            ps.setString(1, person.getName());
            ps.setString(2, person.getFamily());
            ps.setInt(3, person.getAge());

            ps.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person getPerson(int id) {
        Person person = new Person();
        String sql = "SELECT * FROM andersen WHERE id = " + String.valueOf(id);
        connectionByDatabase = new ConnectionByDatabase();
        try {
            Connection connection = connectionByDatabase.connectByDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setFamily(resultSet.getString("family"));
                person.setAge(resultSet.getInt("age"));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void deletePerson(int id) {

    }
}
