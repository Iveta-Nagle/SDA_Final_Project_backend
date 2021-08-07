package com.company.exception;

public class TooManyCardsException extends RuntimeException{
    public TooManyCardsException(String message) {
        super(message);
    }
}
