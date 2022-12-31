package com.be_got_java_api.char_database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.be_got_java_api.char_database.model.House;
import com.be_got_java_api.char_database.repository.HouseRespository;

@RestController
public class HouseController {
    
    @Autowired
    private HouseRespository houseRespository;

    @GetMapping("/houses")
    public List<House> getAllHouses() {
        return houseRespository.findAll();
    }

    // @GetMapping("/house/{id}")
    // House getHouseById(@PathVariable String houseName) {
    //     Long id = houseRespository.findByHousename(houseName)
    // }

}
