package com.isil.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.isil.restaurant.adapter.FoodAdapter;
import com.isil.restaurant.adapter.RecommendationAdapter;
import com.isil.restaurant.adapter.StoreAdapter;
import com.isil.restaurant.model.Food;
import com.isil.restaurant.model.Recommendation;
import com.isil.restaurant.model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    RecyclerView recommendationRecycler;
    RecommendationAdapter recommendationAdapter;
    RecyclerView storeRecycler;
    StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton mbtnHamburguer = findViewById(R.id.btnHamburguer);

        mbtnHamburguer.setOnClickListener(this);

        // ingresar data al modelo

        List<Recommendation> recommendationList = new ArrayList<>();
        recommendationList.add(new Recommendation("Pasta", "3.2", "30 min", "$50", R.drawable.itemone));
        recommendationList.add(new Recommendation("Fideo", "4.5", "40 min", "$50", R.drawable.itemtwo));
        recommendationList.add(new Recommendation("Sandwich", "3.2", "30 min", "$50", R.drawable.itemthree));

        setRecommendationRecycler(recommendationList);

        List<Store> storeList = new ArrayList<>();
        storeList.add(new Store("Caminos", R.drawable.storeone,"30 min"));
        storeList.add(new Store("Larco", R.drawable.storeone,"30 min"));
        storeList.add(new Store("Centro", R.drawable.storeone,"30 min"));

        setStoreRecycler(storeList);


    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, CategoryActivity.class));

    }

    private void setRecommendationRecycler(List<Recommendation> recommendationList){
        recommendationRecycler = findViewById(R.id.recommendation_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recommendationRecycler.setLayoutManager(layoutManager);
        recommendationAdapter = new RecommendationAdapter(this,recommendationList);
        recommendationRecycler.setAdapter(recommendationAdapter);
    }

    private void setStoreRecycler(List<Store> storeList){
        storeRecycler = findViewById(R.id.stores_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        storeRecycler.setLayoutManager(layoutManager);
        storeAdapter = new StoreAdapter(this, storeList);
        storeRecycler.setAdapter(storeAdapter);
    }





}