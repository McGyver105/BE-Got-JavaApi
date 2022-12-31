package com.be_got_java_api.char_database.exception;

public class HouseAlreadyExistsException extends RuntimeException {
    public HouseAlreadyExistsException(String houseName) {
        super("House " + houseName + " already exists" );
    }
}
