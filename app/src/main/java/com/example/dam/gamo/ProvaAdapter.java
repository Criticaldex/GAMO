package com.example.dam.gamo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cabre_000 on 22/5/2016.
 */
public class ProvaAdapter  extends ArrayAdapter<Prova> {
    Context context;
    int layoutResourceId;
    ArrayList<Prova> data = null;

    public ProvaAdapter(Context context, int layoutResourceId, ArrayList<Prova>  data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProvaHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ProvaHolder();
            holder.nom=  (TextView)row.findViewById(R.id.tvTit);
            holder.imgIcon=(ImageView)row.findViewById(R.id.image);
            holder.descripcio=(TextView)row.findViewById(R.id.tvDescript);
            holder.dataInici=(TextView)row.findViewById(R.id.tvDataini);
            holder.direccio=(TextView)row.findViewById(R.id.tvLocation);
            holder.esports=(TextView)row.findViewById(R.id.tvSport);
            holder.modalitat=(TextView)row.findViewById(R.id.tvModalitat);
            holder.distancia=(TextView)row.findViewById(R.id.tvDistancia);
            holder.tancament_inscripcionts=(TextView)row.findViewById(R.id.tvInsced);
            row.setTag(holder);
        }
        else
        {
            holder = (ProvaHolder)row.getTag();
        }

        Prova Prova = data.get(position);
        String cadenaUrl="http://10.0.2.2/GAMO_WEB-master/images/Provas/"+Prova.id+"/"+Prova.url;
        holder.nom.setText(Prova.nom);
        Uri urltouri= Uri.parse(cadenaUrl);
        holder.imgIcon.setImageURI(urltouri);
        holder.descripcio.setText(Prova.descripcio);
        holder.dataInici.setText(Prova.data_hora_inici);
        holder.direccio.setText(Prova.direccio);
        holder.esports.setText(Prova.esports);
        holder.modalitat.setText(Prova.modalitat);
        holder.distancia.setText(Prova.descripcio);
        holder.tancament_inscripcionts.setText(Prova.tancament_inscripcionts);
        return row;
    }

    static class ProvaHolder
    {
        ImageView imgIcon;
        TextView esports;
        TextView distancia;
        TextView descripcio;
        TextView nom;
        TextView modalitat;
        TextView dataInici;
        TextView tancament_inscripcionts;
        TextView limit_inscrits;
        TextView direccio;
    }
}
