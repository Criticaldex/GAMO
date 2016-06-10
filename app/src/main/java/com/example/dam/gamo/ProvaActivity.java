package com.example.dam.gamo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cabre_000 on 23/5/2016.
 */
public class ProvaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);}{
        Prova prova=((NET) this.getApplication()).getPr();
        start(prova);
    }
    public void start(Prova prova){



        TextView esports=  (TextView)findViewById(R.id.tvSport);
        TextView preu=  (TextView)findViewById(R.id.tvPrise);
        TextView distancia=  (TextView)findViewById(R.id.tvDistance);
        TextView desnivellPositiu=  (TextView)findViewById(R.id.tvdesp);
        TextView desnivellNegatiu=  (TextView)findViewById(R.id.tvdesn);
        TextView desnivellAcumulat= (TextView)findViewById(R.id.tvdesac);
        TextView num_avituallaments=  (TextView)findViewById(R.id.tvnumav);
        TextView nom=  (TextView)findViewById(R.id.tvTit);
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
}
