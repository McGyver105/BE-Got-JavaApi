package com.be_got_java_api.char_database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.be_got_java_api.char_database.model.Person;

public interface PersonRespository extends JpaRepository<Person, Long> {
    
    Boolean existsByPersonName(String personName);

    @Query( "SELECT p FROM Person p WHERE dead = :dead AND religion = :religion" )
    List<Person> findByDeadAndReligion(@Param("dead") boolean dead, @Param("religion") String religion );
}
