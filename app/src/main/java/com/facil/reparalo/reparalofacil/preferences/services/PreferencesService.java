package com.facil.reparalo.reparalofacil.preferences.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.facil.reparalo.reparalofacil.models.CredencialsModel;


public class PreferencesService {

    private final String PREFERENCE_FILE_KEY = "com.facil,reparalo.reparalofacil.PREFERENCE_FILE_KEY";
    private Context context;

    public PreferencesService setContext(Context context){
        this.context = context;
        return this;
    }

    public PreferencesService saveCredentials(CredencialsModel credencials){
        this.context.getSharedPreferences(PREFERENCE_FILE_KEY,Context.MODE_PRIVATE)
                .edit()
                .putString("0",credencials.getEmail())
                .putString("1",credencials.getPassword())
                .apply();
        return this;
    }

    public void clearCredentials(){
        this.context.getSharedPreferences(PREFERENCE_FILE_KEY,Context.MODE_PRIVATE)
                .edit()
                .putString("0",null)
                .putString("1",null)
                .apply();
    }

    public CredencialsModel getCredentials(){
        SharedPreferences sp = this.context.getSharedPreferences(PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);
        return new CredencialsModel()
                   .setEmail(sp.getString( "0",null ))
                   .setPassword(sp.getString("1",null));
    }

    public void saveRememberMe(boolean rememberMe){
        this.context.getSharedPreferences(PREFERENCE_FILE_KEY,Context.MODE_PRIVATE)
                .edit()
                .putBoolean("3",rememberMe)
                .apply();
    }

    public boolean getRememberMe(){
        return this.context.getSharedPreferences(PREFERENCE_FILE_KEY,Context.MODE_PRIVATE).getBoolean("3",false);
    }
}
