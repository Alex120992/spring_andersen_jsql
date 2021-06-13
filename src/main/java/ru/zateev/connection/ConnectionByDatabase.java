package ru.zateev.connection;

import com.jcraft.jsch.JSchException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionByDatabase {

    Connection connection;
    public Connection connectByDatabase () throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/alex", "alex","1234");
        System.out.println("Done");
        return connection;

    }

    public void closeConnetion () throws SQLException {
        connection.close();
    }


}
