package ru.zateev.connection;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionByDatabase {
    Session session;
    Connection connection;
    public Connection connectByDatabase () throws SQLException, JSchException, ClassNotFoundException {
        SSHSession();
        Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/alex", "postgres","1234");
        System.out.println("Done");
        return connection;

    }

    private void SSHSession () throws JSchException {
        JSch jsch = new JSch();
        session = jsch.getSession("alexza", "192.168.1.35", 22);
        session.setPassword("Aleksey120992");
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPortForwardingL(5432, "127.0.0.1", 5432);
        session.connect();


        System.out.println("Done SSH");

    }

    public void closeConnetion () throws SQLException {
        connection.close();
    }

    public void closeSession (){
        session.disconnect();
    }
}
