package com.food.network;

import com.food.model.CategoryModel;
import com.food.responses.CategroyResonse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodService
{

    @GET("api/json/v1/1/categories.php")
    Call<CategroyResonse> getCategory();
}
