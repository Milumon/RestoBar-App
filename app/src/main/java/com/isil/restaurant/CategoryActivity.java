package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.isil.restaurant.adapter.FoodAdapter;
import com.isil.restaurant.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryActivity extends AppCompatActivity {


    RecyclerView foodRecycler;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Categorias");

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Hamburguer", "TASTY","3.2","30 min","$50","Hamburguer", "https://i.imgur.com/DvpvklR.png"));
        foodList.add(new Food("Hamburguer2", "TASTY","5.3","30 min","$50","Hamburguer", "https://www.gacetamexicana.com/wp-content/uploads/2015/05/taylor-swift-presenting-jpg.jpg"));
        foodList.add(new Food("Drink", "TASTY","3.0,","30 min","$50", "Drink", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Drink", "TASTY","3.2","30 min","$50","Drink", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Pizza", "TASTY","5.3","30 min","$50","Pizza", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Pizza", "TASTY","3.0,","30 min","$50", "Pizza", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Chicken", "TASTY","3.2","30 min","$50","Chicken", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Chicken", "TASTY","5.3","30 min","$50","Chicken", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));

        // PREGUNTAR A STALIN COMO RECIBIR LA CATEGORÍA SEGÚN EL ICONO AL QUE LE HAGAN CLICK EN EL MAINACTIVITY

        setFoodRecycler(foodList);
    }

    private void setFoodRecycler(List<Food> foodList){
        Log.e("FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO", foodList.toString());
        foodRecycler = findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        foodRecycler.setLayoutManager(layoutManager);
        // foodList.stream().filter(x -> x.getCategory().contains(category)).collect(Collectors.toList());
        foodAdapter = new FoodAdapter(this, foodList);
        foodRecycler.setAdapter(foodAdapter);
    }


}