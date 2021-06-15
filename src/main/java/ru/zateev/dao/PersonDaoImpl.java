package ru.zateev.dao;

import org.springframework.stereotype.Repository;
import ru.zateev.Constans;
import ru.zateev.Entity.Person;
import ru.zateev.connection.ConnectionByDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection
                     = new ConnectionByDatabase().connectByDatabase()) {
            System.out.println(connection.getTransactionIsolation());
            connection.setAutoCommit(false);
            try (PreparedStatement ps
                         = connection.prepareStatement(Constans.SELECT_TABLE)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setAge(resultSet.getInt("age"));
                    person.setName(resultSet.getString("name"));
                    person.setFamily(resultSet.getString("family"));
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
    public void savePerson(Person person) {
        try (Connection connection = new ConnectionByDatabase().connectByDatabase()) {
            try {
                PreparedStatement ps;
                if (person.getId() != 0) {
                    ps = connection.prepareStatement(Constans.UPDATE_DATA+person.getId());
                } else {
                    ps = connection.prepareStatement(Constans.SAVE_DATA, Statement.RETURN_GENERATED_KEYS);
                }
                ps.setString(1, person.getName());
                ps.setString(2, person.getFamily());
                ps.setInt(3, person.getAge());
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
            System.err.println(e.getErrorCode());
        }
    }

    @Override
    public Person getPerson(int id) {
        Person person = new Person();
        try (Connection connection = new ConnectionByDatabase().connectByDatabase()) {
            try (PreparedStatement ps = connection.prepareStatement(Constans.SELECT_BY_ID+id)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    person.setFamily(resultSet.getString("family"));
                    person.setAge(resultSet.getInt("age"));
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
    public void deletePerson(int id) {
        try (Connection connection = new ConnectionByDatabase().connectByDatabase()) {
            try (PreparedStatement pstmt = connection.prepareStatement(Constans.DELETE)) {
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
