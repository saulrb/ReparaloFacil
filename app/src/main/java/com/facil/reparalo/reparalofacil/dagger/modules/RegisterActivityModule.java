package com.facil.reparalo.reparalofacil.dagger.modules;

import com.facil.reparalo.reparalofacil.activities.RegisterActivity;

import dagger.Module;

@Module
public class RegisterActivityModule {

    private final RegisterActivity registerActivity;

    public RegisterActivityModule(RegisterActivity registerActivity){
        this.registerActivity = registerActivity;
    }
}
