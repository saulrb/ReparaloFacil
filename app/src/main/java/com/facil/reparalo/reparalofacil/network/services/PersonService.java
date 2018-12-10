package com.facil.reparalo.reparalofacil.network.services;

import com.facil.reparalo.reparalofacil.models.CustomerModel;
import com.facil.reparalo.reparalofacil.models.ResponseStatusModel;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonService {

    @POST("/customers/create")
    Flowable<ResponseStatusModel> creaetPerson(@Body CustomerModel customerModel);

    @PUT("/customers/{id}")
    Flowable<ResponseStatusModel> updatePerson(@Path("id") String id , @Body CustomerModel customerModel );

    @DELETE("/customers/{id}")
    Flowable<ResponseStatusModel> deletePerson(@Path("id") String id );

    @GET("/customers/{id}")
    Flowable<CustomerModel> getPerson(@Path("id") String id );

    @GET("/customers/find/{name}")
    Flowable<CustomerModel> findPerson(@Path("name") String name);

}
