package com.be_got_java_api.char_database.exception;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException(String personName) {
        super("Person " + personName + " already exists");
    }
}
