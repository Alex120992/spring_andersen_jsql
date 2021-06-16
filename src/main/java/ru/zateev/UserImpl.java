package ru.zateev;

import org.springframework.stereotype.Component;

@Component
public class UserImpl implements User {

    public  final String URL = "jdbc:postgresql://127.0.0.1:5432/";
    public  final String USER = "alex";
    public  final String PASSWORD = "1234";
    public  final String DATABASE = "alex";
    public  final String DRIVER = "org.postgresql.Driver";

    public  final String SELECT_TABLE = "SELECT * FROM andersen ORDER BY id";
    public  final String SELECT_BY_ID = "SELECT * FROM andersen WHERE id = ";
    public  final String DELETE = "DELETE FROM andersen WHERE id = ?";
    public  final String SAVE_DATA = "INSERT INTO andersen (name,surname,age,mail) VALUES (?,?,?,?)";
    public  final String UPDATE_DATA = "UPDATE andersen SET "
            + " name = ?,"
            + "surname = ?, "
            + "age = ?, "
            + "mail = ?"
            + "WHERE id =";


    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public String getUser() {
        return USER;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getDatabase() {
        return DATABASE;
    }

    @Override
    public String getDriver() {
        return DRIVER;
    }

    @Override
    public String getAllSelect() {
        return SELECT_TABLE;
    }

    @Override
    public String getSelectById() {
        return SELECT_BY_ID;
    }

    @Override
    public String getDelete() {
        return DELETE;
    }

    @Override
    public String getSaveData() {
        return SAVE_DATA;
    }

    @Override
    public String getUpdateData() {
        return UPDATE_DATA;
    }
}
