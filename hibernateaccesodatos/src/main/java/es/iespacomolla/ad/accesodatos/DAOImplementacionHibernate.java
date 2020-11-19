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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
        
        Query q = sesion.createQuery("select max(e.id) from Equipo e");
        
        int identificador  = (int) q.uniqueResult();
        
        return identificador+1;
        
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
        Query q = sesion.createQuery("from Equipo where ciudad = :nomCiudad");
        
        q.setParameter("nomCiudad", nombreCiudad);
        
        List<Equipo> listadoEquipos = q.list();
        
        return new HashSet<Equipo>(listadoEquipos);
    }

    @Override
    public Equipo getEquipoPorNombre(String nombreEquipo) {
        Query q = sesion.createQuery("from Equipo eq where eq.nombre = :nombreDelEquipo ");
        
        q.setParameter("nombreDelEquipo", nombreEquipo);
        
        return (Equipo) q.uniqueResult();
    }

    @Override
    public Set<Equipo> getEquiposConferencia(String nombreConferencia) {
        Query q = sesion.createQuery("from Equipo eq where conferencia = :parametroConferencia");
        
        q.setParameter("parametroConferencia", nombreConferencia);
        
        List<Equipo> listaEquipos = q.list();
        
        return new HashSet<Equipo>(listaEquipos);
    }

    @Override
    public Set<Equipo> getEquiposDivision(String nombreDivision) {
        Query q = sesion.createQuery("from Equipo eq where division = :parametroDivision");
        
        q.setParameter("parametroDivision", nombreDivision);
        
        List<Equipo> listaEquipos = q.list();
        
        return new HashSet<Equipo>(listaEquipos);
        
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
        
        Equipo eq = sesion.get(Equipo.class, idequipo);
        
        return eq.getJugadores();
        
    }

    @Override
    public Entrenador getEntrenadorEquipo(int idequipo) {
        
        Equipo eq = sesion.get(Equipo.class,  idequipo);
        
        return eq.getEntrenador();
    }

    @Override
    public Set<Lesion> getLesionesEquipo(int idequipo) {
        Query q = sesion.createQuery("from Lesion l join Jugador j where j.equipo.id = :parametroIdEquipo");
        
        q.setParameter("parametroIdEquipo", idequipo);
        
        List<Lesion> lesiones = q.list();
        
        
        return new HashSet<Lesion>(lesiones);
    }


    @Override
    public int getIdInsertarJugador() {
        Query q = sesion.createQuery("select max(e.id) from Equipo e");
        
        int maxId = (int) q.uniqueResult();
        
        return maxId+1;
        
        
    }

    @Override
    public Jugador getJugador(int idjugador) {
        Jugador jug;
        
        jug= sesion.get(Jugador.class,idjugador);
        
        return jug;
    }

    @Override
    public Set<Jugador> getJugador(String nombrejugador) {
        
        Query q = sesion.createQuery("from Jugador j where j.nombre = :parametroNombreJugador");
        
        q.setParameter("parametroNombreJugador", nombrejugador);
        List<Jugador> jugadores = q.list();
        
        return new HashSet<Jugador>(jugadores);
                
    }

    @Override
    public Set<Jugador> getJugadoresPosicion(int posicion) {
        Query q = sesion.createQuery("from Jugador j where j.posicion = :paramatroPosicionJugador");
        
        q.setParameter("paramatroPosicionJugador", posicion);
        
        List<Jugador> jugadores = q.list();
        
        return new HashSet<Jugador>(jugadores);
        
        
    }

    @Override
    public Equipo getEquipoJugador(int idjugador) {
        
        Jugador jug = sesion.get(Jugador.class, idjugador);
        
        return jug.getEquipo();
        
    }

    @Override
    public Set<Lesion> getLesionesJugador(int idjugador) {
        
        return sesion.get(Jugador.class, idjugador).getLesiones();
        
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
        Query q = sesion.createQuery("from Entrenador");
        
        List<Entrenador> entrenadores = q.list();
        
        int id=0;
        boolean encontrado = false;
        Iterator iterador = entrenadores.iterator();
        
        while (!encontrado && iterador.hasNext()){
            Entrenador e = (Entrenador) iterador.next();
            if (id!=e.getId()-1){
                encontrado =true;
                id = e.getId()-1;
            }
        }
        
        return id;
        
        
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
        Query q = sesion.createQuery("from Entrenador where id = :identificadorEntrenador");
        
        q.setParameter("identificadorEntrenador", identrenador);
        
        Entrenador ent = (Entrenador) q.uniqueResult();
        
        return ent.getEquipo();
    }

    @Override
    public Double getMediaEdadEntrenadores() {
        
        
        Query q = sesion.createQuery("select avg(ent.edad) from Entrenador ent");
        
        Double mediaEdad = (Double) q.uniqueResult();
        
        return mediaEdad;
        
        
    }

    @Override
    public int getIdInsertarLesion(int idlesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Jugador> getJugadoresPorLesion(int idlesion) {
        
        Query q = sesion.createQuery("from Lesion l where id = : identificadorLesion");
        
        q.setParameter("identificadorLesion", idlesion);
        
        Lesion les = (Lesion) q.uniqueResult();
        
        return les.getLesionados();
    }

    @Override
    public void setLesion(Lesion les) throws DAOLesionExcepcion {
        Transaction tx = sesion.beginTransaction();
        
        sesion.save(les);
        
        tx.commit();
    }

    @Override
    public void modifyLesion(Lesion les) throws DAOLesionExcepcion {
        Transaction tx = sesion.beginTransaction();
        
        sesion.update(les);
        
        tx.commit();
    }

    @Override
    public void deleteLesion(Lesion les) throws DAOLesionExcepcion {
        Transaction tx = sesion.beginTransaction();
        
        sesion.delete(les);
        
        tx.commit();
    }

    @Override
    public Double getMediaTiempoRecuperacionLesion() {
         
        Query q = sesion.createQuery("select avg(les.tiempo_rec from Lesion les");
        
        Double mediaRecuperacion = (Double) q.uniqueResult();
        
        return mediaRecuperacion;
         
    }

    @Override
    public Set<Jugador> getJugadorMasGordo() {
        Query q = sesion.createQuery("from Jugador jug group by jug.id having max(peso)= (select max(j.peso) from Jugador)");
        
        List<Jugador> jugadoresMasPesados = q.list();
        
        return new HashSet<Jugador>(jugadoresMasPesados);
    }
    
}
