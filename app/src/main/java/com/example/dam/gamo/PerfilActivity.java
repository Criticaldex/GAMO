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
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {

    public static final String KEY_USERNAME="username";

    private String mail="";
    private String[] menu;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    User us;
    ArrayAdapter<String> adapter;

   // ImageLoader imgLoader= AppController.getInstance(this).getImageLoader();


    //ArrayList<Event> aldata;
    public String IP = "";
    public String url = "";


    TextView email;
    TextView nom ;
    TextView cNom ;
    TextView dataNaix ;
    TextView esport ;
    TextView cp ;
    TextView estat ;
    TextView regio ;
    TextView poblacio ;
    TextView direccio ;
    TextView tel1 ;
    TextView tel2;
    TextView talla;
    // NetworkImageView img ;
    TextView club ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        IP = ((NET) this.getApplication()).getIP();
        us=new User();
        email = (TextView) findViewById(R.id.tvEmail);
        nom = (TextView) findViewById(R.id.tvName);
        cNom = (TextView) findViewById(R.id.tvLastName);
        dataNaix = (TextView) findViewById(R.id.tvBirthdate);
        esport = (TextView) findViewById(R.id.tvSport);
        cp = (TextView) findViewById(R.id.tvCp);
        estat = (TextView) findViewById(R.id.tvCountry);
        regio = (TextView) findViewById(R.id.tvRegion);
        poblacio = (TextView) findViewById(R.id.tvCity);
        direccio = (TextView) findViewById(R.id.tvAdress);
        tel1 = (TextView) findViewById(R.id.tvPhone);
        tel2 = (TextView) findViewById(R.id.tvEmergency);
        talla = (TextView) findViewById(R.id.tvShirt);
        // img = (NetworkImageView) findViewById(R.id.imageView2);
        club = (TextView) findViewById(R.id.tvClub);

        onStart();
     /*   menu = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        setTitle(menu[1]);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item, menu ));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

*/




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
        super.onStart();
        Intent intent = getIntent();
        mail= intent.getStringExtra("user");
        url = IP+"/API/users/user.php?mail=" + mail;

        // Create request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Create json array request
        Log.d("url:",url);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response str", response.toString());
                        try {
                            us.Id=response.getString("regio");
                            Log.d("response str",  us.Id);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try{
                        us.Id=response.getString("Id");
                            email.setText(response.getString("email"));
                        nom.setText(response.getString("nom"));
                        cNom.setText(response.getString("cNom"));
                        dataNaix.setText(response.getString("dataNaix"));
                        esport.setText(response.getString("esport"));
                        cp.setText(response.getString("cp"));
                        estat.setText("cepanya");//response.getString("estat");
                        regio.setText(response.getString("regio"));
                        poblacio.setText(response.getString("poblacio"));
                        direccio.setText(response.getString("direccio"));
                        tel1.setText(response.getString("tel1"));
                        tel2.setText(response.getString("tel2"));
                        talla.setText(response.getString("talla"));
                       // us.img=response.getString("img");
                       club.setText("Banengs");//response.getString("FK_id_club");
                    } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("response err", "Error: " + error.getMessage());
                // Ocultamos el mensaje de cargando
                //pDialog.hide();
            }
        }
        );

        requestQueue.add(jsonObjReq);

























        /*JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                        if(response!=null){
                            try {


                                //response.getString("id");
                                //us.Id=response.getString("Id");

                                us.email=response.getString("email");
                                us.nom=response.getString("nom");
                                us.cNom=response.getString("cNom");
                                us.dataNaix=response.getString("dataNaix");
                                us.esport=response.getString("esport");
                                us.cp=response.getString("cp");
                                us.estat=response.getString("estat");
                                us.regio=response.getString("regio");
                                us.poblacio=response.getString("poblacio");
                                us.direccio=response.getString("direccio");
                                us.tel1=response.getString("tel1");
                                us.tel2=response.getString("tel2");
                                us.talla=response.getString("talla");
                                us.img=response.getString("img");
                                us.club=response.getString("FK_id_club");
                                //aldata.add(us);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("Error",volleyError.getMessage());
                    }
                });
        // add json array request to the request queue
        requestQueue.add(jsonObjectRequest);*/
    }
}
