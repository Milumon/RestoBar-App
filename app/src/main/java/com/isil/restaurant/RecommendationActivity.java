package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.isil.restaurant.adapter.RecommendationFullAdapter;
import com.isil.restaurant.model.Recommendation;

import java.util.ArrayList;
import java.util.List;

public class RecommendationActivity extends AppCompatActivity {

    RecyclerView recommendationFullRecycler;
    RecommendationFullAdapter recommendationFullAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Recomendación");

        // ingresar data al modelo

        List<Recommendation> recommendationFullList = new ArrayList<>();
        recommendationFullList.add(new Recommendation("Arroz con Pollo", "5.2", "30 min", "$50", "https://i.imgur.com/839PxP5.png"));
        recommendationFullList.add(new Recommendation("Sandwich", "3.2", "50 min", "$30", "https://i.imgur.com/9iEBDRx.png"));
        recommendationFullList.add(new Recommendation("Pasta", "4.6", "30 min", "$40", "https://i.imgur.com/Vj1ixrL.png"));

        setRecommendationFullRecycler(recommendationFullList);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRecommendationFullRecycler(List<Recommendation> recommendationFullList){
        recommendationFullRecycler = findViewById(R.id.recommendation_recycler_full);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recommendationFullRecycler.setLayoutManager(layoutManager);
        recommendationFullAdapter = new RecommendationFullAdapter(this, recommendationFullList);
        recommendationFullRecycler.setAdapter(recommendationFullAdapter);
    }
}