package ru.zateev.connection;


import org.springframework.stereotype.Component;
import ru.zateev.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionByDatabase {
    User userImpl;

    public Connection connectByDatabase(User user) throws SQLException {
        Connection connection = null;

        this.userImpl = user;
        try {
            Class.forName(user.getDriver());
            if (user.getDriver() == null) {
                throw new NullPointerException("Нет драйвера");
            }
            connection = DriverManager.getConnection(user.getURL() + user.getDatabase()
                    , user.getUser()
                    , user.getPassword());
            if (connection == null) {
                throw new NullPointerException("Нет соединения с БД");
            }
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        } catch (ClassNotFoundException | SQLException | NullPointerException e ) {
            e.printStackTrace();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }

        return connection;
    }

}
