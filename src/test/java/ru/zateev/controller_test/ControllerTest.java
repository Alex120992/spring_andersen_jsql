package ru.zateev.controller_test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.zateev.config.MySpringMvcDispatcherServletInitializer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MySpringMvcDispatcherServletInitializer.class, loader = )
public class ControllerTest {


}
