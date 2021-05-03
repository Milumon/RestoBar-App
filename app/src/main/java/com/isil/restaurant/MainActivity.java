package com.isil.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.isil.restaurant.adapter.RecommendationAdapter;
import com.isil.restaurant.adapter.StoreAdapter;
import com.isil.restaurant.model.Recommendation;
import com.isil.restaurant.model.Store;

import java.util.ArrayList;
import java.util.List;

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

        ImageButton mbtnChicken = findViewById(R.id.btnChicken);
        mbtnChicken.setOnClickListener(this);

        ImageButton mbtnDrink = findViewById(R.id.btnDrink);
        mbtnDrink.setOnClickListener(this);

        ImageButton mbtnPizza = findViewById(R.id.btnPizza);
        mbtnPizza.setOnClickListener(this);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicio_sesion, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHamburguer:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case R.id.btnChicken:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case R.id.btnDrink:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case R.id.btnPizza:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_perfil:
                // mostrarPerfil();
                return true;
            case R.id.nav_carrito:
                mostrarCarrito();
                return true;
            case R.id.nav_promociones:
                // mostrarCarrito();
                return true;
            case R.id.nav_salir:
                mostrarSalir();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarCarrito() {

        startActivity(new Intent(this, ShoppingCart.class));
    }

    private void mostrarAyuda() {

        // startActivity(new Intent(this,AyudaActivity.class));
    }

    private void mostrarSalir() {

        startActivity(new Intent(this,LoginActivity.class));
    }

    ////////////////////////////////

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