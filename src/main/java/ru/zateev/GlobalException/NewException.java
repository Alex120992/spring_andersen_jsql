package ru.zateev.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewException {

    @ExceptionHandler
    public ResponseEntity<IncorrectMail> handleException(WrongMailException wrongMailException) {
        IncorrectMail incorrectMail = new IncorrectMail();
        incorrectMail.setInfo("ПРи вводе почты вы ввели некорректные данные");

        return new ResponseEntity<>(incorrectMail, HttpStatus.BAD_REQUEST);
    }
}
