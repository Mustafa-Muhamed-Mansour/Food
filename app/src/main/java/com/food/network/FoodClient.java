package com.food.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient
{

    private String BASE_URL = "https://www.themealdb.com/";
    private static Retrofit retrofit;

    public Retrofit getRetrofit()
    {

        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
