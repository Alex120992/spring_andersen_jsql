package ru.zateev.Entity;


import org.springframework.beans.factory.annotation.Autowired;
import ru.zateev.validator.Validator;

public class Person {



    private int id;
    private String name;
    private String surname;
    private String mail;
    private int age;
    private boolean validateName;
    private boolean validateSurname;
    private boolean validateAge;
    private boolean validateMail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isValidateName() {
        return validateName;
    }

    public void setValidateName(boolean validateName) {
        this.validateName = validateName;
    }

    public boolean isValidateSurname() {
        return validateSurname;
    }

    public void setValidateSurname(boolean validateSurname) {
        this.validateSurname = validateSurname;
    }

    public boolean isValidateAge() {
        return validateAge;
    }

    public void setValidateAge(boolean validateAge) {
        this.validateAge = validateAge;
    }

    public boolean isValidateMail() {
        return validateMail;
    }

    public void setValidateMail(boolean validateMail) {
        this.validateMail = validateMail;
    }

    public boolean isValide() {
        if (validateName) return true;
        else if (validateSurname) return true;
        else if (validateAge) return true;
        else if (validateMail) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                '}';
    }
}
