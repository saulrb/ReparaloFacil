package com.facil.reparalo.reparalofacil.dagger.components;


import com.facil.reparalo.reparalofacil.activities.RegisterActivity;
import com.facil.reparalo.reparalofacil.dagger.modules.ContextModule;
import com.facil.reparalo.reparalofacil.dagger.modules.RegisterActivityModule;

import dagger.Component;

@Component(modules = {RegisterActivityModule.class, ContextModule.class},
        dependencies = {NetworkComponent.class,PreferencesComponent.class})
public interface RegisterActivityComponent {
    void inject(RegisterActivity registerActivity);
}
