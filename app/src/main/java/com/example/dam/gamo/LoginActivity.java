package com.example.dam.gamo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Object Exeption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        Button btReg = (Button) findViewById(R.id.btRegistrarse);
        btReg.setOnClickListener(this);
        btLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.btLogin) {
            EditText etMail = (EditText) findViewById(R.id.etUser);
            EditText etPass = (EditText) findViewById(R.id.etPassword);

            boolean response = verifica(etPass.getText().toString(), etMail.getText().toString());
            if (response == true) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Context context = getApplicationContext();
                CharSequence text = "Email or password doesnt match";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        } else
            if (v.getId() == R.id.btRegistrarse) {
                startActivity(new Intent(LoginActivity.this, RegistreActivity.class));
            }
        }


    protected  boolean  verifica(String password, String mail ) {
        String str = "localhost/GAMO_WEB-master/API/users/valid.php?email=" + mail + " & ?password= " + password;

        URL url = null;
        try {
            url = new URL(str);
            URLConnection urlc = url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            String response = "";
            JSONObject jo = null;
            while ((line = bfr.readLine()) != null) {
                JSONArray jsa = new JSONArray(line);
                for (int x = 0; x < jsa.length(); x++) {
                    jo = (JSONObject) jsa.get(x);
                }
                response = jo.toString();

            }

            if (response.trim().equals("true")) {
                return true;
            } else {
                return false;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
