/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.hibernateaccesodatos;

import java.util.Set;

/**
 *
 * @author miguel
 */
public class Equipo {
    
    private int id;
    private String nombre;
    private String ciudad;
    private String division;
    private String conferencia;
    
    private Entrenador entrenador;
    
    private Set<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(int id, String nombre, String ciudad, String division, String conferencia, Entrenador entrenador, Set<Jugador> jugadores) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.division = division;
        this.conferencia = conferencia;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    
    
    
    
    
}
