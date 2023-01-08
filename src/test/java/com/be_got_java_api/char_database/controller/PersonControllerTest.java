package com.be_got_java_api.char_database.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

import com.be_got_java_api.char_database.model.Person;
import com.be_got_java_api.char_database.repository.PersonRespository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PersonRespository.class)
@Import(PersonController.class)
public class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    PersonRespository personRespository;

    private Person person1 = new Person();
    private Person person2 = new Person();
    private Person person3 = new Person();

    @BeforeEach
    void personSetup() {
        person1.setId(1L);
        person1.setDead(false);
        person1.setReligion("The Seven");

        person1.setId(2L);
        person1.setDead(false);
        person1.setReligion("The Old Gods");

        person1.setId(1L);
        person1.setDead(false);
        person1.setReligion("The Drowned Man");
    }

    @AfterEach
    void personTeardown() {
        person1.setId(null);
        person1.setDead(null);
        person1.setReligion(null);

        person1.setId(null);
        person1.setDead(null);
        person1.setReligion(null);

        person1.setId(null);
        person1.setDead(null);
        person1.setReligion(null);
    }

    @Test
    public void testGetAllPersons() throws Exception {

        List<Person> personRepoList = new ArrayList<>(Arrays.asList(person1, person2, person3));

        Mockito.when(personRespository.findAll()).thenReturn(personRepoList);

        mockMvc.perform(MockMvcRequestBuilders
            .get("/persons")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(personRepoList.size())))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].religion", Matchers.is(person1.getReligion())));
    }
}
