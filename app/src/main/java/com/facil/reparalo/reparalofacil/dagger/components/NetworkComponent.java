package com.facil.reparalo.reparalofacil.dagger.components;


import com.facil.reparalo.reparalofacil.dagger.modules.NetworkModule;
import com.facil.reparalo.reparalofacil.network.services.AuthenticationService;

import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    AuthenticationService getAuthenticationService();

}
