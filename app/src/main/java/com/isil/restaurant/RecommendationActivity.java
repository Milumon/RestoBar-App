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
import com.isil.restaurant.adapter.RecommendationFullAdapter;
import com.isil.restaurant.model.Recommendation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecommendationActivity extends AppCompatActivity {

/*    RecyclerView recommendationFullRecycler;
    RecommendationFullAdapter recommendationFullAdapter;*/

    // CONSUMIR SERVICIO
    String TAG="SERVICIOS";

    private RequestQueue requestQueue;
    List<Recommendation> recommendationsList;
    RecyclerView recommendationFullRecycler;
    RecommendationFullAdapter recommendationFullAdapter;
    JsonArrayRequest jsArrayRequestRecommendation;
    /////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Recomendación");

        showRecommendations();
        recommendationFullRecycler =(RecyclerView) findViewById(R.id.recommendation_recycler_full);

        // ingresar data HARDCODEADA al modelo

/*        List<Recommendation> recommendationFullList = new ArrayList<>();
        recommendationFullList.add(new Recommendation("","Arroz con Pollo", "5.2", "30 min", "$50", "https://i.imgur.com/839PxP5.png"));
        recommendationFullList.add(new Recommendation("","Sandwich", "3.2", "50 min", "$30", "https://i.imgur.com/9iEBDRx.png"));
        recommendationFullList.add(new Recommendation("","Pasta", "4.6", "30 min", "$40", "https://i.imgur.com/Vj1ixrL.png"));

        setRecommendationFullRecycler(recommendationFullList);*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

/*    private void setRecommendationFullRecycler(List<Recommendation> recommendationFullList){
        recommendationFullRecycler = findViewById(R.id.recommendation_recycler_full);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recommendationFullRecycler.setLayoutManager(layoutManager);
        recommendationFullAdapter = new RecommendationFullAdapter(this, recommendationFullList);
        recommendationFullRecycler.setAdapter(recommendationFullAdapter);
    }*/

    public void showRecommendations(){
        String URL_BASE="https://milumon.000webhostapp.com/servicios/recomendaciones.php";
        requestQueue= Volley.newRequestQueue(RecommendationActivity.this);

        // Nueva petición JSONObject
        jsArrayRequestRecommendation = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE ,
                (JSONObject) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray json) {
                        try {

                            JSONObject jsonobject;
                            Recommendation it;
                            recommendationsList = new ArrayList<>();
                            for(int i=0;i<json.length();i++)
                            {
                                jsonobject = json.getJSONObject(i);


                                recommendationsList.add(new Recommendation("",jsonobject.getString("nombre"), jsonobject.getString("rating"), jsonobject.getString("tiempo") + "min", "S/"+ jsonobject.getString("precio"), "https://milumon.000webhostapp.com/recomendaciones" + jsonobject.getString("imageURL")));
                                System.out.println(recommendationsList);
                            }


                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecommendationActivity.this, RecyclerView.VERTICAL, false);
                            recommendationFullRecycler.setLayoutManager(layoutManager);
                            recommendationFullAdapter = new RecommendationFullAdapter(RecommendationActivity.this, recommendationsList);

                            recommendationFullRecycler.setAdapter(recommendationFullAdapter);
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
        requestQueue.add(jsArrayRequestRecommendation);

    }
}