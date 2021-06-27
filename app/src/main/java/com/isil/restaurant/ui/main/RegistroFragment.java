package com.isil.restaurant.ui.main;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.isil.restaurant.R;
import com.isil.restaurant.datos.DatosSQLite;
import com.isil.restaurant.model.Transaction;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RegistroFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextInputEditText mtetDescripcion, mtetMonto;
    Button mbtnRegistrar;
    Switch toggleButton;
    List<Transaction> transactionList = new ArrayList<>();

    // variables para contador

    TextView ingresos, gastos, total;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtetDescripcion = view.findViewById(R.id.tetDescripcion);
        mtetMonto = view.findViewById(R.id.tetMonto);
        mbtnRegistrar = view.findViewById(R.id.btnRegistrar);
        mbtnRegistrar.setOnClickListener(this);
        // switch
        toggleButton = view.findViewById(R.id.switchValue);
        toggleButton.setOnCheckedChangeListener(this);
        toggleButton.setChecked(false);
        leerDatos();
        // variables contador
        ingresos = view.findViewById(R.id.txtIngresosAmount);
        gastos = view.findViewById(R.id.txtGastosAmount);
        total = view.findViewById(R.id.txtTotalAmount);
        contarSaldo(transactionList);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRegistrar:
                registrarMov();
                break;
        }
    }

    private void registrarMov() {
        String descripcion = mtetDescripcion.getText().toString();
        String monto = mtetMonto.getText().toString();
        Integer movimiento = toggleButton.isChecked() ? -1 : 1;
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        int autonumerico = datosSQLite.registrarMovimiento(datosSQLite, descripcion, Float.parseFloat(monto), movimiento);
        System.out.println("debería ser 1 " + autonumerico);
        Toast.makeText(getActivity(), String.valueOf(autonumerico), Toast.LENGTH_SHORT).show();
        mtetDescripcion.setText("");
        mtetMonto.setText("");
        mtetDescripcion.requestFocus();
        leerDatos();
        contarSaldo(transactionList);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setText("Gasto");
            toggleButton.setChecked(true);
        } else {
            buttonView.setText("Ingreso");
            toggleButton.setChecked(false);
        }
        Log.v("Switch State=", "" + isChecked);

    }

    private void leerDatos() {

        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.mostrarTodo(datosSQLite);
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
    }

    private void contarSaldo(List<Transaction> transactionList){
            ingresos.setText("0");
            gastos.setText("0");
            total.setText("0");
            Double ingresosAmount = getAmount(transactionList, "1");
            Double gastosAmount = getAmount(transactionList, "-1");
            Double totalAmount = ingresosAmount - gastosAmount;
            ingresos.setText(String.format("%.2f", ingresosAmount));
            gastos.setText(String.format("%.2f", gastosAmount));
            total.setText(String.format("%.2f", totalAmount));
    }

    private Double getAmount(List<Transaction> transactionList, String text){
        Double total = transactionList.stream()
                .filter(x -> x.getMovimiento().equals(text))
                .mapToDouble(Transaction::getMonto)
                .sum();;
        return total;
    }


    @Override
    public void onResume() {
        super.onResume();
        transactionList.clear();

    }
}