package com.example.dam.gamo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.dam.gamo.model.WorldsBillionaires;
import com.example.dam.gamo.AppController;
import com.example.dam.gamo.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private Activity activity;
    private LayoutInflater inflater;
    private List<WorldsBillionaires> billionairesItems;

    public CustomListAdapter(Activity activity, List<WorldsBillionaires> billionairesItems) {
        this.activity = activity;
        this.billionairesItems = billionairesItems;
    }

    @Override
    public int getCount() {
        return billionairesItems.size();
    }

    @Override
    public Object getItem(int location) {
        return billionairesItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView poblacio = (TextView) convertView.findViewById(R.id.worth);
        TextView estat = (TextView) convertView.findViewById(R.id.estat);
        TextView date = (TextView) convertView.findViewById(R.id.inYear);

        // getting billionaires data for the row
        WorldsBillionaires m = billionairesItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // name
        name.setText(m.getName());

        // Wealth source
        estat.setText("Wealth date1: " + String.valueOf(m.getEstat()));


        poblacio.setText(String.valueOf(m.getPoblacio()));

        // release year
        date.setText(String.valueOf(m.getDate()));

        return convertView;
    }

}
