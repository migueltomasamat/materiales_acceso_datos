/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.acceso_datos.ejemplos_tema1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class Gestion_Ficheros_Directorios {
    public static void main(String[] args) {
        String opcion;
        Scanner sc = new Scanner(System.in);
        Scanner sfichero = new Scanner (System.in);
        String nombreFile = null;
        /*Declaramos una variable tipo File que instanciaremos más adelante cuando recivamos el
        el parametro bien como argumento de la aplicación, bien cuando se lo solicitamos al usuario.
        */
        File fichero;
        
        //Comprobamos si nos pasan el nombre del fichero como un argumento de la lista de comandos
        if( args.length!=0){//
           nombreFile=args[0]; 
        }
        
        do{
            System.out.println("--------------------------------------");
            System.out.println("            Menú Principal");
            System.out.println("--------------------------------------");
            System.out.println("1. Mostrar lista de ficheros de un directorio");
            System.out.println("2. Mostrar la información de un fichero");
            System.out.println("3. Crear un directorio");
            System.out.println("4. Crear un fichero");
            System.out.println("5. Renombrar un fichero");
            System.out.println("6. Borrar un fichero");
            System.out.println("0. Salir");
            System.out.println("Introduce la opción deseada: ");
            opcion = sc.nextLine();
            switch(Integer.parseInt(opcion)){
                case 1: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce la ruta del directorio:");
                        nombreFile = sfichero.nextLine();      
                    }
                    
                    VerFicherosDirectorio(nombreFile);
                    break;
                }
                case 2: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre del fichero a leer: ");
                        nombreFile = sfichero.nextLine();
                         
                    }
                    
                    MostrarInformacionFichero(nombreFile);
                    break;
                }
                case 3: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre del directorio que deseas crear: ");
                        nombreFile = sfichero.nextLine();
                         
                    }
                    CrearDirectorio(nombreFile);
                    break;
                }
                case 4: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre de fichero que deseas crear: ");
                        nombreFile = sfichero.nextLine();
                         
                    }
                    CrearFichero(nombreFile);
                    break;
                }
                case 5: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre de fichero que deseas renombrar: ");
                        nombreFile = sfichero.nextLine();
                         
                    }
                    RenombrarFichero(nombreFile);
                    break;
                }
                case 6: {
                    //Solicitamos el nombre del fichero si no lo hemos obtenido como parametro
                    if (args.length==0){
                        System.out.println("Introduce el nombre de fichero que deseas borrar: ");
                        nombreFile = sfichero.nextLine();
                         
                    }
                    BorrarFichero(nombreFile);
                    break;
                }
                default:{
                    break;
                }
                        

            }
            
            
        }while (Integer.parseInt(opcion)!=0);
        
    }

    private static void VerFicherosDirectorio(String nombreFile) {
        //Creamos la variable de file
        File fichero = new File(nombreFile);
        System.out.println("Ficheros en el directorio: "+fichero.getPath());
        
        //Creamos un array de String donde guardaremos el listado de ficheros del directorio
        String [] archivos = fichero.list();
        
        //Recorremos el array de String mostrando cada una de las ocurrencias del mismo.
        for (int i=0;i<archivos.length;i++){
            System.out.println(archivos[i]);
        }
    }

    private static void MostrarInformacionFichero(String nombreFile) {
        
        File fichero = new File(nombreFile);
        
        /* Comprobamos si el fichero existe y mostramos accediendo a las funciones de la clase
            File la información correspondiente de cada fichero
        */
        if (fichero.exists()){
                System.out.println("Nombre del fichero : "+ fichero.getName());
                System.out.println("Ruta : "+ fichero.getPath());
                System.out.println("Ruta Absoluta : "+ fichero.getAbsolutePath());
                System.out.println("Se puede escribir : "+ fichero.canRead());
                System.out.println("Se puede leer : "+ fichero.canWrite());
                System.out.println("Tamaño : "+ fichero.length());
                System.out.println("Es un directorio : "+ fichero.isDirectory());
                System.out.println("Es un fichero : "+ fichero.isFile());
           
        }
        else{
            System.out.println("El fichero: "+fichero.getName()+" no existe");
        }
    }

    private static void CrearDirectorio(String nombreFile) {
        File directorio = new File (nombreFile);
        if (directorio.mkdir()){
            System.out.println("El directorio ha sido creado correctamente");
        }
        else{
            System.out.println("No se ha podido crear el directorio");
        }
    }

    private static void CrearFichero(String nombreFile) {
        File fichero= new File(nombreFile);
        try {
            /* Creamos el fichero con el método createNewFile() de la clase File y 
                comprobamos si este se ha creado correctamente
            */
            if (fichero.createNewFile()){
                System.out.println("Fichero "+ nombreFile+" creado correctamente");
            }
            else{
                System.out.println("No se ha podido crear el fichero "+nombreFile);
            }
        } catch (IOException ex) {
            Logger.getLogger(Gestion_Ficheros_Directorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void RenombrarFichero(String nombreFile) {
        Scanner sc = new Scanner(System.in);
        File fichero = new File(nombreFile);
        String nuevoNombreFichero= null;
        
        //Preguntamos al usuario el nuevo nombre del fichero
        System.out.println("Introduce el nuevo nombre del fichero");
        nuevoNombreFichero= sc.nextLine();
        
        /*
            Renombramos el fichero con la función renameTo() que recibe como párametro una
            variable de tipo File, como no hemos creado una anteriormente la creamos cuando
            llamamos a la función.
        */
        fichero.renameTo(new File (nuevoNombreFichero));
    }

    private static void BorrarFichero(String nombreFile) {
        File fichero = new File (nombreFile);
        
        //Con el método delete() podemos borrar un fichero previamente guardado en el HD
        if (fichero.delete()){
            System.out.println("Fichero borrado con éxito");
        }
        else{
            System.out.println("El fichero no se ha borrado correctamente");
        }
    }
}
