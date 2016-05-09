package com.example.dam.gamo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistreActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        Button btReg = (Button) findViewById(R.id.btRegistre);
        btReg.setOnClickListener(this);
    }
    public void sendByPost(final String[] dades){

        String url = "http://10.0.2.2/GAMO_WEB-master/API/users/valid.php";



        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()  {

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegistreActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistreActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        }
        ) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("email", dades[0]);
                params.put("name", dades[1]);
                params.put("lastname", dades[2]);
                params.put("pass1", dades[3]);
                params.put("pass2", dades[4]);


                return params;
            }
        };

// Añadimos la petición a la cola de peticiones de Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
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
                    .setTitle("hey watch it!!")
                    .setMessage("you have to fill all the fields")
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // No fer res
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert).show();
        }
        else{
            String[] dades = new String[5];
            dades[0] = mail.getText().toString();
            dades[1] = nom.getText().toString();
            dades[2] = cnom.getText().toString();
            dades[3] = pass.getText().toString();
            dades[4] = pass2.getText().toString();
            sendByPost(dades);
            startActivity(new Intent(RegistreActivity.this, LoginActivity.class));
        }
    }
}
