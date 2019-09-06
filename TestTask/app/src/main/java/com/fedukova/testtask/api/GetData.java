package com.fedukova.testtask.api;

import com.fedukova.testtask.entity.AnimalList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {

    @GET("api.php")
    Call<AnimalList> getAnimals(@Query("query") String query);
}
