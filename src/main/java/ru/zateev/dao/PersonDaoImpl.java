package ru.zateev.dao;

import org.springframework.stereotype.Repository;
import ru.zateev.User;
import ru.zateev.UserImpl;
import ru.zateev.Entity.Person;
import ru.zateev.connection.ConnectionByDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Override
    public List<Person> getAllPersons(User user) {

        List<Person> personList = new ArrayList<>();
        try (Connection connection
                     = new ConnectionByDatabase().connectByDatabase(user)) {
            System.out.println(connection.getTransactionIsolation());
            connection.setAutoCommit(false);
            try (PreparedStatement ps
                         = connection.prepareStatement(user.getAllSelect())) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setAge(resultSet.getInt("age"));
                    person.setName(resultSet.getString("name"));
                    person.setSurname(resultSet.getString("surname"));
                    person.setMail(resultSet.getString("mail"));
                    personList.add(person);
                }
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new SQLException();
            }
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personList;
    }

    @Override
    public void savePerson(Person person, User user) {
        try (Connection connection = new ConnectionByDatabase().connectByDatabase(user)) {
            try {
                PreparedStatement ps;
                if (person.getId() != 0) {
                    ps = connection.prepareStatement(user.getUpdateData()+person.getId());
                } else {
                    ps = connection.prepareStatement(user.getSaveData(), Statement.RETURN_GENERATED_KEYS);
                }
                ps.setString(1, person.getName());
                ps.setString(2, person.getSurname());
                ps.setInt(3, person.getAge());
                ps.setString(4, person.getMail());
                ps.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new SQLException();
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person getPerson(int id, User user) {
        Person person = new Person();
        try (Connection connection = new ConnectionByDatabase().connectByDatabase(user)) {
            try (PreparedStatement ps = connection.prepareStatement(user.getSelectById()+id)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    person.setSurname(resultSet.getString("surname"));
                    person.setAge(resultSet.getInt("age"));
                    person.setMail(resultSet.getString("mail"));
                }
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new SQLException();
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
        }

        return person;
    }

    @Override
    public void deletePerson(int id, User user) {
        try (Connection connection = new ConnectionByDatabase().connectByDatabase(user)) {
            try (PreparedStatement pstmt = connection.prepareStatement(user.getDelete())) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new SQLException();
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
        }
    }
}
