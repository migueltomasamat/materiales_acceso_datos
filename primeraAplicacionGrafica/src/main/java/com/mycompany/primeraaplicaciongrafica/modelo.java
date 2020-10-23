/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import org.mariadb.jdbc.CallableProcedureStatement;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbProcedureStatement;
import org.mariadb.jdbc.internal.com.read.resultset.SelectResultSet;
import org.mariadb.jdbc.internal.util.exceptions.ExceptionFactory;

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
        
        conexion=DriverManager.getConnection("jdbc:mysql://192.168.2.102/ad","miguel","leugim");
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
    public int borrarDepartamento (Departamento dep) throws SQLException{
        String sql ="DELETE FROM departamentos WHERE dept_no=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setInt(1, dep.getId());
        
        return sentencia.executeUpdate();
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
        resultado=sentencia.executeQuery("SELECT * FROM departamentos");
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
    
    public InfoDB getInformacionBD() throws SQLException{
        
        DatabaseMetaData dbmd = conexion.getMetaData();
        
        InfoDB informacion= new InfoDB();
        informacion.setNombrebd(dbmd.getDatabaseProductName());
        informacion.setDriverbd(dbmd.getDriverName());
        informacion.setUrlbd(dbmd.getURL());
        informacion.setUsuariobd(dbmd.getUserName());
        
        return informacion;
        
    }
    public ArrayList<InfoTabla> getInformacionTablas() throws SQLException{
        DatabaseMetaData dbmd = conexion.getMetaData();
        
        ArrayList<InfoTabla> informacion = new ArrayList<>();
                
        
        ResultSet rs = dbmd.getTables("ad", null, "%", null);
        
        while(rs.next()){
            informacion.add(new InfoTabla(rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE")));
        }
        
        
        return informacion;
    }
    
    public ArrayList<String> getProcedimientos() throws SQLException{
        ArrayList<String> listaProcedimientos = new ArrayList<>();
        
        DatabaseMetaData dbmd = conexion.getMetaData();
        
        ResultSet rs = dbmd.getProcedures(null, "ad", "%");
        
        while(rs.next()){
            
            listaProcedimientos.add(rs.getString("PROCEDURE_NAME"));
        }
        
        return listaProcedimientos;
    }
    
    public int ejecutarProcedimientoSubidaSal (int num_dep, int subida ) throws SQLException{
        
        
        String sql = "{ call subida_sal (?,?)}"; 
        
        MariaDbProcedureStatement procedimiento = new MariaDbProcedureStatement(sql,(MariaDbConnection) conexion, "subida_sal", "ad", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ExceptionFactory.INSTANCE);
        
        procedimiento.setInt(1, num_dep);
        procedimiento.setInt(2, subida);
        int salida = procedimiento.executeUpdate();
        
        if (salida == 0){
            return 1;
        }else{
            return 0;
        }
        
    }
    public String ejecutarProcedimientoNombreDep (int num_dep) throws SQLException{
        
        String sql = "{ ? call nombre_dep (?)}"; 
        
        MariaDbProcedureStatement procedimiento = new MariaDbProcedureStatement(sql,(MariaDbConnection) conexion, "nombre_dep", "ad", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ExceptionFactory.INSTANCE);
        
        procedimiento.setInt(2, num_dep);
        procedimiento.registerOutParameter(1, Types.VARCHAR);
        
        procedimiento.execute();
        
        String nombre_dep = procedimiento.getString(1);
        
        return null;

    }
    
    public ArrayList<String> ejecutareProcedimientoDatosDep (int num_dep) throws SQLException{
        String sql = "{ call datos_dep (?,?,?)}"; 
        
        MariaDbProcedureStatement procedimiento = new MariaDbProcedureStatement(sql,(MariaDbConnection) conexion, "datos_dep", "ad", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ExceptionFactory.INSTANCE);
        
        procedimiento.setInt(1, num_dep);
        procedimiento.registerOutParameter(2, Types.VARCHAR);
        procedimiento.registerOutParameter(3, Types.VARCHAR);
        
        procedimiento.execute();
        
        ArrayList<String> devolucion = new ArrayList<>();
        
        devolucion.add(procedimiento.getString("nom"));
        devolucion.add(procedimiento.getString("locali"));
        
        return devolucion;
    }
    
    
}
