/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.hibernateaccesodatos;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author miguel
 */

@Entity
@Table(name="jugador")
class Jugador {
    
    @Id
    @Column(name="codigo_jug")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="posicion")
    private int posicion;
    
    @Column(name="peso")
    private Double peso;
    
    @Column(name="fecha_nac")
    private Date fecha_nac;
    
    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="codigo_eq_jug")
    private Equipo equipo;
    
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="jugador_lesion",
            joinColumns={@JoinColumn(name="codigo_jug_jl")},
            inverseJoinColumns={@JoinColumn(name="codigo_les_jl")}
            )
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
