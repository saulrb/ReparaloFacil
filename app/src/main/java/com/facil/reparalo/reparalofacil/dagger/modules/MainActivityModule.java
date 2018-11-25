package com.facil.reparalo.reparalofacil.dagger.modules;

import com.facil.reparalo.reparalofacil.activities.MainActivity;

import dagger.Module;

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

}
