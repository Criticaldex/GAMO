package com.example.dam.gamo;

/**
 * Created by cabre_000 on 20/5/2016.
 */
public class Event {
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
}

