package com.AlpDereli.StajProjesi.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



public class AdminDto {

    private String name;
    private String password;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
