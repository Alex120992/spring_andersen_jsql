package ru.zateev.controllerTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.zateev.configuration.Conf;
import ru.zateev.service.PersonService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Conf.class)
public class HomeControllerTest {

    @Autowired
    private PersonService personService;

}
