/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.exceptions;

/**
 *
 * @author miguel
 */
public class DAOJugadorExcepcion extends Exception{
    
    public DAOJugadorExcepcion(String mensaje){
        super("Se ha producido un error en la persistencia del jugador: "+ mensaje);
    }
    
}
