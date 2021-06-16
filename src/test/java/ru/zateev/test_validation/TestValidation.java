package ru.zateev.test_validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import ru.zateev.Const;
import ru.zateev.Entity.Person;
import ru.zateev.GlobalException.NewException;
import ru.zateev.GlobalException.WrongMailException;
import ru.zateev.configuration.Conf;
import ru.zateev.validator.Validator;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Conf.class)
public class TestValidation {
    @Autowired
    Validator validator;

    List<String> trueNameSurname;
    List<String> falseNameSurname;
    List<Integer> trueAgeList;
    List<Integer> falseAgeList;
    List<String> trueMailList;
    List<String> falseMailList;

    @BeforeEach
    public void setUp(){
        trueNameSurname = new Const().setListTrueNameSurname();
        falseNameSurname = new Const().setListFalseNameSurname();
        trueMailList = new Const().setTrueMailList();
        falseMailList = new Const().setFalseMailList();
        trueAgeList = new Const().setTrueListAge();
        falseAgeList = new Const().setFalseListAge();

    }

    @Test
    public void testTrueName (){
        boolean value = true;
        for (String name: trueNameSurname){
            if (validator.validName(name)) value = false;
        }
        Assert.isTrue(value, "Проверка имен не прошла");
    }
    @Test
    public void testFalseName (){
        boolean value = true;
        for (String name: falseNameSurname){
            if (!validator.validName(name)) value = false;
        }
        Assert.isTrue(value, "Проверка имен не прошла");
    }
    @Test
    public void testTrueMail (){
        boolean value = true;
        for (String mail: trueMailList){
            if (validator.validMail(mail)) value = false;
        }
        Assert.isTrue(value, "Проверка mail не прошла");
    }
    @Test
    public void falseTrueMail (){
        boolean value = true;
        for (String mail: falseMailList){
            if (!validator.validMail(mail)) value = false;
        }
        Assert.isTrue(value, "Проверка mail не прошла");
    }
    @Test
    public void testTrueAge (){
        boolean value = true;
        for (Integer age: trueAgeList){
            if (validator.validAge(age)) value = false;
        }
        Assert.isTrue(value, "Проверка возраста не прошла");
    }
    @Test
    public void falseTrueAge (){
        boolean value = true;
        for (Integer age: falseAgeList){
            if (!validator.validAge(age)) value = false;
        }
        Assert.isTrue(value, "Проверка возраста не прошла");
    }

    @Test
    public void checkMailThrowException (){
        Person person = new Person();
        person.setMail("addsadfa");
        WrongMailException wrongMailException = Assertions.assertThrows(WrongMailException.class, ()->{
            validator.validMail(person.getMail());
        });
        String s = wrongMailException.getMessage();
        Assertions.assertNotNull(s);
    }

}
