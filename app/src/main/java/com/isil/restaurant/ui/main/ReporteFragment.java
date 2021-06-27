package com.isil.restaurant.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.isil.restaurant.R;
import com.isil.restaurant.datos.DatosSQLite;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class ReporteFragment extends Fragment {

    ListView mlvReporte;
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporte, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mlvReporte = view.findViewById(R.id.lvReporte);
        leerDatos();
    }

    private void leerDatos() {
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.mostrarTodo(datosSQLite);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    HashMap<String,String> map = new HashMap<>();
                    map.put("idmmovimiento",cursor.getString(cursor.getColumnIndex("idmovimiento")));
                    map.put("descripcion",cursor.getString(cursor.getColumnIndex("descripcion")));
                    map.put("monto",cursor.getString(cursor.getColumnIndex("monto")));
                    map.put("fecha",cursor.getString(cursor.getColumnIndex("fecha")));
                    map.put("movimiento",cursor.getString(cursor.getColumnIndex("movimiento")));
                    arrayList.add(map);
                }while(cursor.moveToNext());
            }
        }
    }
}