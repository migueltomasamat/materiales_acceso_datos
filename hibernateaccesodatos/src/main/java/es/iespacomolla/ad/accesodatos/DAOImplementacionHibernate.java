/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.accesodatos;

import es.iespacomolla.ad.exceptions.DAOEquipoExcepcion;
import es.iespacomolla.ad.exceptions.DAOConexionExcepcion;
import es.iespacomolla.ad.exceptions.DAOEntrenadorExcepcion;
import es.iespacomolla.ad.exceptions.DAOJugadorExcepcion;
import es.iespacomolla.ad.exceptions.DAOLesionExcepcion;
import es.iespacomolla.ad.hibernateaccesodatos.Entrenador;
import es.iespacomolla.ad.hibernateaccesodatos.Equipo;
import es.iespacomolla.ad.hibernateaccesodatos.Jugador;
import es.iespacomolla.ad.hibernateaccesodatos.Lesion;
import java.util.Set;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author miguel
 */
public class DAOImplementacionHibernate implements DAO{

    private Session sesion;
    private SessionFactory factory;
            
    
    
    
    private void crearConexionHibernate() throws DAOConexionExcepcion{
        factory= new Configuration().configure().buildSessionFactory();
        sesion= factory.openSession();
        
        if (sesion==null){
            throw new DAOConexionExcepcion("No se ha conectado a Hibernate");
        }
    }
    
    private void cerraConexionHibernate() throws DAOConexionExcepcion{
        
        sesion.close();
        
        if (sesion!=null)
            throw new DAOConexionExcepcion("No se ha podido cerrar la conexión con Hibernate.");
        
    }
    
    @Override
    public int getIdInsertarEquipo() {
        return 4;
    }

    @Override
    public Equipo getEquipo(int id) throws DAOEquipoExcepcion{
        
        Equipo eq;
        try
        {
            eq= (Equipo) sesion.load(Equipo.class, id);
        }catch (ObjectNotFoundException e){
            throw new DAOEquipoExcepcion("Error al recuperar el equipo");
        }
        return eq;
    }

    @Override
    public Set<Equipo> getEquiposCiudad(String nombreCiudad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo getEquipoPorNombre(String nombreEquipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Equipo> getEquiposConferencia(String nombreConferencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Equipo> getEquiposDivision(String nombreDivision) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEquipo(Equipo eq) throws DAOEquipoExcepcion {
        Transaction tx = sesion.beginTransaction();
        
            sesion.save(eq);
        
        
        tx.commit();
    }

    @Override
    public void deleteEquipo(Equipo eq) throws DAOEquipoExcepcion {
        
        Transaction tx = sesion.beginTransaction();
        
            sesion.delete(eq);
        
        tx.commit();
        
        
    }

    @Override
    public void updateEquipo(Equipo eq) throws DAOEquipoExcepcion {
        
        Transaction tx = sesion.beginTransaction();
        
            sesion.update(eq);
            
        tx.commit();
    }

    @Override
    public Set<Jugador> getJugadoresEquipo(int idequipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrenador getEntrenadorEquipo(int idequipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Lesion> getLesionesEquipo(int idequipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int getIdInsertarJugador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jugador getJugador(int idjugador) {
        Jugador jug;
        
        jug= sesion.get(Jugador.class,idjugador);
        
        return jug;
    }

    @Override
    public Set<Jugador> getJugador(String nombrejugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Jugador> getJugadoresPosicion(int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo getEquipoJugador(int idjugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Lesion> getLesionesJugador(int idjugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJugador(Jugador jug) throws DAOJugadorExcepcion {
        Transaction tx = sesion.beginTransaction();
        
        sesion.save(jug);
        
        tx.commit();
    }

    @Override
    public void modifyJugador(Jugador jug) throws DAOJugadorExcepcion {
        
        sesion.beginTransaction();
        
        sesion.update(jug);
        
        
        sesion.getTransaction().commit();
        
    }

    @Override
    public void deleteJugador(Jugador jug) throws DAOJugadorExcepcion {
        
        sesion.beginTransaction();
        
        sesion.delete(jug);
        
        sesion.getTransaction().commit();
    }

    @Override
    public int getIdInsertarEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrenador getEntrenador(int identrenador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntrenador(Entrenador ent) throws DAOEntrenadorExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyEntrenador(Entrenador ent) throws DAOEntrenadorExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntrenador(Entrenador ent) throws DAOEntrenadorExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo getEquipoEntrenador(int identrenador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getMediaEdadEntrenadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdInsertarLesion(int idlesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Jugador> getJugadoresPorLesion(int idlesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLesion(Lesion les) throws DAOLesionExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyLesion(Lesion les) throws DAOLesionExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLesion(Lesion les) throws DAOLesionExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getMediaTiempoRecuperacionLesion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Jugador> getJugadorMasGordo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
