/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.ejemplosmongodb;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author miguel
 */
public class EjemplosMongo {
    public static void main(String[] args) {
        int opcion=0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("--------------------------------------");
            System.out.println("            Menú Principal");
            System.out.println("--------------------------------------");
            System.out.println("1. Visualizar los datos de una colección");
            System.out.println("2. Insertar Documentos en una colección");
            System.out.println("3. Insertar varios Documentos en una colección");
            System.out.println("4. Consultar Documentos en una colección");
            System.out.println("5. Utilizar filtros en las consultas");
            System.out.println("6. Utilizar proyecciones");
            System.out.println("7. Utilizar agregaciones");
            System.out.println("8. Actualizar Documentos");
            System.out.println("9. Borrar un documento de una colección");
            System.out.println("10. Crear y Borrar una colección");
            System.out.println("11. Listar colecciones de la base de datos");
            System.out.println("12. Crear, Listar y Borrar Bases de Datos");
            System.out.println("13. Escribir a ficheros JSON");
            System.out.println("14. Leer de ficheros JSON");

            




            System.out.println("0. Salir");
            System.out.print("Introduce la opción deseada: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1: {
                    visualizarDatosColeccion();
                    break;
                }
                case 2: {
                    insertarDatosColeccion();
                    break;
                }
                case 3: {
                    insertarVariosDocumentosColeccion();
                    break;
                }
                case 4: {
                    consultarDocumentosColeccion();
                    break;
                }
                case 5: {
                    utilizarFiltrosConsultas();
                    break;
                }
                case 6: {
                    utilizarProyecciones();
                    break;
                }
                case 7: {
                    utilizarAgregaciones();
                    break;
                }
                case 8: {
                    actualizarDocumentos();
                    break;
                }
                case 9: {
                    borrarDocumentos();
                    break;
                }
                case 10: {
                    crearBorrarColecciones();
                    break;
                }
                case 11: {
                    listarColecciones();
                    break;
                }
                case 12: {
                    crearListarBorrarBD();
                    break;
                }
                case 13: {
                    escribirFicherosJSON();
                    break;
                }
                case 14: {
                    LeerFicherosJSON();
                    break;
                }
                default:{
                    
                    break;
                }
                        

            }
            
            
        }while (opcion!=0);
        System.exit(0);
    }

    private static void visualizarDatosColeccion() {
        /* 
        Para conectar a una base de datos MongoDB desde java utilizamos una instancia de la clase
        MongoClient que por defecto crea una conexión a un servidor local por el puerto 27017 que es por 
        defecto el puerto en el que eschucha el servidor mongod
        */
        
        /*
            Si se ha modificado el puerto del servidor podriamos conectar
            con MongoClient cliente = new MongoClient("localhost",27017);

        */
        MongoClient cliente= new MongoClient();
        
        //Seleccionamos la base de datos con la que vamos a trabajar
        MongoDatabase db= cliente.getDatabase("mibasedatos");
        
        /*
            Seleccionamos la colección y la asignamos a una instancia genérica de la clase MongoCollection<Document>
            que es lo que devuelve el método getCollection()
        */
        MongoCollection <Document> coleccion = db.getCollection("amigos");
        
        /*
            Con esta consulta obtenemos todos los documentos en un ArrayLOist que podemos recorrer para ver los documentos
        */
        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
        
        //Podemos recorrer la lista e ir mostrando los objetos genericos que devuelve el método get()
        for(int i=0;i<consulta.size();i++){
            System.out.println(" - "+ consulta.get(i).toString());
        }
        
        //También podemos acceder a las proiedades de cada documento
        
        for(int i=0;i<consulta.size();i++){
            Document amigo = consulta.get(i);
            System.out.println("Nombre: "+amigo.getString("nombre")+" Telefono: "+amigo.get("teléfono")+
                    " Curso: "+amigo.getString("curso")+" Nota: "+amigo.getDouble("nota"));
        }
        
    }

    private static void insertarDatosColeccion() {
        /*
            Creamos la conexión a la base de datos, seleccionamos la base de datos "mibasededatos" y creamos
            una instancia de MongoCollection llamada coleccion donde guardaremos la colección amigos
        */
        MongoClient cliente = new MongoClient();
        MongoDatabase db= cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion= db.getCollection("amigos");
        
        //Creamos un elemento Document en el que guardaremos las propiedades del objeto amigos
        Document amigo = new Document();
        
        //Vamos con el metodo put() asignando para cada propiedad el valor que deseamos introducir
        amigo.put("nombre", "Pepito");
        amigo.put("teléfono", 925677);
        amigo.put("curso", "2DAM");
        amigo.put("fecha", new java.util.Date());
        
        /*
            Por útlimo utilizamos la instancia coleccion creada anteriomente para con el método insertOne(),
            añadir el Document amigo a la colección.
        */
           
        coleccion.insertOne(amigo);
        
        
        //También podemos utilizar el método append para insertar los datos desde el constructor
        Document amigo2 = new Document("nombre","Pedro").append("teléfono", 1234)
                .append("curso", new Document("curso1","1DAM").append("curso2", "2DAM"));
        //Cuando tengamos que recuperar el curso con el método get() en lugar del méotodo getString()
        
        //Y se almacena también en la BD
        coleccion.insertOne(amigo2);
        
    }

    private static void insertarVariosDocumentosColeccion() {
        //Creamos la conexión a la base de datos
        MongoClient cliente= new MongoClient();
        MongoDatabase db= cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion = db.getCollection("amigos");
        
        //Podemos agilizar la inserción mediante una lista e insertarla toda con una sola instrucción
        List<Document> listadocs = new ArrayList<Document>();
        for(int i=0;i<100;i++){
            listadocs.add(new Document("Valor de i",i));
        }
        
        //Con el método insertMany al que asignamos la lista, se introducen en la BD todo los elementos Document de la lista
        coleccion.insertMany(listadocs);
        
        //También podemos conocer el número de documentos que tiene la lista medionate el método count()
        System.out.println("La lista tiene "+coleccion.countDocuments()+" documentos");
    }

    private static void consultarDocumentosColeccion() {
        //Creamos la conexión a la base de datos
        MongoClient cliente= new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion = db.getCollection("amigos");
        
        /*
            El método find() devuelve una intancia de la clase FindIterable cuyos resultados podemos recorrer
            si utilizamos el método iterator() que nos devuelve el iterador que nos permite recorrer los resultados.
            Es similar a la clase ResultSet que utilizabamos para acceder a las bases de datos SQL.
        
            En este caso como no realizamos ningún filtrado de los resultados obtenemos todos los documentos de la colección
        */
        MongoCursor<Document> cursor = coleccion.find().iterator();
        
        //Recorremos todos los resultados mostrando el resultado en formato JSON
        while (cursor.hasNext()){
            Document doc = cursor.next();
            System.out.println(doc.toJson());
        }
        
        //Por útlimo cerramos el cursor
        cursor.close();
    }

    private static void utilizarFiltrosConsultas() {
        //Creamos la conexión a la base de datos
        MongoClient cliente= new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion = db.getCollection("amigos");
        
        /*
            Utilizamos los filtros para cribar los resultados, podemos importar la libreria 
            com.mongodb.client.model.Filters.* para poder tenerlos todos accesibles de una tacada
        */
        //En el siguiente ejemplo tenemos aquellos registros cuyo nombre coincide con Pepita
        
        Document doc = (Document) coleccion.find(eq("nombre","Pepita")).first();
        System.out.println("---------Registos con el nombre Pepita-----------------");
        try{
            System.out.println("Localizado: "+doc.toJson());
        }catch (NullPointerException ne){
            System.out.println("No se encuentra");
        }
        System.out.println();
        
        //Si tenemos una consulta que devuelve multiples elementos los recuperaremos con un cursor
        //En el siguente ejemplo la consulta devuelve aquellos registros cuya nota es mayor que 5
        System.out.println("---------Registros con la nota mayor que 5--------------");
        MongoCursor<Document> docs= coleccion.find(gt("nota",5)).iterator();
        while (docs.hasNext()){
            Document docu=docs.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        //Si queremos filtrar por multiples condiciones podemos utilizar las funciones and() y or()
        //La siguente consulta devuelve aquellos registros cuya nota es 5 o 8
        System.out.println("---------Registros con nota 6 o 8--------------");
       docs=coleccion.find(or(eq("nota",6),eq("nota",8))).iterator();
       while(docs.hasNext()){
           Document docu=docs.next();
           System.out.println(docu.toJson());
       }
       System.out.println();
       
       //La siguiente consulta devuelve aquellos registros cuyo curso es 1DAM y su nota es 8
       System.out.println("---------Registros con el curso 1DAM y nota igual a 10 ------------");
       docs=coleccion.find(and(eq("curso","1DAM"),eq("nota",10))).iterator();
       while(docs.hasNext()){
           Document docu= docs.next();
           System.out.println(docu.toJson());
                   
       }
       System.out.println();
       
       /*
            Podemos acceder mediante filtros a los objetos BSON que contienen los registros
       */
        System.out.println("---------Acceso a los objetos BSON-----------------");
        //Seleccionamos todos los elementos de la colección
        docs=coleccion.find().iterator();
        while(docs.hasNext()){
            Document docu = docs.next();
            
            //Vamos obteniendo los objetos BSON que tenemos dentro del documento
            Bson id=eq("_id",docu.get("_id"));
            Bson nombre= eq("nombre",docu.get("nombre"));
            Bson curso = eq("curso",docu.get("curso"));
            
            //Al final mostramos los resultados por pantalla
            System.out.println("Id: "+id+" Nombre: "+nombre.toString()+" Curso:"+curso.toString());
        }
        System.out.println();
       
       /*
            También podemos ordenar los resultados que obtenemos de las consultas con la función sort(),
            para ello tendremos que importar la librería import static com.mongodb.client.model.Sorts.*;
       */
       //En esta ocasión devolvemos los registros cuyo curso sea "2DAM" ordenados por nombre
       System.out.println("---------Registros de 2DAM ordenados por nombre-------------");
       docs= coleccion.find(eq("curso","2DAM")).sort(descending("nombre")).iterator();
       while(docs.hasNext()){
           Document docu= docs.next();
           System.out.println(docu.toJson());
                   
       }
       
       //Por utlimo cerramos el cursor con el que hemos ido recorriendo los resultados
       docs.close();
        
    }

    private static void utilizarProyecciones() {
        //Creamos la conexión a la BD
        MongoClient cliente= new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion = db.getCollection("amigos");
        
        /*
            Utilizamos las proyecciones para obtener parte de los contenidos de un documento. Para utilizar las
            proyecciones tenemos que importar la librería import static com.mongodb.client.model.Projections.*;
        */
        /*En la siguiente consulta obtenemos los registros cuyo curso sea 1DAM ordenados por nombre ascendentemente
        y de los que solo obtenemos el nombre y la nota*/
        MongoCursor<Document> cursor = coleccion.find(eq("curso","2DAM")).sort(ascending("nombre"))
                .projection(include("nombre","nota")).iterator();
        
        //Recorremos los resultados y los mostramos por pantalla
        System.out.println("---------Registros de los que solo obtenemos curso y nombre-------------");
        while (cursor.hasNext()){
            Document docu = cursor.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        /*
            También podemos proceder de forma inversa, excluyendo campos en lugar de incluirlos con la función exclude()
        */
        Document docu = (Document) coleccion.find(eq("nombre","Pepita")).projection(exclude("_id","nota","nombre")).first();
        System.out.println("---------Registros con id, nombre y nota excluidos-------------");
        System.out.println(docu.toJson());
        
        
        //Cerramos el cursor con el que hemos obtenido los resultados
        cursor.close();
    }

    private static void utilizarAgregaciones() {
        //Creamos la conexión a la base de datos
        MongoClient cliente = new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion = db.getCollection("amigos");
        
        /*
            Para poder utilizar las etapas .aggregate de MongoDB tenemos que importar la siguiente librería
                import static com.mongodb.client.model.Aggregates.*;
        
            Para añadir las etapas de agregado utilizamos el funcion java.util.Arrays.asList
        */
        //Las etapa de agregado se puede utilizar para para obtener resultados sin necesidad de las funciones de agregado
        //En el siguiente ejemplo se utilia la etapa match para visualizar todos los registros que sean del curso 1DAM
        MongoCursor<Document> docs = coleccion.aggregate(Arrays.asList(match(eq("curso","1DAM")))).iterator();
        System.out.println("---------Registros de 1DAM con aggregate-------------");
        while(docs.hasNext()){
            Document docu = docs.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        //En el siguiente ejemplo se utilia la etapa match para visualizar todos los registros que sean del curso 1DAM
        docs = coleccion.aggregate(Arrays.asList(match(eq("curso","1DAM")),
                project(fields(include("name","nota"),excludeId()))))
                .iterator();
        
        System.out.println("---------Registros de 1DAM con aggregate y project -------------");
        while(docs.hasNext()){
            Document docu = docs.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        /* 
            La principal funcionalidad de es poder realizar operaciones con funciones de agregado
            sobre un conjunto de registros.
            Para llevar a cabo estas operaciones utilizaremos la librería
                import static com.mongodb.client.model.Accumulators.*;
        */
        
        //En el siguiente ejemplo calculamos la suma y la nota media agrupada por curso
        
        docs = coleccion.aggregate(Arrays.asList(
            group("$curso",sum("sumanota","$nota"),avg("medianota","$nota")
        ))).iterator();
        System.out.println("---------Suma y media de la nota agrupada por curso---------");
        while(docs.hasNext()){
            Document docu = docs.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        //Si desearamos calcular la suma y la media de los dos curso utilizariamos la siguiente consulta
        docs = coleccion.aggregate(Arrays.asList(
            group("",sum("sumanota","$nota"),avg("medianota","$nota")
        ))).iterator();
        System.out.println("---------Suma y media de la nota sin agrupar---------");
        while(docs.hasNext()){
            Document docu = docs.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        /*
            En algunos casos podemos guardar el resultado de la consulta en una colección de la base de datos
            En el ejemplo se utilizan la consulta realizada anteriormente y se guarda en una nueva colección de la
            BD con la función out()
        */
        docs = coleccion.aggregate(Arrays.asList(
            group("$curso",sum("sumanota","$nota"),avg("medianota","$nota")),
            out("mediascurso")
        )).iterator();
        System.out.println("---------Suma y media de la nota agrupada y guardada en una nueva coleccion------");
        while(docs.hasNext()){
            Document docu = docs.next();
            System.out.println(docu.toJson());
        }
        System.out.println();
        
        //Cerramos el cursosr utilizado para recorrer los elementos
        docs.close();
    }

    private static void actualizarDocumentos() {
        //Creamos la conexión a la base de datos
        MongoClient cliente= new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoCollection<Document> coleccion = db.getCollection("amigos");
        
        /*
            Cuando queremos realizar una actualización sobre un documento tenemos que hacer uso de la
            libreria import static com.mongodb.client.model.Updates.*;
            
            Cuando deseamos modificar un único registro utilizamos el método updateOne(), paralelamente
            podremos modificar mas de un documento mediante el método updateMany()
        */
        
        //Con la siguiente instrucción modificamos el documento cuyo nombre es igual a Ana modificando su nota
        coleccion.updateOne(eq("nombre", "Pepita"),set("nota",5));
        Document doc= (Document) coleccion.find(eq("nombre","Pepita")).first();
        System.out.println("---------Datos modificados de Pepita------");
        System.out.println(doc.toJson());
        System.out.println();
        
        /*
            Con la opción updateMany podemos modificar varios registros a la vez, tenemos la posibilidad de
            utilizar el retorno de este método asignandolo a una instancia de la clase UpdateResult
            para obtener entre otros, los documentos que cumplen la condición que hemos establecido (getMatchedCount())
            o aquellos que han sido modificados (getModifiedCount())
        */
        
        //En la siguiente sentencia incrementamos en una unidad la nota de los registros cuyo curso sea 1DAM
        UpdateResult resultactualizacion= coleccion.updateMany(eq("curso","1DAM"), inc("nota",1));
        System.out.println("---------Notas de 1DAM incrementadas en 1------");
        System.out.println("Se han seleccionado: "+resultactualizacion.getMatchedCount());
        System.out.println("Se han modificado: "+resultactualizacion.getModifiedCount());
        System.out.println();
        
        /*
            Podemos utilizar la funcion exists("_id") dentro de updateMany() para modificar todos los documentos
            de la colección.
        */
        
        //El siguiente update incrementa en 2 la nota de todos los documentos que tengan _id
        resultactualizacion = coleccion.updateMany(exists("_id"), inc("nota",2));
        System.out.println("---------Nota de todos los documentos incrementada en 2------");
        System.out.println("Se han seleccionado: "+resultactualizacion.getMatchedCount());
        System.out.println("Se han modificado: "+resultactualizacion.getModifiedCount());
        System.out.println();
        
        /*
            Podemos añadir un campo a un documento mediante la función set() y si el campo
            no existe se crea
        */
        
        //En este ejemplo se añade un campo poblacion al registro Pepita
        resultactualizacion=coleccion.updateOne(eq("nombre","Pepita"), set("poblacion","Toledo"));
        System.out.println("---------Añadir a Pepita la población Toledo------");
        doc= (Document) coleccion.find(eq("nombre","Pepita")).first();
        System.out.println(doc.toJson());
        System.out.println();
        
        /*
            A la inversa también podemos eliminar un campo de cualquier documento pero esta vez utilizando
            el método unset()
        */
        
        //En el siguiente ejemplo borramos la población de aquellos registros cuyo curso sea 1DAM
        coleccion.updateMany(eq("curso","1DAM"), unset("poblacion"));
        System.out.println("---------Eliminamos la población de los 1DAM------");
        System.out.println("Se han seleccionado: "+resultactualizacion.getMatchedCount());
        System.out.println("Se han modificado: "+resultactualizacion.getModifiedCount());
        System.out.println();
    }

    private static void borrarDocumentos() {
        //Creamos la conexión con la BD
        MongoClient cliente= new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        MongoCollection coleccion = db.getCollection("amigos");
        
        /*
            Al igual que la actualización de documentos podemos borrar solamente un documento(deleteOne()),
            o barrar varios (deleteMany()). Con una instancia de la clase DeleteResult podemos obtener información de
            los documentos borrados
        */
        //En el siguiente ejemplo se borra el documento cuya propiedad name tiene el valor asignado de Ana
        DeleteResult resultadoborrado= coleccion.deleteOne(eq("name","Ana"));
        System.out.println("---------Eliminamos el documento con name=Ana------");
        System.out.println("Se han borrado: "+resultadoborrado.getDeletedCount());
        System.out.println();
        
        /*
            Si utilizamos la función exists() como en el apartado anterior podemos borrar todos los datos
            de una colección si la asociamos con deleteMany()
        */
        //Borramos todos los documentos que contiene la colección amigos
        resultadoborrado = coleccion.deleteMany(exists("_id"));
        System.out.println("---------Eliminamos todos los documentos de la colección Amigos------");
        System.out.println("Se han borrado: "+resultadoborrado.getDeletedCount());
        System.out.println();
        
        
        
    }

    private static void crearBorrarColecciones() {
        //Creamos el cliente y recuperamos la base de datos
        MongoClient cliente = new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        
        /*
            Para crear una colección dentro de la base de datos a la que acabamos de enlazar utilizamos
            el método createCollection() que nos ofrece la clase MongoDatabase
        */
        db.createCollection("nuevaColeccion");
        
        /*
            Por contra, si queremos borrar una colección habremos de crear primero una instancia de la clase
            MongoCollection y después proceder a su borrado con el método drop()
        */
        MongoCollection<Document> coleccion= db.getCollection("nuevaColeccion");
        coleccion.drop();
    }

    private static void listarColecciones() {
        //Creamos el cliente y recuperamos la base de datos
        MongoClient cliente = new MongoClient();
        MongoDatabase db = cliente.getDatabase("mibasedatos");
        
        /*
            Utilizamos el método listCollectionsNames que devuelve las colecciones de una base de datos
            en una instancia de la clase MongoIterable que nos permite recorrerla para mostrar los resultados
        */
        System.out.println("-------------Listado de Colecciones--------------");
        MongoIterable<String> colecciones = db.listCollectionNames();
        Iterator col=colecciones.iterator();
        while (col.hasNext()){
            System.out.println(col.next());
        }
        System.out.println();
        
        //Otra forma de listar las colecciones de forma más comprimida seria
        
        System.out.println("-------------Listado de Colecciones--------------");
        for(String name: db.listCollectionNames()){
            System.out.println(name);
        }
    }

    private static void crearListarBorrarBD() {
        /*
            Para crear una base de datos nueva tenemos que llamar al método getDatabase() desde un cliente
            pero la base de datos no se creará hasta que se inserte un documento en ella.
        */
        MongoClient cliente = new MongoClient();
        MongoDatabase db= cliente.getDatabase("nueva");
        
        //Podemos listar las bases de datos de forma muy parecida a como lo haciamos con las colecciones
        System.out.println("----------Listado de BD antes de insertar documentos------------");
        for(String name: cliente.listDatabaseNames()){
            
            System.out.println(name);
        }
        
        //Insertamos un documento en una coleccion para que se cree la coleccion y la base de datos
        MongoCollection<Document> coleccion = db.getCollection("coleccionNueva");
        Document doc1= new Document("nombre","Pedro").append("teléfono", "1234").append("curso", "2DAM");
        coleccion.insertOne(doc1);
        
        //Mostramos de nuevo las bases de datos que hay ahora
        System.out.println("----------Listado de BD antes de insertar documentos------------");
        for(String name: cliente.listDatabaseNames()){
            
            System.out.println(name);
        }
        
        /*
            Para borrar la base de datos solo tenemos que acudir a la instancia de la clase
            MongoDatabase y utilizar el método drop()
        */
        db.drop();
        
        
    }

    private static void escribirFicherosJSON() {
         //Creamos la conexión a la base de datos
         MongoClient cliente = new MongoClient();
         MongoDatabase db = cliente.getDatabase("mibasedatos");
         MongoCollection<Document> coleccion = db.getCollection("empleados");
         
         /*
            El proceso para escribir los datos de la base de datos en un fichero JSON es el siguiente
         */
         
         File fichero = new File("empleados.json");
         FileWriter fic= null;
         try{
             
             fic = new FileWriter(fichero);
             BufferedWriter writer = new BufferedWriter(fic);
             //Recorro la colección amigos obteniendo todos los documentos y guardando la versión Json de los mismos en el fichero
             System.out.println("--------------------------------------------");
             List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
             for (int i = 0; i<consulta.size();i++){
                 System.out.println("Grabo elemento "+i+", "+consulta.get(i).toString());
                 writer.write(consulta.get(i).toJson());
                 writer.newLine();
                 
             }
             writer.close();
         }catch(IOException ex){
             System.err.println("Error escribiendo datos");
         }finally{
             if (fic!=null)
                 try {
                     fic.close();
             } catch (IOException ex) {
                     System.err.println("No se ha podido cerrar el fichero");
             }
         }
         
         
         
         
         
    }

    private static void LeerFicherosJSON() {
         //Creamos la conexión a la base de datos
         MongoClient cliente = new MongoClient();
         MongoDatabase db = cliente.getDatabase("mibasedatos");
         MongoCollection<Document> coleccion = db.getCollection("empleadosfile");
         
         FileReader fr =null;
         try{
             fr = new FileReader(new File("empleados.json"));
             BufferedReader lector = new BufferedReader(fr);
             
             String cadenajson;
             //Vamos leyendo desde el fichero las cadenas de caracteres y parseandolas a Document para despues insertarlas en la coleccion
             while ((cadenajson=lector.readLine())!=null){
                 System.out.println(cadenajson);
                 
                 //El método parse se encuentra dentro de la librería bson.org.Document.parse
                 Document docu = new Document(Document.parse(cadenajson));
                 coleccion.insertOne(docu);
             }
             fr.close();
             
         }catch(IOException ioe){
             System.err.println("Se ha producido un error en la lectura"+ioe.getLocalizedMessage());
         }finally{
             try {
                 fr.close();
             } catch (IOException ex) {
                 System.err.println("No se ha podido cerrar el fichero");
             }
         }
    }
    
}
