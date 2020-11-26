/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.accesodatos;

import es.iespacomolla.ad.exceptions.DAOEntrenadorExcepcion;
import es.iespacomolla.ad.exceptions.DAOEquipoExcepcion;
import es.iespacomolla.ad.exceptions.DAOJugadorExcepcion;
import es.iespacomolla.ad.exceptions.DAOLesionExcepcion;
import es.iespacomolla.ad.hibernateaccesodatos.Entrenador;
import es.iespacomolla.ad.hibernateaccesodatos.Equipo;
import es.iespacomolla.ad.hibernateaccesodatos.Jugador;
import es.iespacomolla.ad.hibernateaccesodatos.Lesion;
import java.util.Set;

/**
 *
 * @author miguel
 */
public interface DAO {
    
    //Interfaz para el equipo
    
    int getIdInsertarEquipo();
    Equipo getEquipo(int id) throws DAOEquipoExcepcion;
    Set<Equipo> getEquiposCiudad(String nombreCiudad);
    Equipo getEquipoPorNombre(String nombreEquipo);
    Set<Equipo> getEquiposConferencia (String nombreConferencia);
    Set<Equipo> getEquiposDivision (String nombreDivision);
    Set<String> getConferencias();
    Set<String> getDivisionesEste();
    Set<String> getDivisionesOeste();
    
    
    void setEquipo (Equipo eq) throws DAOEquipoExcepcion;
    void deleteEquipo (Equipo eq) throws DAOEquipoExcepcion;
    void updateEquipo (Equipo eq) throws DAOEquipoExcepcion;
    
    Set<Jugador> getJugadoresEquipo(int idequipo);
    Entrenador getEntrenadorEquipo(int idequipo);
    Set<Lesion> getLesionesEquipo(int idequipo);
    
    
   //Interfaz de persistencia de Jugador
    Set<Jugador> getTodosLosJugadores();
    int getIdInsertarJugador();
    Jugador getJugador (int idjugador);
    Set<Jugador> getJugador(String nombrejugador);
    Set<Jugador> getJugadoresPosicion (int posicion);
    Equipo getEquipoJugador(int idjugador);
    Set<Lesion> getLesionesJugador (int idjugador);
    void setJugador(Jugador jug) throws DAOJugadorExcepcion;
    void modifyJugador(Jugador jug) throws DAOJugadorExcepcion;
    void deleteJugador(Jugador jug) throws DAOJugadorExcepcion;
    
    
    //Interfaz de persistencia de Entrenador
    int getIdInsertarEntrenador();
    Entrenador getEntrenador (int identrenador);
    Entrenador getEntrenadorPorNombre (String nombre);
    Set<Entrenador> getEntrenadores();
    Set<Entrenador> getEntrenadoresSinEquipo();
    void setEntrenador (Entrenador ent) throws DAOEntrenadorExcepcion;
    void modifyEntrenador (Entrenador ent) throws DAOEntrenadorExcepcion;
    void deleteEntrenador (Entrenador ent) throws DAOEntrenadorExcepcion;
    Equipo getEquipoEntrenador (int identrenador);
    Double getMediaEdadEntrenadores ();
    Set<Jugador> getJugadorMasGordo();
    
    //Interfaz de persistencia de Lesiones
    int getIdInsertarLesion (int idlesion);
    Set<Jugador> getJugadoresPorLesion(int idlesion);
    void setLesion (Lesion les) throws DAOLesionExcepcion;
    void modifyLesion (Lesion les) throws DAOLesionExcepcion;
    void deleteLesion (Lesion les) throws DAOLesionExcepcion;
    Double getMediaTiempoRecuperacionLesion();
    
    
}
