package com.facil.reparalo.reparalofacil.models;

public class AuthenticationModel {

    CredencialsModel auth;

    public CredencialsModel getAuth() {
        return auth;
    }

    public AuthenticationModel setAuth(CredencialsModel auth) {
        this.auth = auth;
        return this;
    }
}
