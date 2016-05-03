package com.example.dam.gamo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class RegistreActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        Button btReg = (Button) findViewById(R.id.btRegistre);
        btReg.setOnClickListener(this);
    }

    public void sendPost(String[] dades){


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://myserveraddress";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("tag", "test");
                return params;
            }
        };

        queue.add(strRequest);

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
            String[] dades= new String[4];
            dades[0]=email;
            dades[1]=pass.toString();
            dades[2]=pas;
            dades[3]=fname;
            sendPost(dades);
            startActivity(new Intent(RegistreActivity.this, LoginActivity.class));
        }
    }




}
