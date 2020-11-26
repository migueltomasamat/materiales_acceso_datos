/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.hibernateaccesodatos;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author miguel
 */
//@Entity
//@Table(name="lesion")
public class Lesion {
    
    //@Id
    //@Column(name="codigo_les")
    private int id;
    
    //@Column(name="nombre")
    private String nombre;
    
    //@Column(name="tiempo_rec")
    private int tiempo_rec;
    
    
    //@ManyToMany(mappedBy="lesiones")
    Set<Jugador> lesionados;

    public Lesion() {
    }

    public Lesion(int id, String nombre, int tiempo_rec, Set<Jugador> lesionados) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo_rec = tiempo_rec;
        this.lesionados = lesionados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo_rec() {
        return tiempo_rec;
    }

    public void setTiempo_rec(int tiempo_rec) {
        this.tiempo_rec = tiempo_rec;
    }

    public Set<Jugador> getLesionados() {
        return lesionados;
    }

    public void setLesionados(Set<Jugador> lesionados) {
        this.lesionados = lesionados;
    }
    
    
    
}
