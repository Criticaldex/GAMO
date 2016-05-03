package com.example.dam.gamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class benvingutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benvingut);
        //Button btn = new Button(this);
        ImageButton ib = (ImageButton) findViewById(R.id.ibEntrar);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(benvingutActivity.this, LoginActivity.class));
    }
}
