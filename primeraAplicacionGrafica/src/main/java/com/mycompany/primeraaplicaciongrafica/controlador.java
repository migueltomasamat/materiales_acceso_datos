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
import java.io.FileWriter;
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
                vista.areaTextoScripts.setText("");
                File fichero = vista.selecionarFichero();
                String ficheroString = leerFichero(fichero);
                vista.areaTextoScripts.setText(ficheroString);
            }
        });
        
        vista.botonEjecutarScripts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.ejecutarUpdate(vista.areaTextoScripts.getText());
                    try {
                        vista.ficheroSeleccionado.delete();
                        FileWriter fw = new FileWriter(vista.ficheroSeleccionado);
                        fw.write(vista.areaTextoScripts.getText());
                        
                        
                    } catch (IOException ex) {
                        vista.MostrarMensajeError("No se ha podido actualizar el fichero"+ex.getMessage());
                    }
                    
                    
                } catch (SQLException ex) {
                    vista.MostrarMensajeError("Se ha producido un error en la ejecución del Script"+ex.getMessage());
                }
                
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
        
        String linea = null;
        String salto = System.getProperty("line.separator");
        
        BufferedReader bfr= null;
        try {
            bfr = new BufferedReader(new FileReader(fichero));
        
            while ((linea=bfr.readLine())!=null){
                ficheroleido.append(linea);
                ficheroleido.append(salto);
            }
        } catch (FileNotFoundException ex2){
            vista.MostrarMensajeError("No se ha podido realizar la lectura del fichero"+ex2.getMessage());
        } catch (IOException ex) {
            vista.MostrarMensajeError("No se ha podido abrir el fichero de script"+ex.getMessage());
        
        }
        
        
        return ficheroleido.toString();
    }
    
    
    
}
