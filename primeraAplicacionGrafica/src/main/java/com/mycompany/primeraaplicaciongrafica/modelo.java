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
    
    private ResultSet resultado;
    private Statement sentencia;
    private Connection conexion;

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
        
        conexion=DriverManager.getConnection("jdbc:h2:./Database/database.db","miguel","12345");
        sentencia=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return conexion;
    }
    
    public void DesconectarBaseDatos() throws SQLException{
        resultado.close();
        sentencia.close();
        conexion.close();
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
    
    public long ejecutarUpdateLargo (String script) throws SQLException{
        Statement sentencia = conexion.createStatement();
        return sentencia.executeLargeUpdate(script);
        
    }
    
    public int ejecutarUpdate(String script) throws SQLException{
        Statement sentencia = conexion.createStatement();
        return sentencia.executeUpdate(script);
        
    }
    
    public Departamento mostrarDatosDepartamento() throws SQLException{
        Departamento dep = new Departamento(resultado.getInt("dept_no"), resultado.getString(2), resultado.getString(3));
        return dep;
    }
    
    public void consultarTodosLosDepartamentos() throws SQLException{
        resultado=sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
        resultado.first();
    }
    
    public Departamento primerResultado() throws SQLException{
        resultado.first();
        return mostrarDatosDepartamento();
    }
    
    public Departamento anteriorResultado() throws SQLException{
        resultado.previous();
        return mostrarDatosDepartamento();
    }
    public Departamento siguienteResultado() throws SQLException{
        resultado.next();
        return mostrarDatosDepartamento();
    }
    public Departamento ultimoResultado() throws SQLException{
        resultado.last();
        return mostrarDatosDepartamento();
    }
    
    
    
}
