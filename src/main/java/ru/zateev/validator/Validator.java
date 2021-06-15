package ru.zateev.validator;

import ru.zateev.Entity.Person;

public class Validator {
    private final String regularFamilyAndName = "^([A-Z]|[А-Я])([a-z]|[а-я]){1,19}";
    private final String regularAge = "([1-9][\\d]?|[1][1-2][\\d])";
    private final String regularMail = "^[\\w][^\\s]{0,30}[@][a-z]{2,10}[.][a-z]{2,15}$";


    public Person validation(int id, String name, String surname, String mail, int age) {
        Person errorPersonDetail = new Person();

        if (!name.matches(regularFamilyAndName)) {
            errorPersonDetail.setName("Incorrect name");
        } else {
            errorPersonDetail.setName(name);
        }
        if (!surname.matches(regularFamilyAndName)) {
            errorPersonDetail.setSurname("Incorrect surname");
        } else {
            errorPersonDetail.setSurname(surname);
        }
        if (!String.valueOf(age).matches(regularAge)) {
            errorPersonDetail.setAge(0);
        } else {
            errorPersonDetail.setAge(age);
        }
        if (mail.matches(regularMail)) {
            errorPersonDetail.setMail("Incorrect mail");
        } else {
            errorPersonDetail.setMail(mail);
        }
        if (id != 0) {
            errorPersonDetail.setId(id);
        }
        else {
            errorPersonDetail.setId(0);
        }

        return errorPersonDetail;
    }
}
