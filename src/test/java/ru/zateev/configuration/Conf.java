package ru.zateev.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.zateev.UserImpl;
import ru.zateev.connection.ConnectionByDatabase;
import ru.zateev.dao.PersonDao;
import ru.zateev.dao.PersonDaoImpl;
import ru.zateev.service.PersonService;
import ru.zateev.service.PersonServiceImpl;
import ru.zateev.users.TestUserImpl;
import ru.zateev.validator.Validator;

@Configuration
public class Conf {

    @Bean
    public PersonService personService(){
        return new PersonServiceImpl();
    }
    @Bean
    public PersonDao personDao(){
        return new PersonDaoImpl();
    }
    @Bean
    public ConnectionByDatabase connectionByDatabase (){
        return new ConnectionByDatabase();
    }
    @Bean
    public Validator validator(){
        return new Validator();
    }
    @Bean
    public UserImpl user(){
        return new UserImpl();
    }
    @Bean
    public TestUserImpl testUser(){
        return new TestUserImpl();
    }
}
