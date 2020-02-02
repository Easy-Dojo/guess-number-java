package com.thoughtworks.guessnumber.exception;

public class OutOfRangeAnswerException extends Exception {
    public OutOfRangeAnswerException(String message) {
        super(message);
    }
}
