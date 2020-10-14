/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;
import com.mycompany.primeraaplicaciongrafica.modelo.*;
import com.mycompany.primeraaplicaciongrafica.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matomas
 */
public class controlador {
    
    private static modelo modelo = new modelo();
    private static vista vista = new vista();
    
    public static void main(String[] args) {
        vista.setVisible(true);
        Departamento dep = new Departamento();

        vista.getBotonAceptarDepartamento().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                
                if(vista.getOp()==Opcion.INSERCION){
                  try {
                    modelo.guardarDepartamento(vista.recuperarDatosDepartamento());
                  } catch (SQLException ex) {
                    vista.MostrarMensajeError("Inserción no realizada"+ex.getMessage());
                  }  
                }else if (vista.getOp()==Opcion.MODIFICACION){
                    try {
                        modelo.modificarDepartamento(vista.recuperarDatosDepartamento());
                    } catch (SQLException ex) {
                        vista.MostrarMensajeError("No se ha podido actualizar el departamento: "+ex.getMessage());
                    }
                }
                
            }
        });
        
        vista.getBotonCargarScriptEjecutarScript().addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                File fichero = vista.selecionarFichero();
                String ficheroString = leerFichero(fichero);
                
                modelo.ejecutarScript(fichero);
                
            }
        });
        
        
    }
    
    public void GestionarConexionBaseDatos(){
        try {
            modelo.ConectarBaseDatos();
        } catch (SQLException ex) {
           
        }
    }
    
    private static String leerFichero(File fichero){
        String ficheroleido=null;
        
        
        
        return ficheroleido;
    }
    
    
    
}
