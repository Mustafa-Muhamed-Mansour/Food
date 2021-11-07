package com.food.responses;

import com.food.model.CategoryModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategroyResonse
{

    @SerializedName("categories")
    private ArrayList<CategoryModel> categoryModels;


    public CategroyResonse()
    {
    }

    public ArrayList<CategoryModel> getCategoryModels() {
        return categoryModels;
    }
}
