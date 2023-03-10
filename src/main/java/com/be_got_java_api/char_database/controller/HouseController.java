package com.be_got_java_api.char_database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.be_got_java_api.char_database.exception.HouseAlreadyExistsException;
import com.be_got_java_api.char_database.exception.HouseNotFoundException;
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

    @GetMapping("/house/{id}")
    House getHouseById(@PathVariable Long id) {
        return houseRespository.findById(id)
        .orElseThrow(() -> new HouseNotFoundException(id)); 
    }

    @PostMapping("/house")
    House newHouse(@RequestBody House newHouse) {
        String newHouseName = newHouse.getHousename();
        if( houseRespository.existsByHousename(newHouseName)){
            throw new HouseAlreadyExistsException(newHouseName);
        }
        return houseRespository.save(newHouse);
    }

    @DeleteMapping("/house/{id}")
    String deleteHouse(@PathVariable Long id) {
        if(!houseRespository.existsById(id)) {
            throw new HouseNotFoundException(id);
        }
        houseRespository.deleteById(id);
        return "House " + id + " deleted";
    }
}
