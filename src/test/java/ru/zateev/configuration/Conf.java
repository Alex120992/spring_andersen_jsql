package ru.zateev.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.zateev.dao.PersonDao;
import ru.zateev.dao.PersonDaoImpl;
import ru.zateev.service.PersonService;
import ru.zateev.service.PersonServiceImpl;

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
}
