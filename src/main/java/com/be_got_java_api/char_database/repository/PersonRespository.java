package com.be_got_java_api.char_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be_got_java_api.char_database.model.Person;

public interface PersonRespository extends JpaRepository<Person, Long> {
    
}
