/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author matomas
 */
public class modelo {
    
    protected ResultSet resultado;
    protected Statement sentencia;
    protected Connection conexion;
    
    private static final String CADENABD= "jdbc:h2:./Database/database.db";
    private static final String USUARIO = "miguel";
    private static final String PASSWORD = "12345";

    public modelo(ResultSet resultado, Statement sentencia, Connection conexion) {
        this.resultado = resultado;
        this.sentencia = sentencia;
        this.conexion = conexion;
    }

    public modelo() {
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public Statement getSentencia() {
        return sentencia;
    }

    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public Connection ConectarBaseDatos() throws SQLException{
        
        conexion=DriverManager.getConnection(CADENABD,USUARIO,PASSWORD);
        return conexion;
    }
    
    public int guardarDepartamento(Departamento dep) throws SQLException{
        int lineasModificadas=0;
        
        String sql = "INSERT INTO departamentos VALUES (?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setInt(1, dep.getId());
        sentencia.setString(2, dep.getNombre());
        sentencia.setString(3, dep.getLocalidad());
        
        lineasModificadas= sentencia.executeUpdate();
        
        return lineasModificadas;
        
        
    }

    public int modificarDepartamento(Departamento dep) throws SQLException {
        int lineasModificadas=0;
        
        String sql = "UPDATE departamentos SET dnombre = ?, loc = ? Where dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setInt(3, dep.getId());
        sentencia.setString(1, dep.getNombre());
        sentencia.setString(2, dep.getLocalidad());
        
        lineasModificadas= sentencia.executeUpdate();
        
        return lineasModificadas;
        
    
    }
    
    public int ejecutarScript (File fichero){
        return 1;
    }
    
    public int ejecutarScript (String rutaFichero){
        return ejecutarScript(new File(rutaFichero));
    }
    
    public long ejecutarUpdateScript (String script) throws SQLException{
        sentencia = conexion.createStatement();
        
        return sentencia.executeLargeUpdate(script);
        
    }
    
    
    
}
