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
public class RetornoProcedimientos {
    private int dep;
    private int subida_sal;
    private String nombre_dep;
    private String localizacion;

    public RetornoProcedimientos(int dep, int subida_sal, String nombre_dep, String localizacion) {
        this.dep = dep;
        this.subida_sal = subida_sal;
        this.nombre_dep = nombre_dep;
        this.localizacion = localizacion;
    }

    public RetornoProcedimientos() {
    }

    public RetornoProcedimientos(int dep, int subida_sal) {
        this.dep = dep;
        this.subida_sal = subida_sal;
    }

    public RetornoProcedimientos(int dep) {
        this.dep = dep;
    }

    public RetornoProcedimientos(String nombre_dep, String localizacion) {
        this.nombre_dep = nombre_dep;
        this.localizacion = localizacion;
    }

    public RetornoProcedimientos(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public int getSubida_sal() {
        return subida_sal;
    }

    public void setSubida_sal(int subida_sal) {
        this.subida_sal = subida_sal;
    }

    public String getNombre_dep() {
        return nombre_dep;
    }

    public void setNombre_dep(String nombre_dep) {
        this.nombre_dep = nombre_dep;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
    
    
    
    
    
    
    
    
    
    
}
