package com.isil.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.isil.restaurant.adapter.RecommendationAdapter;
import com.isil.restaurant.adapter.StoreAdapter;
import com.isil.restaurant.model.Recommendation;
import com.isil.restaurant.model.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

/*    RecyclerView recommendationRecycler;
    RecommendationAdapter recommendationAdapter;*/
/*    RecyclerView storeRecycler;
    StoreAdapter storeAdapter;*/


    private RequestQueue requestQueue;

    // CONSUMIR SERVICIO *nuevo*
    String TAGs ="STORES";

    List<Store> storesList;
    RecyclerView storeRecycler;
    StoreAdapter storeAdapter;
    JsonArrayRequest jsArrayRequest3;
    /////////////////////

    // CONSUMIR SERVICIO *nuevo2*
    String TAGr ="RECOMENDACIONES";

    List<Recommendation> recommendationList;
    RecyclerView recommendationRecycler;
    RecommendationAdapter recommendationAdapter;
    JsonArrayRequest jsArrayRequest2;
    /////////////////////


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


        showStores();
        storeRecycler =(RecyclerView) findViewById(R.id.stores_recycle);
        showRecommendation();
        recommendationRecycler =(RecyclerView) findViewById(R.id.recommendation_recycler);

        // ingresar data al modelo

/*        List<Recommendation> recommendationList = new ArrayList<>();
        recommendationList.add(new Recommendation("Arroz con Pollo", "5.2", "30 min", "$50", "https://i.imgur.com/839PxP5.png"));
        recommendationList.add(new Recommendation("Sandwich", "3.2", "50 min", "$30", "https://i.imgur.com/9iEBDRx.png"));
        recommendationList.add(new Recommendation("Pasta", "4.6", "30 min", "$40", "https://i.imgur.com/Vj1ixrL.png"));

        setRecommendationRecycler(recommendationList);*/

/*        List<Store> storeList = new ArrayList<>();
        storeList.add(new Store("","Caminos", "Jr Camino 1213", "30", "https://i.imgur.com/1KsMzVX.png","30 min"));
        storeList.add(new Store("","Larco", "Jr Larco 1213", "24", "https://i.imgur.com/1KsMzVX.png","30 min"));
        storeList.add(new Store("","Centro", "Jr Centro 1213", "22", "https://i.imgur.com/1KsMzVX.png","30 min"));

        setStoreRecycler(storeList);*/
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
                startActivity(new Intent(this, HamburguerActivity.class));
                break;
            case R.id.btnChicken:
                startActivity(new Intent(this, HamburguerActivity.class));
                break;
            case R.id.btnDrink:
                startActivity(new Intent(this, HamburguerActivity.class));
                break;
            case R.id.btnPizza:
                startActivity(new Intent(this, HamburguerActivity.class));
                break;
            case R.id.btnVerMasLocales:
                startActivity(new Intent(this, StoresActivity.class));
                break;
            case R.id.btnVerMasRecomendaciones:
                startActivity(new Intent(this, RecommendationActivity.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_perfil:
                mostrarPerfil();
                return true;
            case R.id.nav_carrito:
                mostrarCarrito();
                return true;
            case R.id.nav_recomendaciones:
                mostrarRecomendaciones();
                return true;
            case R.id.nav_salir:
                finish();
                return true;
            case R.id.nav_locales:
                mostrarLocales();
                return true;
            case R.id.nav_nosotros:
                mostrarNosotros();
                return true;
            case R.id.nav_listados:
                mostrarListados();
                return true;
            case R.id.nav_caja:
                mostrarCaja();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarPerfil() {  startActivity(new Intent(this, ProfileActivity.class)); }

    private void mostrarCarrito() { startActivity(new Intent(this, ShoppingCart.class));    }

    private void mostrarLocales() { startActivity(new Intent(this, StoresActivity.class));  }

    private void mostrarNosotros() {    startActivity(new Intent(this, NosotrosActivity.class));    }

    private void mostrarCaja() {   startActivity(new Intent(this,CashActivity.class));    }

    private void mostrarRecomendaciones() { startActivity(new Intent(this,RecommendationActivity.class));   }

    private void mostrarListados() { startActivity(new Intent(this,ServiciosActivity.class));   }
    ////////////////////////////////

/*    private void setRecommendationRecycler(List<Recommendation> recommendationList){
        recommendationRecycler = findViewById(R.id.recommendation_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recommendationRecycler.setLayoutManager(layoutManager);
        recommendationAdapter = new RecommendationAdapter(this,recommendationList);
        recommendationRecycler.setAdapter(recommendationAdapter);
    }*/

/*    private void setStoreRecycler(List<Store> storeList){
        storeRecycler = findViewById(R.id.stores_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        storeRecycler.setLayoutManager(layoutManager);
        storeAdapter = new StoreAdapter(this, storeList);
        storeRecycler.setAdapter(storeAdapter);
    }*/

    public void showStores()
    {
        String URL_BASE="https://milumon.000webhostapp.com/servicios/locales.php";
        requestQueue= Volley.newRequestQueue(MainActivity.this);

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


                                storesList.add(new Store("",jsonobject.getString("nombre"), jsonobject.getString("direccion"), jsonobject.getString("capacidad"), "https://milumon.000webhostapp.com/locales"+ jsonobject.getString("imagen"), "30" + "min"));
                                System.out.println(storesList);
                            }


                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                            storeRecycler.setLayoutManager(layoutManager);
                            storeAdapter = new StoreAdapter(MainActivity.this, storesList);

                            storeRecycler.setAdapter(storeAdapter);
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAGs, "Error Respuesta en JSON: " + error.getMessage());

                    }
                }
        );

        // Añadir petición a la cola
        requestQueue.add(jsArrayRequest3);

    }


    public void showRecommendation()
    {
        String URL_BASE="https://milumon.000webhostapp.com/servicios/recomendaciones.php";
        requestQueue= Volley.newRequestQueue(MainActivity.this);

        // Nueva petición JSONObject
        jsArrayRequest2 = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE ,
                (JSONObject) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray json) {
                        try {

                            JSONObject jsonobject;
                            Store it;
                            recommendationList = new ArrayList<>();
                            for(int i=0;i<json.length();i++)
                            {
                                jsonobject = json.getJSONObject(i);


                                recommendationList.add(new Recommendation("",jsonobject.getString("nombre"), jsonobject.getString("rating"), jsonobject.getString("tiempo") + "min", "S/"+ jsonobject.getString("precio"), "https://milumon.000webhostapp.com/recomendaciones" + jsonobject.getString("imageURL")));
                                System.out.println(recommendationList);
                            }


                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                            recommendationRecycler.setLayoutManager(layoutManager);
                            recommendationAdapter = new RecommendationAdapter(MainActivity.this, recommendationList);

                            recommendationRecycler.setAdapter(recommendationAdapter);
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAGr, "Error Respuesta en JSON: " + error.getMessage());

                    }
                }
        );

        // Añadir petición a la cola
        requestQueue.add(jsArrayRequest2);

    }
}