package com.be_got_java_api.char_database.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private Boolean dead;
    private String religion;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getDead() {
        return dead;
    }
    public void setDead(Boolean dead) {
        this.dead = dead;
    }
    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion) {
        this.religion = religion;
    }


    }