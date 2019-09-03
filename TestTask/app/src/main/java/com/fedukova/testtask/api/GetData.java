package com.fedukova.testtask.api;

import java.util.List;

import com.fedukova.testtask.entity.Animal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    @GET("/cat")
    Call<List<Animal>> getCats();

    @GET("/dog")
    Call<List<Animal>> getDogs();
}
