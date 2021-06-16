package ru.zateev.test_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.zateev.User;
import ru.zateev.configuration.Conf;
import ru.zateev.connection.ConnectionByDatabase;
import ru.zateev.users.TestUserImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Conf.class)
class TestExceptionConnection {

    //    private final ConnectionByDatabase connectionByDatabase = mock(ConnectionByDatabase.class);
    User testUser;
    ConnectionByDatabase connectionByDatabase;


    @BeforeEach
    public void startUp() throws SQLException {
        User testUser = new TestUserImpl();


    }

    //
    @Test
    void testExceptionConnection() throws SQLException {
        connectionByDatabase = Mockito.mock(ConnectionByDatabase.class);
        when(connectionByDatabase.connectByDatabase(testUser))
                .thenThrow(new SQLException("Нет соединения с БД"));
        SQLException sqlException = Assertions.assertThrows(SQLException.class, () -> {
            connectionByDatabase.connectByDatabase(testUser);
        });

        Assertions.assertNotNull(sqlException.getMessage());

    }



}
