package com.be_got_java_api.char_database.model;

import jakarta.persistence.Id;

public class Religion {
    @Id
    private String religionName;

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }
}