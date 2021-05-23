package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.isil.restaurant.adapter.CategoryAdapter;
import com.isil.restaurant.adapter.EmployeeAdapter;
import com.isil.restaurant.adapter.StoreFullAdapter;
import com.isil.restaurant.adapter.StoreFullAdapter;
import com.isil.restaurant.model.Category;
import com.isil.restaurant.model.Employee;
import com.isil.restaurant.model.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServiciosActivity extends AppCompatActivity implements View.OnClickListener
{
    private RequestQueue requestQueue;
    JsonArrayRequest jsArrayRequest;
    JsonObjectRequest jsArrayRequest2;
    JsonArrayRequest jsArrayRequest3;
    EmployeeAdapter adapter;
    CategoryAdapter adapter2;
    StoreFullAdapter adapter3;
    Button btnservicio1,btnservicio2, btnservicio3;
    RecyclerView recycler_servicios;
    ProgressBar progress;
    String TAG="SERVICIOS";
    List<Employee> servicios;
    List<Category> categorias;
    List<Store> locales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_servicios);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Consultas");


        progress=(ProgressBar) findViewById(R.id.progress);
        btnservicio1=(Button) findViewById(R.id.btnservicio1);
        btnservicio2=(Button) findViewById(R.id.btnservicio2);
        btnservicio3=(Button) findViewById(R.id.btnservicio3);

        recycler_servicios=(RecyclerView) findViewById(R.id.recycler_servicios);

        btnservicio1.setOnClickListener(this);
        btnservicio2.setOnClickListener(this);
        btnservicio3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnservicio1:
                progress.setVisibility(View.VISIBLE);
                metodo_getservicio1();
                break;
            case R.id.btnservicio2:
                progress.setVisibility(View.VISIBLE);
                metodo_getservicio2();
                break;
            case R.id.btnservicio3:
                progress.setVisibility(View.VISIBLE);
                metodo_getservicio3();
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void metodo_getservicio1()
    {
        String URL_BASE="https://servicios.campus.pe/servicioempleados.php";
        requestQueue= Volley.newRequestQueue(ServiciosActivity.this);

        // Nueva petición JSONObject
        jsArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE ,
                (JSONObject) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray json) {
                        try {

                            JSONObject jsonobject;
                            Employee it;
                            servicios = new ArrayList<>();
                            for(int i=0;i<json.length();i++)
                            {
                                jsonobject = json.getJSONObject(i);


                                servicios.add(new Employee(jsonobject.getString("idempleado"), jsonobject.getString("apellidos"), jsonobject.getString("nombres"), jsonobject.getString("cargo"), jsonobject.getString("fechanacimiento")));

                            }

                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ServiciosActivity.this, RecyclerView.VERTICAL, false);
                            recycler_servicios.setLayoutManager(layoutManager);
                             adapter = new EmployeeAdapter(ServiciosActivity.this,servicios);

                            recycler_servicios.setAdapter(adapter);
                            progress.setVisibility(View.GONE);
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
        requestQueue.add(jsArrayRequest);

    }

    public void metodo_getservicio2()
    {
        String URL_BASE="http://llegue.do/api_usuarios/?action=get_categorias";
        requestQueue= Volley.newRequestQueue(ServiciosActivity.this);

        // Nueva petición JSONObject
        jsArrayRequest2 = new JsonObjectRequest(
                Request.Method.GET,
                URL_BASE ,
                (JSONObject) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject json1) {
                        try {

                            JSONArray json;
                            json = json1.getJSONArray("categorias");

                            JSONObject jsonobject;

                            categorias = new ArrayList<>();
                            for(int i=0;i<json.length();i++)
                            {
                                jsonobject = json.getJSONObject(i);


                                categorias.add(new Category(jsonobject.getString("id_categoria"), jsonobject.getString("nombre_categoria"), jsonobject.getString("icono_categoria")));

                            }

                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ServiciosActivity.this, RecyclerView.VERTICAL, false);
                            recycler_servicios.setLayoutManager(layoutManager);
                            adapter2 = new CategoryAdapter(ServiciosActivity.this,categorias);

                            recycler_servicios.setAdapter(adapter2);
                            adapter2.notifyDataSetChanged();
                            progress.setVisibility(View.GONE);
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
        requestQueue.add(jsArrayRequest2);

    }



    public void metodo_getservicio3()
    {
        String URL_BASE="https://milumon.000webhostapp.com/servicios/locales.php";
        requestQueue= Volley.newRequestQueue(ServiciosActivity.this);

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
                            locales = new ArrayList<>();
                            for(int i=0;i<json.length();i++)
                            {
                                jsonobject = json.getJSONObject(i);


                                locales.add(new Store("",jsonobject.getString("nombre"), jsonobject.getString("direccion"), jsonobject.getString("capacidad"), "https://milumon.000webhostapp.com/locales"+ jsonobject.getString("imagen"), "00:00"));
                                System.out.println(locales);
                            }
 

                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ServiciosActivity.this, RecyclerView.VERTICAL, false);
                            recycler_servicios.setLayoutManager(layoutManager);
                            adapter3 = new StoreFullAdapter(ServiciosActivity.this,locales);

                            recycler_servicios.setAdapter(adapter3);
                            progress.setVisibility(View.GONE);
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