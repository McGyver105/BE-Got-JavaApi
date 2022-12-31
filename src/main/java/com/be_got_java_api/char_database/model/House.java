package com.be_got_java_api.char_database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class House {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "housename", unique = true, nullable = false)
    private String housename;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getHousename() {
        return housename;
    }
    public void setHousename(String housename) {
        this.housename = housename;
    }

    public House() {
    }
}