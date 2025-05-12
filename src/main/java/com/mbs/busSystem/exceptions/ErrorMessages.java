package com.mbs.busSystem.exceptions;

public enum ErrorMessages {
    NOT_FOUND("BusNotFound"),
    NAME_REQUIRED("Name is required");

    private final String message;


    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
