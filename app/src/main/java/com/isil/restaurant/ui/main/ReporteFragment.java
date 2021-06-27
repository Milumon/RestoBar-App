package com.isil.restaurant.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isil.restaurant.R;
import com.isil.restaurant.adapter.TransactionAdapter;
import com.isil.restaurant.datos.DatosSQLite;
import com.isil.restaurant.model.Transaction;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReporteFragment extends Fragment {

    RecyclerView mlvReporte;
    RecyclerView transactionRecycler;
    TransactionAdapter transactionAdapter;


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

        List<Transaction> transactionList = new ArrayList<>();

        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.mostrarTodo(datosSQLite);
        Integer count = 0;
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    System.out.println(cursor.getString(cursor.getColumnIndex("idmovimiento")));
                    Transaction transaction = new Transaction();
                    transaction.setIdmovimiento(cursor.getString(cursor.getColumnIndex("idmovimiento")));
                    transaction.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
                    transaction.setMonto(cursor.getDouble(cursor.getColumnIndex("monto")));
                    transaction.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
                    transaction.setMovimiento(cursor.getString(cursor.getColumnIndex("movimiento")));
                    transactionList.add(transaction);


                }while(cursor.moveToNext());
            }
        }
        setTransactionRecycler(transactionList);

    }


    private void setTransactionRecycler(List<Transaction> transactionList){
        Log.e("FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO", transactionList.toString());
        transactionRecycler = mlvReporte;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        transactionRecycler.setLayoutManager(layoutManager);
        transactionAdapter = new TransactionAdapter(getContext(), transactionList);
        transactionRecycler.setAdapter(transactionAdapter);
    }
}