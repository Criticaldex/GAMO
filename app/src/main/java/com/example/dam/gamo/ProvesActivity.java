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
    Prova pr;
    ProvaAdapter adapter;
    ArrayList<Prova> aldataProva;
    public String IP = "";
    public String LOGIN_URL = "";
    NET net;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proves);

        Intent intent = getIntent();
        usuari = intent.getStringExtra(LoginActivity.KEY_USERNAME);
        IP = ((NET) this.getApplication()).getIP();
        net=(NET) this.getApplication();
        menu = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setTitle(menu[1]);


        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, menu));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        ListView listView = (ListView) findViewById(R.id.list);
        aldataProva = new ArrayList<Prova>();
        adapter = new ProvaAdapter(this, R.layout.item_layout_prova,aldataProva);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClickListener());

    }

    public class ItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Prova prova = aldataProva.get(position);
            Intent intent = new Intent(ProvesActivity.this, ProvaActivity.class);
            net.setPr(prova);
            startActivity(intent);


        }

        private void selectItem(int position) {


        }
    }


    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
            switch (position) {
                case 0:
              /*     Prova prova = aldataProva.get(position);
                    Intent intent = new Intent(ProvesActivity.this, ProvaActivity.class);
                    intent.putExtra("prova",prova);
                    startActivity(intent);*/
                    break;
            }
        }

        private void selectItem(int position) {
            mDrawerList.setItemChecked(position, true);
            setTitle(menu[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    public void onStart() {
        super.onStart();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String evId="";
        if(b!=null)
        {
             evId =(String) b.get("idEvent");
        }
        LOGIN_URL = IP+"/API/events/getProves.php?eventId="+evId;

        // Create request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Create json array request

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {//[{"Id":"1","FK_Id_event":"1","FK_IdValoracio_Valoracio":"1","esports":null,"preu":"15","distancia":"40","desnivellPositiu":"2000","desnivellNegatiu":"1800","desnivellAcumulat":"200","num_avituallaments":"4","nom":"COSAS","modalitat":"alguna","recorregut":"algun","Imatges":"..\/default.png","pagina_organitzacio":"www.google.com","validated":"2","descripcio":"kjdlsmnskdfsdfkjnasfdkmmkmk","data_hora_inici":"2016-05-03 00:00:00","obertura_inscripcions":"2016-05-05 00:00:00","tancament_inscripcionts":"2016-05-25 00:00:00","temps_limit":"1","limit_inscrits":"4","cp":"8490","estat":"caca","regio":"catalunya","poblacio":"Barcelono","direccio":"0sjhsdk","coordenades":"44,000 123123,000"},{"Id":"2","FK_Id_event":"1","FK_IdValoracio_Valoracio":"1","esports":null,"preu":"15","distancia":"40","desnivellPositiu":"2000","desnivellNegatiu":"1800","desnivellAcumulat":"200","num_avituallaments":"4","nom":"COSAS2","modalitat":"alguna","recorregut":"algun","Imatges":"..\/default.png","pagina_organitzacio":"www.google.com","validated":"2","descripcio":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","data_hora_inici":"2016-05-03 10:00:00","obertura_inscripcions":"2016-05-05 00:00:00","tancament_inscripcionts":"2016-05-25 00:00:00","temps_limit":"1","limit_inscrits":"4","cp":"08460","estat":"Cansas","regio":"Carribean","poblacio":"Mono","direccio":"55as","coordenades":"44,000 123123,000"}]
                                pr=new Prova();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                pr.id=jsonObject.get("Id").toString();
                                pr.nom=jsonObject.getString("nom");
                                pr.tancament_inscripcionts=jsonObject.getString("tancament_inscripcionts");
                                pr.url=IP+"/images/events/"+pr.id+"/";
                                pr.url+=jsonObject.getString("Imatges");
                                pr.data_hora_inici=jsonObject.getString("data_hora_inici");
                                pr.descripcio=jsonObject.getString("descripcio");
                                pr.limit_inscrits=jsonObject.getString("limit_inscrits");
                                pr.desnivellAcumulat=jsonObject.getString("desnivellAcumulat");
                                pr.desnivellNegatiu=jsonObject.getString("desnivellNegatiu");
                                pr.desnivellPositiu=jsonObject.getString("desnivellPositiu");
                                pr.distancia=jsonObject.getString("distancia");
                                pr.esports=jsonObject.getString("esports");
                                pr.direccio=jsonObject.getString("estat");
                                pr.direccio+=", "+jsonObject.getString("regio");
                                pr.direccio+=", "+jsonObject.getString("poblacio");
                                pr.direccio+=", "+jsonObject.getString("direccio");
                                pr.modalitat=jsonObject.getString("modalitat");
                                pr.num_avituallaments=jsonObject.getString("num_avituallaments");
                                pr.preu=jsonObject.getString("preu");
                                pr.pagina_organitzacio=jsonObject.getString("pagina_organitzacio");
                                pr.obertura_inscripcions=jsonObject.getString("obertura_inscripcions");
                                pr.temps_limit=jsonObject.getString("temps_limit");
                                aldataProva.add(pr);
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
