package ru.zateev.controllerTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.zateev.Entity.Person;
import ru.zateev.User;
import ru.zateev.UserImpl;
import ru.zateev.configuration.Conf;
import ru.zateev.dao.PersonDao;
import ru.zateev.dao.PersonDaoImpl;
import ru.zateev.service.PersonService;
import ru.zateev.service.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Conf.class)
public class HomeControllerTest {
    @Rule
    MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    @Autowired
    PersonService personService;

    @Mock
    @Autowired
    PersonDao personDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getAllPersonTest() {

        User user = new UserImpl();
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Aleksey");
        person.setSurname("Ivanov");
        person.setMail("asda@mail.com");
        person.setAge(22);
        person1.setName("Ivan");
        person1.setSurname("Andreev");
        person1.setMail("asdas@mail.com");
        person1.setAge(33);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        when(personDao.getAllPersons(user)).thenReturn(personList);
        List<Person> persons = personService.getAllPersons(user);
        Assertions.assertEquals(2, persons.size());

    }
}
