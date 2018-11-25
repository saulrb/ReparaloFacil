package com.facil.reparalo.reparalofacil.models;

public class CredencialsModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public CredencialsModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CredencialsModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
