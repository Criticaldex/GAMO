package com.example.dam.gamo;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class ProvesActivity extends AppCompatActivity {

    private TextView textView;
    private String[] menu;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String usuari;
    ArrayAdapter<String> adapter;
    ArrayList<String> items;
    ArrayList<String> Contact;
    public String LOGIN_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proves);
     /*   menu = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        setTitle(menu[1]);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, menu));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        ListView listView = (ListView) findViewById(R.id.list);
        items = new ArrayList<String>();
        adapter = new ArrayAdapter(this, R.layout.item_layout, R.id.txt, items);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        usuari = intent.getStringExtra(LoginActivity.KEY_USERNAME);*/
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
            switch (position) {
                case 0:
                    Intent intent = new Intent(ProvesActivity.this, ProvesActivity.class);
                    startActivity(intent);
                    break;
            }
        }

        private void selectItem(int position) {
            // update the main content by replacing fragments
/*
        Fragment fragment = new PlanetFragment();
        Bundle args = new Bundle();
        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            // update selected item and title, then close the drawer
  */        mDrawerList.setItemChecked(position, true);
            setTitle(menu[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    public void onStart() {
        LOGIN_URL = "http://10.0.2.2/GAMO_WEB-master/API/events/getProves.php?eventId";
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
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                items.add(jsonObject.getString("titol"));
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
