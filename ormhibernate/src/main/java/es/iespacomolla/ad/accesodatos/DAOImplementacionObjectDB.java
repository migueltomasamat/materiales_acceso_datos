/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.accesodatos;

import es.iespacomolla.ad.exceptions.DAOConexionExcepcion;
import es.iespacomolla.ad.exceptions.DAOEntrenadorExcepcion;
import es.iespacomolla.ad.exceptions.DAOEquipoExcepcion;
import es.iespacomolla.ad.exceptions.DAOJugadorExcepcion;
import es.iespacomolla.ad.exceptions.DAOLesionExcepcion;
import es.iespacomolla.ad.hibernateaccesodatos.Entrenador;
import es.iespacomolla.ad.hibernateaccesodatos.Equipo;
import es.iespacomolla.ad.hibernateaccesodatos.Jugador;
import es.iespacomolla.ad.hibernateaccesodatos.Lesion;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author miguel
 */
public class DAOImplementacionObjectDB implements DAO{
    
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAOImplementacionObjectDB() {
        try {
            crearConexionObjectDB();
        } catch (DAOConexionExcepcion ex) {
            System.err.println("No se ha podido conectar a la base de datos ObjectDB");
        }
        
    }
    
    
    
    
    private void crearConexionObjectDB() throws DAOConexionExcepcion{
        
        emf= Persistence.createEntityManagerFactory("objectdb:db/nba.odb");
        em= emf.createEntityManager();
        
        if (em==null){
            throw new DAOConexionExcepcion("No se ha conectado a Hibernate");
        }
    }
    
    public void cerraConexionHibernate() throws DAOConexionExcepcion{
        
        em.close();
        emf.close();
        
        if (em!=null)
            throw new DAOConexionExcepcion("No se ha podido cerrar la conexión con Hibernate.");
        
    }

    @Override
    public int getIdInsertarEquipo() {
        TypedQuery<Integer> q = em.createQuery("SELECT max(e.id) from Equipo e",Integer.class);
        
        return q.getSingleResult()+1;
        
    }

    @Override
    public Equipo getEquipo(int id) throws DAOEquipoExcepcion {
        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM Equipo e WHERE id=:parametroidequipo", Equipo.class);
        
        query.setParameter("parametroidequipo", id);
        
        return query.getSingleResult();
    }

    @Override
    public Set<Equipo> getEquiposCiudad(String nombreCiudad) {
        TypedQuery<Equipo> query  = em.createQuery("SELECT e FROM Equipo e WHERE ciudad=:parametroCiudad",Equipo.class);
        query.setParameter("parametroCiudad", nombreCiudad);
        return new HashSet<Equipo>(query.getResultList());
    }

    @Override
    public Equipo getEquipoPorNombre(String nombreEquipo) {
        TypedQuery<Equipo> query  = em.createQuery("SELECT e FROM Equipo e WHERE nombre=:parametroNombre",Equipo.class);
        query.setParameter("parametroNombre", nombreEquipo);
        return query.getSingleResult();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEquipo(Equipo eq) throws DAOEquipoExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEquipo(Equipo eq) throws DAOEquipoExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyJugador(Jugador jug) throws DAOJugadorExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteJugador(Jugador jug) throws DAOJugadorExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Set<Jugador> getJugadorMasGordo() {
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
    public Set<String> getConferencias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getDivisionesEste() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getDivisionesOeste() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Jugador> getTodosLosJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entrenador> getEntrenadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrenador getEntrenadorPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entrenador> getEntrenadoresSinEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
