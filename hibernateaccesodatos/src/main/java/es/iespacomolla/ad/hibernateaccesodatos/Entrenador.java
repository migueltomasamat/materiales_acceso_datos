/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.hibernateaccesodatos;

/**
 *
 * @author miguel
 */
public class Entrenador {
    
    
    private int id;
    private String nombre;
    private int edad;
    
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(int id, String nombre, int edad, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    
    
    
}
