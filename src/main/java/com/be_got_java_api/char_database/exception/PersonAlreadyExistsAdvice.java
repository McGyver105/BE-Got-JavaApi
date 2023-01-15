package com.be_got_java_api.char_database.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PersonAlreadyExistsAdvice {
    @ResponseBody
    @ExceptionHandler(PersonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Map<String, String> personExceptionHandler(PersonAlreadyExistsException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());

        return errorMap;
    }
}
