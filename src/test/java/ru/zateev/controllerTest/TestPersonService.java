package ru.zateev.controllerTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.UserImpl;
import ru.zateev.configuration.Conf;
import ru.zateev.connection.ConnectionByDatabase;
import ru.zateev.dao.PersonDao;
import ru.zateev.dao.PersonDaoImpl;
import ru.zateev.service.PersonService;
import ru.zateev.service.PersonServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@MockitoSettings(strictness = Strictness.LENIENT)

@ContextConfiguration(classes = Conf.class)
public class TestPersonService {
    List<Person> personList;
    Person person;
    Person person1;

    User testUser = new UserImpl();

    @Autowired
    @InjectMocks
    PersonService personService;

    @Mock
    PersonDao personDao;

    @BeforeEach
    public void init() {

        personList = new ArrayList<>();
        person = new Person();
        person1 = new Person();
        person.setName("Aleksey");
        person.setSurname("Ivanov");
        person.setMail("asda@mail.com");
        person.setAge(22);
        person1.setName("Ivan");
        person1.setSurname("Andreev");
        person1.setMail("asdas@mail.com");
        person1.setAge(33);
        personList.add(person);
        personList.add(person1);

    }


    @Test
    public void getAllPersonTest() throws SQLException {
        Mockito.lenient().when(personDao.getAllPersons(testUser)).thenReturn(personList);
        int a = personService.getAllPersons(testUser).size();
        System.out.println(personService.getAllPersons(testUser).size());
        Assertions.assertEquals(2, a);
    }

    @Test
    public void getByIdPersonTest() throws SQLException {
        Mockito.lenient().when(personDao.getPerson(1, testUser)).thenReturn(personList.get(1));
        Person person = personService.getPerson(1, testUser);
        Assertions.assertEquals(personList.get(1), person);
    }
    @Test
    public void deletePersonTest() throws SQLException {
        Mockito.lenient().when(personDao.deletePerson(1, testUser)).thenReturn(false);

        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, ()->{
            personService.deletePerson(5,testUser);
        });

        Assertions.assertNotNull(runtimeException.getMessage());
    }
    @Test
    public void savePersonTest() throws SQLException {
        Mockito.lenient().when(personDao.savePerson(person, testUser)).thenReturn(false);
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, ()->{
            personService.savePerson(person,testUser);
        });

        Assertions.assertNotNull(runtimeException.getMessage());
    }





}
