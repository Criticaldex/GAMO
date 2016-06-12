package com.example.dam.gamo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.snowdream.android.widget.SmartImage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity {

    public String LOGIN_URL = "";
    Event ev;
    EventAdapter adapter;
    ArrayList<Event> aldata;
    private TextView textView;
    private String[] menu;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ListView listView;
    private String usuari;
    private String IP = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menu = getResources().getStringArray();
        menu = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        setTitle(menu[1]);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, menu));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        listView = (ListView) findViewById(R.id.list);
        aldata = new ArrayList<Event>();

        adapter = new EventAdapter(this, R.layout.item_layout,aldata);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClickListener());

        Intent intent = getIntent();
        usuari = intent.getStringExtra(LoginActivity.KEY_USERNAME);
        IP = getResources().getString(R.string.IP);
    }

    public void onStart() {

        LOGIN_URL = IP +"/API/events/getEvents.php";
        super.onStart();
        // Create request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Create json array request

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                ev=new Event();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                ev.titol=jsonObject.getString("titol");
                                ev.id=jsonObject.getString("Id");
                                ev.descripcio= jsonObject.getString("descripcio");
                                ev.dataInici= jsonObject.getString("dataInici");
                                ev.dataFinal=jsonObject.getString("dataFinal");
                                ev.url=IP+"/images/events/"+ev.id+"/";
                                ev.url+=jsonObject.getString("imatges");
                                aldata.add(ev);

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

    public class ItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Event eve = aldata.get(position);
            Intent intent = new Intent(MainActivity.this, ProvesActivity.class);
            intent.putExtra("idEvent",eve.id);
            startActivity(intent);


        }

        private void selectItem(int position) {


        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

            switch (position) {
                case 0:
                    Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                    intent.putExtra("user",usuari);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent2 = new Intent(MainActivity.this, MainActivity.class);

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
}