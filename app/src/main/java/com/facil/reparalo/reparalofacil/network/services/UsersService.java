package com.facil.reparalo.reparalofacil.network.services;

import com.facil.reparalo.reparalofacil.models.ResponseStatusModel;
import com.facil.reparalo.reparalofacil.models.UserModel;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersService {

    @POST("/users/create")
    Flowable<ResponseStatusModel> creaetUser(@Body UserModel userModel);

}
