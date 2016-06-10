package com.example.dam.gamo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cabre_000 on 20/5/2016.
 */
public class Event implements Parcelable {
    String titol;
    String id;
    String url;
    String descripcio;
    String dataInici;
    String dataFinal;
    public Event(){super();}
    public Event( String titol,String id,String descripcio, String dataInici, String dataFinal,String url){
        this.id=id;
        this.titol=titol;
        this.url=url;
        this.descripcio=descripcio;
        this.dataInici=dataInici;
        this.dataFinal=dataFinal;
    }

    protected Event(Parcel in) {
        titol = in.readString();
        id = in.readString();
        url = in.readString();
        descripcio = in.readString();
        dataInici = in.readString();
        dataFinal = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titol);
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(descripcio);
        dest.writeString(dataInici);
        dest.writeString(dataFinal);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}