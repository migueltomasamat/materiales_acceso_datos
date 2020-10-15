/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;
import com.mycompany.primeraaplicaciongrafica.modelo.*;
import com.mycompany.primeraaplicaciongrafica.vistabien.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matomas
 */
public class controlador {
    
    private static modelo modelo = new modelo();
    private static vistabien vista = new vistabien();
    
    public static void main(String[] args) {
        vista.setVisible(true);
        Departamento dep = new Departamento();

        vista.getBotonAceptarDepartamento().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                
                if(vista.op==Opcion.INSERCION){
                  try {
                    modelo.guardarDepartamento(vista.recuperarDatosDepartamento());
                  } catch (SQLException ex) {
                    vista.MostrarMensajeError("Inserción no realizada"+ex.getMessage());
                  }  
                }else if (vista.op==Opcion.MODIFICACION){
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
                vista.areaTextoScripts.setText(ficheroString);
                vista.botonEjecutarScripts.setEnabled(true);
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
        StringBuilder ficheroleido=new StringBuilder();
        
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fichero));
            String linea = null;
            String salto = System.getProperty("line.separator");
            
            while ((linea=bfr.readLine()) !=null){
                ficheroleido.append(linea);
                ficheroleido.append(salto);
            }
            
        } catch (FileNotFoundException ex) {
            vista.MostrarMensajeError("No se ha encontrado fichero para su lectura"+ex.getMessage());
        } catch (IOException ex) {
            vista.MostrarMensajeError("Error de lectura en el fichero: "+ex.getMessage());
        }
        
        
        
        return ficheroleido.toString();
    }
    
    
    
}
