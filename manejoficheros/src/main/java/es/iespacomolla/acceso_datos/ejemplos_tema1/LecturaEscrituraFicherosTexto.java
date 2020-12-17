/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.acceso_datos.ejemplos_tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class LecturaEscrituraFicherosTexto {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // Declaración de las variables
        int opcion=0;
        Scanner sc = new Scanner(System.in);
        Scanner sfichero = new Scanner (System.in);
        String nombreFichero = null;
        /*Declaramos una variable tipo File que instanciaremos más adelante cuando recivamos el
        el parametro bien como argumento de la aplicación, bien cuando se lo solicitamos al usuario.
        */
        File fichero;
        
        //Comprobamos si nos pasan el nombre del fichero como un argumento de la lista de comandos
        if( args.length!=0){//
           nombreFichero=args[0]; 
        }
        
        do{
            System.out.println("--------------------------------------");
            System.out.println("            Menú Principal");
            System.out.println("--------------------------------------");
            System.out.println("1. Deseas Escribir un fichero de texto");
            System.out.println("2. Deseas leer de un fichero de texto");
            System.out.println("0. Salir");
            System.out.print("Introduce la opción deseada: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.print("Introduce el nombre del fichero a escribir:");
                        nombreFichero = sfichero.nextLine();      
                    }
                    /*Creamos una instancia de la clase File con el nombre obtenido y se la asignamos
                    a la variable fichero
                    */
                    
                    fichero = new File(nombreFichero);
                    EscrituraFicheroTexto(fichero);
                    break;
                }
                case 2: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.print("Introduce el nombre del fichero a leer:");
                        nombreFichero = sfichero.nextLine();
                         
                    }
                    /*Creamos una instancia de la clase File con el nombre obtenido y se la asignamos
                    a la variable fichero
                    */
                    fichero = new File(nombreFichero);
                    LecturaFicheroTexto(fichero);
                    break;
                }
                default:{
                    break;
                }
                        

            }
            
            
        }while (opcion!=0);
        
    }
    static void EscrituraFicheroTexto(File fichero){
        /*Creamos una instancia de la clase FileWriter que nos permitirá acceder a las funciones
        de escritura sobre el fichero. Asociamos este FileWriter con el fichero físico pasandole
        la variable de tipo File que hemos creado en la función main()
        */
        
        //El FileWriter o el FileReader se ha de declarar fuera para poder capturar la excepción con un try
        FileWriter fic = null;
        try {
            fic = new FileWriter(fichero);
        
        
        String cadena []= {"Albacete","Avila","Badajoz","Cáceres","Huelva","Jaén"};
            
        //Recorremos los elementos del array de Strings insertando cada uno además de un salto de línea
        for (int i=0;i<cadena.length;i++){
            fic.write(cadena[i]);
            fic.append('\n');
        }
        } catch (IOException ex) {
            System.err.println("Error de escritura: "+ex.getMessage());
        }finally{
            //Cerramos el fichero de texto
            try {
                fic.close();
            } catch (IOException ex) {
                System.err.println("El fichero no se ha podido cerrar correctamente: "+ ex.getMessage());
            } 
            
            
        }
        
        
    }
    static void LecturaFicheroTexto(File fichero){
            /*Creamos una instancia de la clase FileWriter que nos permitirá acceder a las funciones
            de escritura sobre el fichero. Asociamos este FileReader con el fichero físico pasandole
            la variable de tipo File que hemos creado en la función main()
            */            
                FileReader ficin = null;
            
            
            try{
                ficin= new FileReader(fichero);
            
            //Para la lectura vamos a utilizar un BufferReader que nos permitirá leer el fichero línea por línea
            BufferedReader fic = new BufferedReader(ficin);
            String linea;
            
            //Iremos leyendo líneas del fichero y asignandolas a la variable línea que mostraremos por pantalla
            //Cuando la lectura nos devuelva null habremos llegado al final del fichero
            while((linea=fic.readLine()) != null){
                System.out.println(linea);
            }
            
            } catch (IOException ex) {
                System.err.println("Fallo en la lectura del fichero: "+ ex.getMessage());
            } finally{
               //Cerramoos el FileWriter
                try{
                ficin.close(); 
                }catch (IOException err){
                    /*Controlamos que no se haya producido un error al cerrar el fichero*/
                    
                    System.err.println("Error. Cierre del fichero no realizado: "+err.getMessage());
                }
        }
    }
}
