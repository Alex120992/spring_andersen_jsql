package ru.zateev.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionByDatabase {

    public Connection connectByDatabase() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/alex"
                    , "alex"
                    , "1234");
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
            connection.close();
        }

        return connection;
    }

}
