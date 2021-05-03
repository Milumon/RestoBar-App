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

public class HamburguerActivity extends AppCompatActivity {


    RecyclerView foodRecycler;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Categorias");

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Hamburguer", "TASTY","3.2","30 min","$50","Hamburguer", "https://pngimg.com/uploads/burger_sandwich/burger_sandwich_PNG96777.png"));
        foodList.add(new Food("Hamburguer2", "TASTY","5.3","30 min","$50","Hamburguer", "https://pngimg.com/uploads/burger_sandwich/burger_sandwich_PNG96777.png"));
        foodList.add(new Food("Drink", "TASTY","3.0,","30 min","$50", "Drink", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Drink", "TASTY","3.2","30 min","$50","Drink", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg"));
        foodList.add(new Food("Pizza", "TASTY","5.3","30 min","$50","Pizza", "hhttps://i.imgur.com/9iEBDRx.png"));
        foodList.add(new Food("Pizza", "TASTY","3.0,","30 min","$50", "Pizza", "https://i.imgur.com/9iEBDRx.png"));
        foodList.add(new Food("Chicken", "TASTY","3.2","30 min","$50","Chicken", "https://i.imgur.com/Vj1ixrL.png"));
        foodList.add(new Food("Chicken", "TASTY","5.3","30 min","$50","Chicken", "https://i.imgur.com/Vj1ixrL.png"));

        // PREGUNTAR A STALIN COMO RECIBIR LA CATEGORÍA SEGÚN EL ICONO AL QUE LE HAGAN CLICK EN EL MAINACTIVITY
        // 
        setFoodRecycler(foodList, "Hamburguer");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFoodRecycler(List<Food> foodList, String category){
        Log.e("FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO", foodList.toString());
        foodRecycler = findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        foodRecycler.setLayoutManager(layoutManager);
        List<Food> finalList = foodList.stream().filter(x -> x.getCategory().contains(category)).collect(Collectors.toList());
        foodAdapter = new FoodAdapter(this, finalList);
        foodRecycler.setAdapter(foodAdapter);
    }


}