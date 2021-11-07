package com.food.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.food.model.CategoryModel;
import com.food.network.FoodClient;
import com.food.network.FoodService;
import com.food.responses.CategroyResonse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository
{

    private FoodService foodService;

    public HomeRepository()
    {
        foodService = new FoodClient().getRetrofit().create(FoodService.class);
    }

    public LiveData<CategroyResonse> getCategory()
    {

        MutableLiveData<CategroyResonse> categoryMutableLiveData = new MutableLiveData<>();

        foodService
                .getCategory()
                .enqueue(new Callback<CategroyResonse>()
                {
                    @Override
                    public void onResponse(Call<CategroyResonse> call, Response<CategroyResonse> response)
                    {
                        categoryMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<CategroyResonse> call, Throwable t)
                    {
                        categoryMutableLiveData.setValue(null);
                    }
                });

        return categoryMutableLiveData;
    }
}
