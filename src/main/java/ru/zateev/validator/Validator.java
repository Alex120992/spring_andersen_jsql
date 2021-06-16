package ru.zateev.validator;

import org.springframework.stereotype.Component;
import ru.zateev.Entity.Person;

@Component
public class Validator {
    private final String regularFamilyAndName = "^([A-Z]|[А-Я])([a-z]|[а-я]){1,19}";
    private final String regularAge = "([1-9][\\d]?|[1][0-2][\\d])";
    private final String regularMail = "^[\\w][^\\s]{0,30}[@][a-z]{2,10}[.][a-z]{2,15}$";


    public void generalValidator(Person person) {
        person.setValidateName(validName(person.getName()));
        person.setValidateSurname(validName(person.getSurname()));
        person.setValidateAge(validAge(person.getAge()));
        person.setValidateMail(validMail(person.getMail()));
    }

    public boolean validName(String name) {
        return !name.matches(regularFamilyAndName);
    }

    public boolean validSurname(String surname) {
        return !surname.matches(regularFamilyAndName);

    }

    public boolean validAge(int age) {
        String convertAge = String.valueOf(age);
        return !convertAge.matches(regularAge);

    }

    public boolean validMail(String mail) {
        return !mail.matches(regularMail);
    }
}
