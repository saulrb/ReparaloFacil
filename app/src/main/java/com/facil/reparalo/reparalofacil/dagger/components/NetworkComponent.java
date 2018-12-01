package com.facil.reparalo.reparalofacil.dagger.components;


import com.facil.reparalo.reparalofacil.dagger.modules.NetworkModule;
import com.facil.reparalo.reparalofacil.network.services.AuthenticationService;
import com.facil.reparalo.reparalofacil.network.services.UsersService;

import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    AuthenticationService getAuthenticationService();

    UsersService getUserService();
}
