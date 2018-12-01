package com.facil.reparalo.reparalofacil.models;

public class UserModel {

    private Details user;

    public Details getUser() {
        return user;
    }

    public void setUser(Details user) {
        this.user = user;
    }

    public class Details {

        private String email;
        private String password;
        private String username;


        public String getEmail() {
            return email;
        }

        public Details setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Details setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public Details setUsername(String username) {
            this.username = username;
            return this;
        }
    }
}

