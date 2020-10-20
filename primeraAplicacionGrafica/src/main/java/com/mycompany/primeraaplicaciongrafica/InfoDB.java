/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;

/**
 *
 * @author miguel
 */
public class InfoDB {
    private String nombrebd;
    private String driverbd;
    private String urlbd;
    private String usuariobd;

    public InfoDB() {
    }

    public InfoDB(String nombrebd, String driverbd, String urlbd, String usuariobd) {
        this.nombrebd = nombrebd;
        this.driverbd = driverbd;
        this.urlbd = urlbd;
        this.usuariobd = usuariobd;
    }
    

    public String getNombrebd() {
        return nombrebd;
    }

    public void setNombrebd(String nombrebd) {
        this.nombrebd = nombrebd;
    }

    public String getDriverbd() {
        return driverbd;
    }

    public void setDriverbd(String driverbd) {
        this.driverbd = driverbd;
    }

    public String getUrlbd() {
        return urlbd;
    }

    public void setUrlbd(String urlbd) {
        this.urlbd = urlbd;
    }

    public String getUsuariobd() {
        return usuariobd;
    }

    public void setUsuariobd(String usuariobd) {
        this.usuariobd = usuariobd;
    }
    
    
    
}
