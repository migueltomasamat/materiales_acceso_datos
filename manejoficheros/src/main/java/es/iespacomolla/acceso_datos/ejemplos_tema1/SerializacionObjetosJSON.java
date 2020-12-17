/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.acceso_datos.ejemplos_tema1;

import clasesAuxiliares.ListaPersonas;
import clasesAuxiliares.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class SerializacionObjetosJSON {
    public static void main(String[] args){
        // TODO code application logic here
        
        int opcion=0;
        Scanner sc = new Scanner(System.in);
        Scanner sfichero = new Scanner (System.in);
        String nombreFichero = null;
        /*Declaramos una variable tipo File que instanciaremos más adelante cuando recivamos el
        el parametro bien como argumento de la aplicación, bien cuando se lo solicitamos al usuario.
        */
        File fichero = null;
        
        //Comprobamos si nos pasan el nombre del fichero como un argumento de la lista de comandos
        if( args.length!=0){//
           nombreFichero=args[0]; 
        }
        
        do{
            System.out.println("--------------------------------------");
            System.out.println("            Menú Principal");
            System.out.println("--------------------------------------");
            System.out.println("1. Deseas Escribir un fichero json");
            System.out.println("2. Deseas leer de un fichero json");
            System.out.println("0. Salir");
            System.out.println("Introduce la opción deseada: ");
            
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre del fichero a escribir:");
                        nombreFichero = sfichero.nextLine();      
                    }
                    /*Creamos una instancia de la clase File con el nombre obtenido y se la asignamos
                    a la variable fichero
                    */
                    
                    fichero = new File(nombreFichero);
                    EscrituraObjetoFicheroJSON(fichero);
                    break;
                }
                case 2: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre del fichero a leer:");
                        nombreFichero = sfichero.nextLine();
                         
                    }
                    /*Creamos una instancia de la clase File con el nombre obtenido y se la asignamos
                    a la variable fichero
                    */
                    fichero = new File(nombreFichero);
                    LecturaObjetoFicheroJSON(fichero);
                    break;
                }
                default:{
                    break;
                }
                        

            }
            
            
        }while (opcion!=0);
    }

    private static void EscrituraObjetoFicheroJSON(File fichero) {
        FileInputStream filein = null;
        try{
                filein = new FileInputStream(fichero);
                Persona persona1 = new Persona("Manuel Pérez", 18, 1.85);
                Persona persona2 = new Persona("Sonia Candela", 18, 1.76);
                Persona persona3 = new Persona("Raquel Correa", 18, 1.56);
                Persona persona4 = new Persona("Luis Gómez", 18, 1.98);
               
                
               
                
                ListaPersonas listaper = new ListaPersonas();
                listaper.add(persona1);
                listaper.add(persona2);
                listaper.add(persona3);
                listaper.add(persona4);
                /*Despues de la asignación de los datos a las instancias de la clase persona
                    del fichero pasamos a guardar los objetos en el fichero JSON
                */
                
                //Con la siguiente instrucción que utiliza la clase GsonBuider se puede establecer un formateado que mejora la legibilidad del fichero.
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                
                //Convertimos la instancia de la clase ListaPersonas al formato JSON que manejamos como si fuera un string.
                String json = gson.toJson(listaper);
              
                //Guardamos el objeto formateado a JSON en un fichero de texto.
                FileWriter fw = new FileWriter(fichero);
                
                fw.write(json);
                
                fw.close();
                
            }catch (FileNotFoundException fnfEx){
                System.err.println("Fichero no encontrado: "+fnfEx.getMessage());
            } catch (IOException binEx) {
                System.err.println("No se ha podido abrir el fichero binario: "+binEx.getMessage());
            } finally {
                try {
                    filein.close();
                } catch (IOException ioEx) {
                    System.err.println("No se puede cerrar el fichero: "+ioEx.getMessage());
                }
            }
            
        
    }

    private static void LecturaObjetoFicheroJSON(File fichero) {
            try {
                
                Gson gson = new Gson();

                /*Como hemos guardado un tipo ListaPersonas debemos crear una instancia auxliar de esta clase
                que guarde el valor retornado por el metodo fromJson, además indicarle a este método el tipo de la clase
                */
                ListaPersonas listadoTodas= gson.fromJson(new FileReader(fichero),ListaPersonas.class);
                
                //Mostramos por pantalla el número de personas que se habían guardado en el JSON
                System.out.println("Numero de Personas: "+ listadoTodas.getListaPersonas().size());
                
                /*Utilizamos una variable iterator para ir recorriendo el ArrayList
                y vamos cargando una variable persona de la que mostraremos sus atributos
                */
                Iterator iterador=listadoTodas.getListaPersonas().listIterator();
                while(iterador.hasNext()){
                    Persona p= (Persona) iterador.next();
                    System.out.println("Nombre: "+ p.getNombre()+" Edad: "+p.getEdad());
                }
                System.out.println("Fin de listado...");
            } catch (FileNotFoundException fnfEx) {
                System.err.println("Fichero no encontrado: "+ fnfEx.getMessage());
            }
}
}
