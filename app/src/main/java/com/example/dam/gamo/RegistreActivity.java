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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                params.put("password1", dades[3]);
                params.put("password2", dades[4]);


                return params;
            }
        };

// Añadimos la petición a la cola de peticiones de Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    boolean valid=false;
    @Override
    public void onClick(View v) {

        EditText mail = (EditText) findViewById(R.id.etMail);
        EditText nom = (EditText) findViewById(R.id.etNom);
        EditText cnom = (EditText) findViewById(R.id.etCnom);
        EditText pass = (EditText) findViewById(R.id.etPassword);
        EditText pass2 = (EditText) findViewById(R.id.etPassword2);
            String[] dades = new String[5];
            dades=validation(mail.getText().toString(), nom.getText().toString() , cnom.getText().toString(),pass.getText().toString(), pass2.getText().toString());

            if (valid==true){
                sendByPost(dades);
                startActivity(new Intent(RegistreActivity.this, LoginActivity.class));
            }else{
                new AlertDialog.Builder(this)
                        .setTitle("hey watch it!!")
                        .setMessage(dades[0])
                        .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert).show();
            }
    }
    public String[] validation(String mail,String nom ,String cnom,String pass,String pass2){
        boolean boolemail = true;
        boolean boolpass= true;
        String[] dades = new String[5];
        String cadenaerr="";
        boolean vuit=false;
        boolemail=emailValidator(mail);
        boolean boolpassl=false;
        if(mail.equals("") || nom.equals("") || cnom.equals("") || pass.equals("") || pass2.equals("")){
            cadenaerr="You have to fill all the fields.";
            vuit=true;
        }

        if(pass.length()<6 && vuit!=true||pass2.length()<6 && vuit!=true){

            cadenaerr="\n You have to put a pasoword with sixs characters or more.";
            boolpassl=true;
        }
        if(!pass.equals(pass2) && vuit==false){
           cadenaerr+=" \nYour passwords dosen't match.";
            boolpass=false;
        }
        if(boolemail!=true && vuit==false){
                cadenaerr += "\nWrong email.";

        }
        if(boolemail!=true || boolpass!=true|| vuit!=false||boolpassl==true){
           dades[0]=cadenaerr;

        }else{

            dades[0] = mail;
            dades[1] = nom;
            dades[2] = cnom;
            dades[3] = pass;
            dades[4] = pass2;
            valid=true;
        }
        return dades;

    }
    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
