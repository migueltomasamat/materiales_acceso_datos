/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.hibernateaccesodatos;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author miguel
 */
class Jugador {
    
    private int id;
    private String nombre;
    private int posicion;
    private Double peso;
    private Date fecha_nac;
    
    private Equipo equipo;
    
    private Set<Lesion> lesiones;

    public Jugador() {
    }

    public Jugador(int id, String nombre, int posicion, Double peso, Date fecha_nac, Equipo equipo, Set<Lesion> lesiones) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.peso = peso;
        this.fecha_nac = fecha_nac;
        this.equipo = equipo;
        this.lesiones = lesiones;
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Set<Lesion> getLesiones() {
        return lesiones;
    }

    public void setLesiones(Set<Lesion> lesiones) {
        this.lesiones = lesiones;
    }
    
    
    
}
