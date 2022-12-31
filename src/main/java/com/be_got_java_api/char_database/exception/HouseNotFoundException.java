package com.be_got_java_api.char_database.exception;

public class HouseNotFoundException extends RuntimeException{
    public HouseNotFoundException(Long houseId) {
        super("Could not find House with id " + houseId);
    }
}