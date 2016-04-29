package com.example.dam.gamo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistreActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        Button btReg = (Button) findViewById(R.id.btRegistre);
        btReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText mail = (EditText) findViewById(R.id.etMail);
        EditText nom = (EditText) findViewById(R.id.etNom);
        EditText cnom = (EditText) findViewById(R.id.etCnom);
        EditText pass = (EditText) findViewById(R.id.etPassword);
        EditText pass2 = (EditText) findViewById(R.id.etPassword2);

        if(mail.getText().toString().equals("") || nom.getText().toString().equals("") || cnom.getText().toString().equals("") || pass.getText().toString().equals("") || pass2.getText().toString().equals("")){
            new AlertDialog.Builder(this)
                    .setTitle("Ayy Caramba!!")
                    .setMessage("No has omplert tots els camps!!")
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // No fer res
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else{
            String email = mail.getText().toString();
            String pas = nom.getText().toString();
            String fname = cnom.getText().toString();
            String dateob = pass.getText().toString();
            String add12 = pass2.getText().toString();

            startActivity(new Intent(RegistreActivity.this, LoginActivity.class));
        }
    }
}
