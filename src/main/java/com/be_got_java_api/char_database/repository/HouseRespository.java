package com.be_got_java_api.char_database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be_got_java_api.char_database.model.House;

public interface HouseRespository extends JpaRepository<House, Long> {
 
    List<House> findByHousename(String housename);
}
