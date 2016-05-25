package com.example.dam.gamo;

/**
 * Created by cabre_000 on 22/5/2016.
 */
public class Prova {
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
}
