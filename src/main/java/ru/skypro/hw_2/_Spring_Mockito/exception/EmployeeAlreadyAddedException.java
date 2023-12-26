package ru.skypro.hw_2._Spring_Mockito.exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}