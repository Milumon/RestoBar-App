package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.isil.restaurant.adapter.StoreFullAdapter;
import com.isil.restaurant.model.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StoresActivity extends AppCompatActivity {

    // RecyclerView storeFullRecycler;
    // StoreFullAdapter storeFullAdapter;

    // CONSUMIR SERVICIO
    String TAG="SERVICIOS";

    private RequestQueue requestQueue;
    List<Store> storesList;
    RecyclerView storeFullRecycler;
    StoreFullAdapter storeFullAdapter;
    JsonArrayRequest jsArrayRequest3;
    /////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Locales");

        showStores();
        storeFullRecycler =(RecyclerView) findViewById(R.id.stores_recycler_full);

        // método anterior para pintar data hardcodeada
        // ingresar data al modelo
/*
        List<Store> storeFullList = new ArrayList<>();

        storeFullList.add(new Store("","Caminos", "Jr Camino 1213", "30", "https://i.imgur.com/1KsMzVX.png","30 min"));
        storeFullList.add(new Store("","Larco", "Jr Larco 1213", "24", "https://i.imgur.com/1KsMzVX.png","30 min"));
        storeFullList.add(new Store("","Centro", "Jr Centro 1213", "22", "https://i.imgur.com/1KsMzVX.png","30 min"));

        setStoreFullRecycler(storeFullList);*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    // método anterior para pintar data hardcodeada

/*    private void setStoreFullRecycler(List<Store> storeFullList){
        storeFullRecycler = findViewById(R.id.stores_recycler_full);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        storeFullRecycler.setLayoutManager(layoutManager);
        storeFullAdapter = new StoreFullAdapter(this, storeFullList);
        storeFullRecycler.setAdapter(storeFullAdapter);
    }*/

    public void showStores()
    {
        String URL_BASE="https://milumon.000webhostapp.com/servicios/locales.php";
        requestQueue= Volley.newRequestQueue(StoresActivity.this);

        // Nueva petición JSONObject
        jsArrayRequest3 = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE ,
                (JSONObject) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray json) {
                        try {

                            JSONObject jsonobject;
                            Store it;
                            storesList = new ArrayList<>();
                            for(int i=0;i<json.length();i++)
                            {
                                jsonobject = json.getJSONObject(i);


                                storesList.add(new Store("",jsonobject.getString("nombre"), jsonobject.getString("direccion"), jsonobject.getString("capacidad"), "https://milumon.000webhostapp.com/locales"+ jsonobject.getString("imagen"), "00:00"));
                                System.out.println(storesList);
                            }


                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoresActivity.this, RecyclerView.VERTICAL, false);
                            storeFullRecycler.setLayoutManager(layoutManager);
                            storeFullAdapter = new StoreFullAdapter(StoresActivity.this, storesList);

                            storeFullRecycler.setAdapter(storeFullAdapter);
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());

                    }
                }
        );

        // Añadir petición a la cola
        requestQueue.add(jsArrayRequest3);

    }


}