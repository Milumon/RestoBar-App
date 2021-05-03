package com.isil.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        Button mbtnStart = findViewById(R.id.btnStart);

        mbtnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
                startActivity(new Intent(this, LoginActivity.class));

    }






}