package com.isil.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button mbtnLogin = findViewById(R.id.btnLogin);
        mbtnLogin.setOnClickListener(this);

        Button mbtnRegister = findViewById(R.id.btnRegistrarse);
        mbtnRegister.setOnClickListener(this);

        TextView mbtnForgotPass = findViewById(R.id.forgotPassword);
        mbtnForgotPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnLogin:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnRegistrarse:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this, RecoverPasswordActivity.class));
                break;

        }

    }
}