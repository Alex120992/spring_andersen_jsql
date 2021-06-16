package ru.zateev.GlobalException;

public class WrongMailException extends RuntimeException {
    public WrongMailException(String message) {
        super(message);
    }
}
