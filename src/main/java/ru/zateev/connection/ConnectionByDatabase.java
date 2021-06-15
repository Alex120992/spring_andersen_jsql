package ru.zateev.connection;

import ru.zateev.Constans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionByDatabase {

    public Connection connectByDatabase() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(Constans.DRIVER);
            connection = DriverManager.getConnection(Constans.URL+Constans.DATABASE
                    , Constans.USER
                    , Constans.PASSWORD);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        } catch (ClassNotFoundException | SQLException e) {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }

        return connection;
    }

}
