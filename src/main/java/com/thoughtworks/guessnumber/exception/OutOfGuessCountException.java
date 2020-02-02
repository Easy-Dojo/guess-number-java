package com.thoughtworks.guessnumber.exception;

public class OutOfGuessCountException extends Throwable {
    public OutOfGuessCountException(String message) {
        super(message);
    }
}
