package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.isil.restaurant.adapter.StoreFullAdapter;
import com.isil.restaurant.adapter.StoreAdapter;
import com.isil.restaurant.model.Store;
import com.isil.restaurant.model.Store;

import java.util.ArrayList;
import java.util.List;

public class StoresActivity extends AppCompatActivity {

    RecyclerView storeFullRecycler;
    StoreFullAdapter storeFullAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Locales");

        // ingresar data al modelo

        List<Store> storeFullList = new ArrayList<>();
        storeFullList.add(new Store("Caminos", "https://i.imgur.com/1KsMzVX.png","30 min", "36", "Jr Camino 1213"));
        storeFullList.add(new Store("Larco", "https://i.imgur.com/1KsMzVX.png","20 min", "22", "Jr Larco 1213"));
        storeFullList.add(new Store("Centro", "https://i.imgur.com/1KsMzVX.png","50 min", "25", "Jr Centro 1213"));

        setStoreFullRecycler(storeFullList);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setStoreFullRecycler(List<Store> storeFullList){
        storeFullRecycler = findViewById(R.id.stores_recycler_full);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        storeFullRecycler.setLayoutManager(layoutManager);
        storeFullAdapter = new StoreFullAdapter(this, storeFullList);
        storeFullRecycler.setAdapter(storeFullAdapter);
    }


}