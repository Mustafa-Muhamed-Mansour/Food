package com.food.model;

import com.google.gson.annotations.SerializedName;

public class CategoryModel
{

    @SerializedName("idCategory")
    private String idCategory;
    @SerializedName("strCategory")
    private String nameCategory;
    @SerializedName("strCategoryThumb")
    private String imageCategory;
    @SerializedName("strCategoryDescription")
    private String descriptionCategory;

    public CategoryModel()
    {
    }

    public CategoryModel(String idCategory, String nameCategory, String imageCategory, String descriptionCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.imageCategory = imageCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getImageCategory() {
        return imageCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }
}
