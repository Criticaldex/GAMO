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

//import com.github.snowdream.android.widget.SmartImageView;

import java.util.ArrayList;

/**
 * Created by cabre_000 on 20/5/2016.
 */
public class EventAdapter extends ArrayAdapter<Event> {
    Context context;
    int layoutResourceId;
    ArrayList<Event> data = null;

    public EventAdapter(Context context, int layoutResourceId, ArrayList<Event>  data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EventHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new EventHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.my_image);
            holder.txtTitle = (TextView)row.findViewById(R.id.tvTitol);
            holder.descripcio=(TextView)row.findViewById(R.id.tvDescr);
            holder.dataI=(TextView)row.findViewById(R.id.tvDataI);
            holder.dataF=(TextView)row.findViewById(R.id.tvModalitat);
            row.setTag(holder);
        }
        else
        {
            holder = (EventHolder)row.getTag();
        }

        Event Event = data.get(position);
        String cadenaUrl="http://10.0.2.2/GAMO_WEB-master/images/events/"+Event.id+"/"+Event.url;
        holder.txtTitle.setText(Event.titol);
        Uri urltouri= Uri.parse(cadenaUrl);
        holder.imgIcon.setImageURI(urltouri);
        holder.descripcio.setText(Event.descripcio);
        holder.dataI.setText(Event.dataInici);
        holder.dataF.setText(Event.dataFinal);
        return row;
    }

    static class EventHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        TextView descripcio;
        TextView dataI;
        TextView dataF;
    }
}
