/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ejemplosobjectdb;

import java.util.ArrayList;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author miguel
 */
@Entity
public class Jugadores {
    @Id @GeneratedValue
    private int cod_jugador;
    private String nombre;
    private String deporte;
    private String ciudad;
    private int edad;
    @Embedded
    private Pais pais;
    private ArrayList<String> idiomas;

    public Jugadores() {
        this.idiomas = new ArrayList<String>();
    }

    public Jugadores(String nombre, String deporte, String ciudad, int edad, Pais pais, ArrayList<String> idiomas) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.edad = edad;
        this.pais = pais;
        this.idiomas = idiomas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }
    

    @Override
    public String toString() {
        return nombre+", práctica "+deporte+" en "+ciudad+" y tiene "+edad+" años";
    }
    
    
}
