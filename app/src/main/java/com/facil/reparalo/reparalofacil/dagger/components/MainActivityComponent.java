package com.facil.reparalo.reparalofacil.dagger.components;

import com.facil.reparalo.reparalofacil.activities.MainActivity;
import com.facil.reparalo.reparalofacil.dagger.modules.ContextModule;
import com.facil.reparalo.reparalofacil.dagger.modules.MainActivityModule;
import com.facil.reparalo.reparalofacil.dagger.modules.PreferencesModule;

import dagger.Component;

@Component(modules = {MainActivityModule.class, ContextModule.class},
        dependencies = {NetworkComponent.class,PreferencesComponent.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
