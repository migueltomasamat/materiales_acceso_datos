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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
public class controlador implements ActionListener,WindowListener {
    
    private static modelo modelo = new modelo();
    private static vistabien vista = new vistabien();

    public controlador() {
        try {
            modelo.ConectarBaseDatos();
        } catch (SQLException ex) {
            vista.MostrarMensajeError("No se ha podido conectar a la base de datos"+ex.getMessage());
        }
        vista.addWindowListener(this);
        vista.setVisible(true);
        vista.botonAceptarDepartamentos.addActionListener(this);
        vista.botonCargarScriptEjecutarScript.addActionListener(this);
        vista.botonEjecutarScripts.addActionListener(this);
        vista.botonTodoAtrasDepartamentos.addActionListener(this);
        vista.botonTodoAdelanteDepartamentos.addActionListener(this);
        vista.botonAdelanteDepartamentos.addActionListener(this);
        vista.botonAtrasDepartamentos.addActionListener(this);
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.botonAceptarDepartamentos){
            if(vista.op==Opcion.INSERCION){
                  try {
                    modelo.guardarDepartamento(vista.recuperarDatosDepartamento());
                    modelo.consultarTodosLosDepartamentos();
                  } catch (SQLException ex) {
                    vista.MostrarMensajeError("Inserción no realizada"+ex.getMessage());
                  }  
                }else if (vista.op==Opcion.MODIFICACION){
                    try {
                        modelo.modificarDepartamento(vista.recuperarDatosDepartamento());
                        modelo.consultarTodosLosDepartamentos();
                    } catch (SQLException ex) {
                        vista.MostrarMensajeError("No se ha podido actualizar el departamento: "+ex.getMessage());
                    }
                }
        }else if (e.getSource()==vista.botonEjecutarScripts){
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
        }else if (e.getSource()==vista.botonCargarScriptEjecutarScript){
            vista.areaTextoScripts.setText("");
            File fichero = vista.selecionarFichero();
            String ficheroString = leerFichero(fichero);
            vista.areaTextoScripts.setText(ficheroString);
        }else if (e.getSource()==vista.botonTodoAtrasDepartamentos){
            try {
                vista.cargarDatosDepartamento(modelo.primerResultado());
            } catch (SQLException ex) {
                vista.MostrarMensajeError("No se ha podido cargar el primer departamento"+ex.getMessage());
            }
        }else if (e.getSource()==vista.botonAtrasDepartamentos){
            try {
                vista.cargarDatosDepartamento(modelo.anteriorResultado());
            } catch (SQLException ex) {
                vista.MostrarMensajeError("No se ha podido cargar el departamento anterior"+ex.getMessage());
            }
        }else if (e.getSource()==vista.botonAdelanteDepartamentos){
            try {
                vista.cargarDatosDepartamento(modelo.siguienteResultado());
            } catch (SQLException ex) {
                vista.MostrarMensajeError("No se ha podido cargar el departamento siguiente"+ex.getMessage());
            }
        }else if (e.getSource()==vista.botonTodoAdelanteDepartamentos){
            try {
                vista.cargarDatosDepartamento(modelo.ultimoResultado());
            } catch (SQLException ex) {
                vista.MostrarMensajeError("No se ha podido cargar el último departamento"+ex.getMessage());
            }
 }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Se ha abierto la ventana");
        try {
            modelo.consultarTodosLosDepartamentos();
            vista.cargarDatosDepartamento(modelo.mostrarDatosDepartamento());
        } catch (SQLException ex) {
            vista.MostrarMensajeError("No se ha podido cargar el departamento"+ex.getMessage());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            modelo.DesconectarBaseDatos();
        } catch (SQLException ex) {
            vista.MostrarMensajeError("Desconexión incorrecta"+ex.getMessage());
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    
    
}
