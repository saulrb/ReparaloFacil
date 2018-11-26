package com.facil.reparalo.reparalofacil.network.services;

import com.facil.reparalo.reparalofacil.models.AccessTokenModel;
import com.facil.reparalo.reparalofacil.models.AuthenticationModel;


import io.reactivex.Flowable;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface AuthenticationService {

    @POST("user_token")
    Flowable<AccessTokenModel> getAuthToken(@Body AuthenticationModel auth);

}
