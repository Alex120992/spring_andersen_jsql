package ru.zateev;

import java.util.ArrayList;
import java.util.List;

public class Const {


    public List<String> setListTrueNameSurname() {
        List<String>trueNameSurnameList = new ArrayList<>();
        trueNameSurnameList.add("Алексей");
        trueNameSurnameList.add("Владимир");
        trueNameSurnameList.add("Вольдемар");
        trueNameSurnameList.add("Tonny");
        trueNameSurnameList.add("Olivia");
        trueNameSurnameList.add("Martin");
        trueNameSurnameList.add("Philip");
        return trueNameSurnameList;
    }

    public List<String> setListFalseNameSurname() {
        List<String>falseNameSurnameList = new ArrayList<>();
        falseNameSurnameList.add("ААлексей");
        falseNameSurnameList.add("владимир");
        falseNameSurnameList.add(" ");
        falseNameSurnameList.add("1Алексей");
        falseNameSurnameList.add("_Olivia");
        falseNameSurnameList.add("M_artin");
        falseNameSurnameList.add("P12hilip");
        return falseNameSurnameList;
    }

    public List<Integer> setTrueListAge() {
        List<Integer>trueAgeList = new ArrayList<>();
        trueAgeList.add(1);
        trueAgeList.add(100);
        trueAgeList.add(109);
        trueAgeList.add(55);
        trueAgeList.add(87);
        trueAgeList.add(25);
        return trueAgeList;
    }

    public List<Integer> setFalseListAge() {
         List<Integer> falseAgeList= new ArrayList<>();
        falseAgeList.add(1000);
        falseAgeList.add(180);
        falseAgeList.add(200);
        falseAgeList.add(169);
        falseAgeList.add(999);
        falseAgeList.add(145);
        return falseAgeList;
    }

    public List<String> setTrueMailList() {
        List<String>trueMailList = new ArrayList<>();
        trueMailList.add("ivan_sd@^%f@mail.ru");
        trueMailList.add("ivan_sd@^%f@gmail.ru");
        trueMailList.add("Ivan_sd@^@mail.ru");
        trueMailList.add("ivan_s@mail.kz");
        trueMailList.add("aleksey_sd@^%f@mail.su");
        trueMailList.add("Ivanov_sd@^%f@mail.org");
        trueMailList.add("ivan_sd@^%f@mbk.com");
        return trueMailList;
    }

    public List<String> setFalseMailList() {
       List<String> falseMailList = new ArrayList<>();
        falseMailList.add("ivan_sd@^%f@mailru");
        falseMailList.add(" ");
        falseMailList.add("Ivan_sd@^@mail");
        falseMailList.add("ivan_s@");
        falseMailList.add(".su");
//        falseMailList.add("^Ivanov_sd@^%f@mail.org");
        falseMailList.add("ivan_sd@^%f@mbk.$");
        return falseMailList;
    }
}
