package com.food.adapter.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.food.databinding.ItemCategoryBinding;
import com.food.model.CategoryModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{

    private ArrayList<CategoryModel> categoryModels;

    private ClicedCategories clicedCategories;


    public CategoryAdapter(ArrayList<CategoryModel> categoryModels, ClicedCategories clicedCategories)
    {
        this.categoryModels = categoryModels;
        this.clicedCategories = clicedCategories;
    }

    public interface ClicedCategories
    {
        void clickCategory(CategoryModel categoryModel);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position)
    {
        CategoryModel model = categoryModels.get(position);
        holder.binding.itemTxtCategory.setText(model.getNameCategory());
        Glide
                .with(holder.itemView.getContext())
                .load(model.getImageCategory())
                .into(holder.binding.itemImgCategory);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clicedCategories.clickCategory(model);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return categoryModels.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder
    {

        private ItemCategoryBinding binding;

        public CategoryViewHolder(@NonNull ItemCategoryBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
