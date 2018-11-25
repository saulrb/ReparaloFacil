package com.facil.reparalo.reparalofacil.network.services;

import com.facil.reparalo.reparalofacil.models.AuthenticationModel;
import com.facil.reparalo.reparalofacil.models.TokenModel;

import io.reactivex.Flowable;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface AuthenticationService {

    @POST("user_token")
    Flowable<TokenModel> getAuthToken(@Body AuthenticationModel auth);

}
