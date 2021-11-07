package com.food.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.food.R;
import com.food.adapter.category.CategoryAdapter;
import com.food.databinding.HomeFragmentBinding;
import com.food.model.CategoryModel;
import com.food.responses.CategroyResonse;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CategoryAdapter.ClicedCategories
{


    private HomeViewModel homeViewModel;
    private HomeFragmentBinding binding;
    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        homeViewModel.getCategory().observe(getViewLifecycleOwner(), new Observer<CategroyResonse>()
        {
            @Override
            public void onChanged(CategroyResonse categroyResonse)
            {
                if (categroyResonse != null)
                {
                    ArrayList<CategoryModel> categoryModels = categroyResonse.getCategoryModels();
                    categoryAdapter = new CategoryAdapter(categoryModels, HomeFragment.this);
                    binding.rVCategory.setAdapter(categoryAdapter);
                    binding.rVCategory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                }
            }
        });
    }

    @Override
    public void clickCategory(CategoryModel categoryModel)
    {
        Toast.makeText(getActivity(), categoryModel.getIdCategory(), Toast.LENGTH_SHORT).show();
    }
}