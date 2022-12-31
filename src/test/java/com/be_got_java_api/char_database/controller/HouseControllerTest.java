package com.be_got_java_api.char_database.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.be_got_java_api.char_database.model.House;
import com.be_got_java_api.char_database.repository.HouseRespository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(HouseRespository.class)
@Import(HouseController.class)
public class HouseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    HouseRespository houseRespository;

    @Test
    public void testGetAllHouses() throws Exception {
        House house1 = new House();
        house1.setId(1L);
        house1.setHousename("Stark");

        House house2 = new House();
        house2.setId(2L);
        house2.setHousename("Lannister");

        House house3 = new House();
        house3.setId(3L);
        house3.setHousename("Baratheon");

        List<House> houseRepoList = new ArrayList<>(Arrays.asList(house1, house2, house3));

        Mockito.when(houseRespository.findAll()).thenReturn(houseRepoList);

        mockMvc.perform(MockMvcRequestBuilders
            .get("/houses")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].housename", Matchers.equalToIgnoringCase("Stark")));
    }
    
    @Test
    void testGetHouseById() throws Exception {
        House house1 = new House();
        house1.setId(1L);
        house1.setHousename("Stark");

        House house2 = new House();
        house2.setId(2L);
        house2.setHousename("Lannister");

        House house3 = new House();
        house3.setId(3L);
        house3.setHousename("Baratheon");
        
        Mockito.when(houseRespository.findById(1L)).thenReturn(Optional.of(house1));
        Mockito.when(houseRespository.findById(2L)).thenReturn(Optional.of(house2));
        Mockito.when(houseRespository.findById(3L)).thenReturn(Optional.of(house3));

        mockMvc.perform(MockMvcRequestBuilders
            .get("/house/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.housename", Matchers.is("Stark")));

        mockMvc.perform(MockMvcRequestBuilders
            .get("/house/2")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.housename", Matchers.is("Lannister")));

        mockMvc.perform(MockMvcRequestBuilders
            .get("/house/3")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(3)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.housename", Matchers.is("Baratheon")));

        mockMvc.perform(MockMvcRequestBuilders
            .get("/house/4")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
        }
    
    @Test
    void testNewHouse() {
        
    }

    @Test
    void testDeleteHouse() {

    }
}