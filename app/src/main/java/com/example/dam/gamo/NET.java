package com.example.dam.gamo;

import android.app.Application;

/**
 * Created by dex on 5/26/16.
 */
public class NET extends Application {
    private String IP="http://10.0.2.2/GAMO_WEB-master";
    private Prova pr= new Prova();
    public Prova getPr(){return pr;}
    public void setPr(Prova pr){this.pr=pr;}
    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
