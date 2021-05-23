package com.isil.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.isil.restaurant.fragments.JosemariaFragment;
import com.isil.restaurant.fragments.MarianaFragment;
import com.isil.restaurant.fragments.MiluskaFragment;

public class NosotrosActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Nosotros");
        RadioButton mbtnPersonaUno = findViewById(R.id.btnPersonaUno);
        RadioButton mbtnPersonaDos = findViewById(R.id.btnPersonaDos);
        RadioButton mbtnPersonaTres = findViewById(R.id.btnPersonaTres);

        mbtnPersonaUno.setOnClickListener(this);
        mbtnPersonaDos.setOnClickListener(this);
        mbtnPersonaTres.setOnClickListener(this);

        mostrarPersonaUno();
        mbtnPersonaUno.setChecked(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPersonaUno:
                mostrarPersonaUno();
                break;
            case R.id.btnPersonaDos:
                mostrarPersonaDos();
                break;
            case R.id.btnPersonaTres:
                mostrarPersonaTres();
                break;
        }
    }

    private void mostrarPersonaUno() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.constraintTeam, new MiluskaFragment())
                .commit();
    }

    private void mostrarPersonaDos() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.constraintTeam, new MarianaFragment())
                .commit();
    }

    private void mostrarPersonaTres() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.constraintTeam, new JosemariaFragment())
                .commit();
    }
}