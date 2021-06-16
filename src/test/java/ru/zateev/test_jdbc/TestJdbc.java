package ru.zateev.test_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import ru.zateev.User;
import ru.zateev.UserImpl;
import ru.zateev.configuration.Conf;
import ru.zateev.connection.ConnectionByDatabase;
import ru.zateev.users.TestUserImpl;

import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Conf.class)
public class TestJdbc {
    Connection connection;
    Connection connectionException;
    @Autowired
    ConnectionByDatabase connectionByDatabase;



    @BeforeEach
    public void setUp() throws SQLException {
        User user = new UserImpl();
        connection = connectionByDatabase.connectByDatabase(user);
    }

    @Test
    public void testConnection() throws SQLException {
        Assert.notNull(connection, "Соединение не создано");
    }




}
