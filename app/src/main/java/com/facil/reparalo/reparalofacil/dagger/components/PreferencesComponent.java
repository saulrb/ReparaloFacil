package com.facil.reparalo.reparalofacil.dagger.components;

import com.facil.reparalo.reparalofacil.dagger.modules.ContextModule;
import com.facil.reparalo.reparalofacil.dagger.modules.PreferencesModule;
import com.facil.reparalo.reparalofacil.preferences.services.PreferencesService;

import dagger.Component;

@Component(modules = {PreferencesModule.class,ContextModule.class})
public interface PreferencesComponent {

    PreferencesService getPreferencesService();

}
