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
public class InfoTabla {
    
    private String nombreTabla;
    private String tipoTabla;

    public InfoTabla() {
    }

    public InfoTabla(String nombreTabla, String tipoTabla) {
        this.nombreTabla = nombreTabla;
        this.tipoTabla = tipoTabla;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getTipoTabla() {
        return tipoTabla;
    }

    public void setTipoTabla(String tipoTabla) {
        this.tipoTabla = tipoTabla;
    }
    
    
    
}
