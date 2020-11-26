/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.hibernateaccesodatos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author miguel
 */
public class NewMain {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Conexión mediante anotaciones
        /*
               SessionFactory factoria = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Entrenador.class)
                .addAnnotatedClass(Equipo.class)
                .addAnnotatedClass(Jugador.class)
                .addAnnotatedClass(Lesion.class)
                .buildSessionFactory();
        */
        
        //Conexión con ficheros de configuración en XML
        /*SessionFactory factoria = new Configuration().configure().buildSessionFactory();
        
        Session sesion = factoria.openSession();
        
        if(sesion!=null)
            System.out.println("Se ha conectado");
        else
            System.out.println("No se ha conectado");*/
        

        
        
        
        
    }
    
}
