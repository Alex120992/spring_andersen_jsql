package ru.zateev;

public class Constans {

    public static final String URL = "jdbc:postgresql://127.0.0.1:5432/";
    public static final String USER = "alex";
    public static final String PASSWORD = "1234";
    public static final String DATABASE = "alex";
    public static final String DRIVER = "org.postgresql.Driver";

    public static final String SELECT_TABLE = "SELECT * FROM andersen ORDER BY id";
    public static final String SELECT_BY_ID = "SELECT * FROM andersen WHERE id = ";
    public static final String DELETE = "DELETE FROM andersen WHERE id = ?";
    public static final String SAVE_DATA = "INSERT INTO andersen (name,family,age) VALUES (?,?,?)";
    public static final String UPDATE_DATA = "UPDATE andersen SET " +
            " name = ?,"
            + "family = ?, "
            + "age = ? "
            + "WHERE id =";


}
