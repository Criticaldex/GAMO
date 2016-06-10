package com.example.dam.gamo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cabre_000 on 22/5/2016.
 */
public class Prova implements Parcelable {
    /*
    esports
    idevent
    esports
    preu
    distancia
    desnivellPositiu
    desnivellNegatiu
    desnivellAcumulat
    num_avituallaments
    nom
    modalitat
    pagina_organitzacio
    data_hora_inici
    obertura_inscripcions
    tancament_inscripcionts
    temps_limit
    limit_inscrits
    direccio
    descripcio
    */
    String id;
    String url;
    String idevent;
    String esports;
    String preu;
    String descripcio;
    String distancia;
    String desnivellPositiu;
    String desnivellNegatiu;
    String desnivellAcumulat;
    String num_avituallaments;
    String nom;
    String modalitat;
    String pagina_organitzacio;
    String data_hora_inici;
    String obertura_inscripcions;
    String tancament_inscripcionts;
    String temps_limit;
    String limit_inscrits;
    String direccio;

    public Prova() {
    }

    public Prova(String id, String idevent, String esports, String preu, String distancia,
                 String desnivellPositiu, String desnivellNegatiu, String desnivellAcumulat,
                 String num_avituallaments, String nom, String modalitat, String pagina_organitzacio,
                 String data_hora_inici, String obertura_inscripcions, String tancament_inscripcionts,
                 String temps_limit, String limit_inscrits, String direccio,String url,String descripcio) {
        this.id=id;
        this.idevent = idevent;
        this.esports = esports;
        this.preu = preu;
        this.distancia = distancia;
        this.desnivellPositiu = desnivellPositiu;
        this.desnivellNegatiu = desnivellNegatiu;
        this.desnivellAcumulat = desnivellAcumulat;
        this.num_avituallaments = num_avituallaments;
        this.nom = nom;
        this.modalitat = modalitat;
        this.pagina_organitzacio = pagina_organitzacio;
        this.data_hora_inici = data_hora_inici;
        this.obertura_inscripcions = obertura_inscripcions;
        this.tancament_inscripcionts = tancament_inscripcionts;
        this.temps_limit = temps_limit;
        this.limit_inscrits = limit_inscrits;
        this.direccio = direccio;
        this.descripcio=descripcio;
        this.url=url;
    }

    protected Prova(Parcel in) {
        id = in.readString();
        url = in.readString();
        idevent = in.readString();
        esports = in.readString();
        preu = in.readString();
        descripcio = in.readString();
        distancia = in.readString();
        desnivellPositiu = in.readString();
        desnivellNegatiu = in.readString();
        desnivellAcumulat = in.readString();
        num_avituallaments = in.readString();
        nom = in.readString();
        modalitat = in.readString();
        pagina_organitzacio = in.readString();
        data_hora_inici = in.readString();
        obertura_inscripcions = in.readString();
        tancament_inscripcionts = in.readString();
        temps_limit = in.readString();
        limit_inscrits = in.readString();
        direccio = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(idevent);
        dest.writeString(esports);
        dest.writeString(preu);
        dest.writeString(descripcio);
        dest.writeString(distancia);
        dest.writeString(desnivellPositiu);
        dest.writeString(desnivellNegatiu);
        dest.writeString(desnivellAcumulat);
        dest.writeString(num_avituallaments);
        dest.writeString(nom);
        dest.writeString(modalitat);
        dest.writeString(pagina_organitzacio);
        dest.writeString(data_hora_inici);
        dest.writeString(obertura_inscripcions);
        dest.writeString(tancament_inscripcionts);
        dest.writeString(temps_limit);
        dest.writeString(limit_inscrits);
        dest.writeString(direccio);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Prova> CREATOR = new Parcelable.Creator<Prova>() {
        @Override
        public Prova createFromParcel(Parcel in) {
            return new Prova(in);
        }

        @Override
        public Prova[] newArray(int size) {
            return new Prova[size];
        }
    };
}
