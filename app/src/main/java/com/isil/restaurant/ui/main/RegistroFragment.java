package com.isil.restaurant.ui.main;

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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.isil.restaurant.R;
import com.isil.restaurant.datos.DatosSQLite;

import org.jetbrains.annotations.NotNull;

public class RegistroFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextInputEditText mtetDescripcion, mtetMonto;
    Button mbtnRegistrar;
    Switch toggleButton;

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
        toggleButton = view.findViewById(R.id.switchValue);
        toggleButton.setOnCheckedChangeListener(this);
        toggleButton.setChecked(false);
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
}