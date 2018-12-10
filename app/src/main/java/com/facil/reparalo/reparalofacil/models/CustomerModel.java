package com.facil.reparalo.reparalofacil.models;

public class CustomerModel {
    PersonModel customer;

    public CustomerModel(){
    }

    public PersonModel getCustomer() {
        return customer;
    }

    public CustomerModel setCustomer(PersonModel customer) {
        this.customer = customer;
        return this;
    }
}
