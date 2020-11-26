/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ejemplosobjectdb;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author miguel
 */
@Embeddable
public class Pais {
    private int id;
    private String nombrepais;

    public Pais() {
    }

    public Pais(int id, String nombrepais) {
        this.id = id;
        this.nombrepais = nombrepais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    @Override
    public String toString() {
        return nombrepais; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
