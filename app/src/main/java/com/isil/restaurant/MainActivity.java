package com.isil.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.isil.restaurant.adapter.RecommendationAdapter;
import com.isil.restaurant.adapter.StoreAdapter;
import com.isil.restaurant.model.Recommendation;
import com.isil.restaurant.model.Store;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recommendationRecycler;
    RecommendationAdapter recommendationAdapter;
    RecyclerView storeRecycler;
    StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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