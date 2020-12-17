/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesAuxiliares;

/**
 *
 * @author miguel
 */
public class Persona {
    private String nombre;
    private int edad;
    private Double altura;

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
    
    public Persona (String nombre, int edad, Double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.altura=altura;
    }
    public Persona(){
        this.nombre=null;
    }
    public void setNombre(String nom){
        this.nombre=nom;
    }
    public void setEdad(int ed){
        this.edad=ed;
    }
    public String getNombre(){
            return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
}
