package com.food.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.food.model.CategoryModel;
import com.food.repositories.HomeRepository;
import com.food.responses.CategroyResonse;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel
{

    private HomeRepository homeRepository;

    public HomeViewModel()
    {
        homeRepository = new HomeRepository();
    }

    public LiveData<CategroyResonse> getCategory()
    {
        return homeRepository.getCategory();
    }
}