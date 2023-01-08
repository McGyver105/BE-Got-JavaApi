package com.be_got_java_api.char_database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.be_got_java_api.char_database.exception.PersonNotFoundException;
import com.be_got_java_api.char_database.model.Person;
import com.be_got_java_api.char_database.repository.PersonRespository;

@RestController
public class PersonController {
    
    @Autowired
    private PersonRespository personRespository;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRespository.findAll();
    }

    @GetMapping("/person/{id}")
    Person getPersonById(@PathVariable Long id) {
        return personRespository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
    }
    
}
