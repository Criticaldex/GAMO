package com.example.dam.gamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btReg = (Button) findViewById(R.id.btRegistrarse);
        btReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(LoginActivity.this, RegistreActivity.class));
    }
}
