package com.example.dam.gamo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cabre_000 on 23/5/2016.
 */
public class ProvaActivity extends AppCompatActivity {

    Prova prova= new Prova();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);


        prova=((NET)this.getApplication()).getPr();


        prova.esports=antiNull(prova.esports);
        prova.preu=antiNull(prova.preu);
        prova.distancia=antiNull(prova.distancia);
        prova.desnivellPositiu=antiNull(prova.desnivellPositiu);
        prova.desnivellNegatiu=antiNull(prova.desnivellNegatiu);
        prova.desnivellAcumulat=antiNull(prova.desnivellAcumulat);
        prova.num_avituallaments=antiNull(prova.num_avituallaments);
        prova.nom=antiNull( prova.nom);
        prova.modalitat=antiNull(prova.modalitat);
        prova.pagina_organitzacio=antiNull(prova.pagina_organitzacio);
        prova.data_hora_inici=antiNull(prova.data_hora_inici);
        prova.obertura_inscripcions=antiNull(prova.obertura_inscripcions);
        prova.limit_inscrits=antiNull(prova.tancament_inscripcionts);
        prova.temps_limit=antiNull(prova.temps_limit);
        prova.limit_inscrits=antiNull(prova.limit_inscrits) ;
        prova.direccio=antiNull(prova.direccio);
        prova.descripcio=antiNull(prova.descripcio);



        TextView esports=  (TextView)findViewById(R.id.tvesp);
        TextView preu=  (TextView)findViewById(R.id.tvPrise);
        TextView distancia=  (TextView)findViewById(R.id.tvDistance);
        TextView desnivellPositiu=  (TextView)findViewById(R.id.tvdesp);
        TextView desnivellNegatiu=  (TextView)findViewById(R.id.tvdesn);
        TextView desnivellAcumulat= (TextView)findViewById(R.id.tvdesac);
        TextView num_avituallaments=  (TextView)findViewById(R.id.tvnumav);
        TextView nom=  (TextView)findViewById(R.id.tvTitol);
        TextView modalitat= (TextView)findViewById(R.id.tvModality);
        TextView pagina_organitzacio= (TextView)findViewById(R.id.tvOrganicer);
        TextView data_hora_inici= (TextView)findViewById(R.id.tvdataInici);
        TextView obertura_inscripcions= (TextView)findViewById(R.id.tvInsop);
        TextView tancament_inscripcionts= (TextView)findViewById(R.id.tvinsclose);
        TextView temps_limit= (TextView)findViewById(R.id.tvLimittemps);
        TextView limit_inscrits= (TextView)findViewById(R.id.tvmains);
        TextView direccio= (TextView)findViewById(R.id.tvLocation);
        TextView descripcio=  (TextView)findViewById(R.id.tvdescript);





        esports.setText( prova.esports);
        preu.setText(prova.preu);
        distancia.setText(prova.distancia);
        desnivellPositiu.setText(prova.desnivellPositiu);
        desnivellNegatiu.setText(prova.desnivellNegatiu);
        desnivellAcumulat.setText(prova.desnivellAcumulat);
        num_avituallaments.setText(prova.num_avituallaments);
        nom.setText( prova.nom);
        modalitat.setText(prova.modalitat);
        pagina_organitzacio.setText(prova.pagina_organitzacio);
        data_hora_inici.setText(prova.data_hora_inici);
        obertura_inscripcions.setText(prova.obertura_inscripcions);
        tancament_inscripcionts.setText(prova.tancament_inscripcionts);
        temps_limit.setText(prova.temps_limit);
        limit_inscrits.setText(prova.limit_inscrits) ;
        direccio.setText(prova.direccio);
        descripcio.setText(prova.descripcio);



    }
    public String antiNull(String txt){
        if(txt.equals("null")||txt.equals("")|| txt.equals(null)){
            return"Undefined";
        }else{return txt;}
    }

}



