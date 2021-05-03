package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.isil.restaurant.adapter.CartAdapter;
import com.isil.restaurant.adapter.CartAdapter;
import com.isil.restaurant.model.Cart;
import com.isil.restaurant.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    RecyclerView cartRecycler;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Shopping Cart");

        List<Cart> recommendationList = new ArrayList<>();
        recommendationList.add(new Cart("Pasta", "$50", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg", "1"));
        recommendationList.add(new Cart("Fideo", "$50", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg", "3"));
        recommendationList.add(new Cart("Sandwich", "$50", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F5563136.jpg", "1"));

        setCartRecycler(recommendationList);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setCartRecycler(List<Cart> cartList){
        cartRecycler = findViewById(R.id.cart_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        cartRecycler.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(this,cartList);
        cartRecycler.setAdapter(cartAdapter);
    }
}