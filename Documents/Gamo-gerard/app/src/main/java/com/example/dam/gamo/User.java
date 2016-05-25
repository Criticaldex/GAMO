package com.example.dam.gamo;

/**
 * Created by cabre_000 on 20/5/2016.
 */
public class User {
    String Id;
    String email;
    String nom;
    String cNom;
    String dataNaix;
    String esport;
    String cp;
    String estat;
    String regio;
    String poblacio;
    String direccio;
    String tel1;
    String tel2;
    String talla;
    String img;
    String club;
    
    public User(){super();}
    public User(String Id, String email, String nom, String cNom, String dataNaix, String esport, String cp,
                String estat, String regio, String poblacio, String direccio, String tel1, String tel2,
                String talla, String img, String id_club){

        this.Id=Id;
        this.email=email;
        this.nom=nom;
        this.cNom=cNom;
        this.dataNaix=dataNaix;
        this.esport=esport;
        this.cp=cp;
        this.estat=estat;
        this.regio=regio;
        this.poblacio=poblacio;
        this.direccio=direccio;
        this.tel1=tel1;
        this.tel2=tel2;
        this.talla=talla;
        this.img=img;
        this.club=id_club;
    }
}

