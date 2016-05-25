package com.example.dam.gamo;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {

    public static final String KEY_USERNAME="username";
    private String mail;
    private String[] menu;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    User us;
    EventAdapter adapter;

    //ArrayList<Event> aldata;

    public String LOGIN_URL = "";

    TextView email = (TextView) findViewById(R.id.tvEmail);
    TextView nom = (TextView) findViewById(R.id.tvName);
    TextView cNom = (TextView) findViewById(R.id.tvLastName);
    TextView dataNaix = (TextView) findViewById(R.id.tvBirthdate);
    TextView esport = (TextView) findViewById(R.id.tvSport);
    TextView cp = (TextView) findViewById(R.id.tvCp);
    TextView estat = (TextView) findViewById(R.id.tvCountry);
    TextView regio = (TextView) findViewById(R.id.tvRegion);
    TextView poblacio = (TextView) findViewById(R.id.tvCity);
    TextView direccio = (TextView) findViewById(R.id.tvAdress);
    TextView tel1 = (TextView) findViewById(R.id.tvPhone);
    TextView tel2 = (TextView) findViewById(R.id.tvEmergency);
    TextView talla = (TextView) findViewById(R.id.tvShirt);
    ImageView img = (ImageView) findViewById(R.id.imageView2);
    TextView club = (TextView) findViewById(R.id.tvClub);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        menu = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        setTitle(menu[1]);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, menu));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        Intent intent = getIntent();
        mail = intent.getStringExtra(LoginActivity.KEY_USERNAME);

        email.setText(us.email);
       /* =us.nom;
        =us.cNom;
        =us.dataNaix;
        =us.esport;
        =us.cp;
        =us.estat;
        =us.regio;
        =us.poblacio;
        =us.direccio;
        =us.tel1;
        =us.tel2;
        =us.talla;
        =us.img;
        =us.club;*/
    }

    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

            switch (position) {
                case 0:
                    Intent intent = new Intent(PerfilActivity.this, PerfilActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent2 = new Intent(PerfilActivity.this, MainActivity.class);
                    intent2.putExtra(KEY_USERNAME, mail);
                    startActivity(intent2);
                    break;
            }
        }

        private void selectItem(int position) {

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            setTitle(menu[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }
    public void onStart() {

        LOGIN_URL = "http://10.0.2.2/GAMO_WEB/API/users/user.php?mail=" + mail + "";
        super.onStart();
        // Create request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Create json array request

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, LOGIN_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                us=new User();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                us.Id=jsonObject.getString("Id");
                                us.email=jsonObject.getString("email");
                                nom.setText(jsonObject.getString("nom"));
                                us.cNom=jsonObject.getString("cNom");
                                us.dataNaix=jsonObject.getString("dataNaix");
                                us.esport=jsonObject.getString("esport");
                                us.cp=jsonObject.getString("cp");
                                us.estat=jsonObject.getString("estat");
                                us.regio=jsonObject.getString("regio");
                                us.poblacio=jsonObject.getString("poblacio");
                                us.direccio=jsonObject.getString("direccio");
                                us.tel1=jsonObject.getString("tel1");
                                us.tel2=jsonObject.getString("tel2");
                                us.talla=jsonObject.getString("talla");
                                us.img=jsonObject.getString("img");
                                us.club=jsonObject.getString("FK_id_club");
                                //aldata.add(us);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("Error", "Unable to parse json array");
                    }
                });
        // add json array request to the request queue
        requestQueue.add(jsonArrayRequest);
    }
}
