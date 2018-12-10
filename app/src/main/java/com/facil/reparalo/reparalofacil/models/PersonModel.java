package com.facil.reparalo.reparalofacil.models;

public class PersonModel {

    private String firstname;
    private String lastname;
    private String street;
    private String location;
    private String city;
    private String county;
    private String zip_code;
    private String phone;
    private String email;

    public PersonModel(){
        super();
    }

    public String getFirstname() {
        return firstname;
    }

    public PersonModel setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public PersonModel setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public PersonModel setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PersonModel setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PersonModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public PersonModel setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getZip_code() {
        return zip_code;
    }

    public PersonModel setZip_code(String zip_code) {
        this.zip_code = zip_code;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PersonModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
