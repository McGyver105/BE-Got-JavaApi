package com.be_got_java_api.char_database.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException( Long personId ) {
        super( "Could not find Person with id " + personId);
    }
}
