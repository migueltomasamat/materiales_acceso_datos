/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesAuxiliares;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class ListaPersonas {
    //Propiedades de la clase ListaPersonas
    private List <Persona> lista=new ArrayList<Persona>();;
    
    //Metodos de la clase ListaPersonas
    public ListaPersonas(){
    }
    
    public void add(Persona per){
        lista.add(per);
    }
    public List<Persona> getListaPersonas(){
        return lista;
    }
}
