/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ejemplosobjectdb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author miguel
 */
public class EjemploObjectDb {
    public static void main(String[] args) {
        
        int opcion=0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("--------------------------------------");
            System.out.println("            Menú Principal");
            System.out.println("--------------------------------------");
            System.out.println("1. Primer Ejemplo con ObjectDb");
            System.out.println("2. Consultas Sencillas. Obtener todos los que practican tenis");
            System.out.println("3. Ejemplo Modificar Objetos de la BD. Cambiar el Deporte");
            System.out.println("4. Borrar objetos de la BD. Borrar a Miguel");
            System.out.println("5. Ejemplos de consultas. Codiciones lógicas");
            System.out.println("6. Ejemplo de consultas. Consultas con acceso a Colecciones");
            System.out.println("7. Actualizar Edad de los Jugadores de un Pais");
            System.out.println("8. Consultas Complejas. Funciones de Agregado");
            System.out.println("9. Consultas con GroupBy.");

            


            System.out.println("0. Salir");
            System.out.print("Introduce la opción deseada: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1: {
                    primerEjemploObjectDB();
                    break;
                }
                case 2: {
                    consultasSencillasTenis();
                    break;
                }
                case 3: {
                    modificarObjetosBD();
                    break;
                }
                case 4: {
                    borrarObjetosBD();
                    break;
                }
                case 5: {
                    ejemploConsultasBDOO();
                    break;
                }
                case 6: {
                    consultasConColecciones();
                    break;
                }
                case 7: {
                    System.out.println("Introduce el nombre del pais que deseas actualizar");
                    String nombrepais= sc.nextLine();
                    actualizarEdadJugadoresPais(new Pais(1,nombrepais));
                    break;
                }
                case 8: {
                    consultasConFuncionesDeAgregado();
                    break;
                }
                case 9: {
                    consultasConGroupBy();
                    break;
                }
                default:{
                    
                    break;
                }
                        

            }
            
            
        }while (opcion!=0);
        System.exit(0);
        
        
    }

    private static void primerEjemploObjectDB() {
        //Creamos las instancias que serán almacenadas en la BDOO
        ArrayList lenguajesMaria= new ArrayList();
        lenguajesMaria.add("Francés");
        lenguajesMaria.add("Inglés");
        Jugadores j1= new Jugadores ("Maria","Voleibol","Madrid",14,new Pais(1,"Francia"),lenguajesMaria);
        ArrayList lenguajesMiguel= new ArrayList();
        lenguajesMiguel.add("Español");
        lenguajesMiguel.add("Inglés");
        Jugadores j2= new Jugadores ("Miguel","Tenis","Madrid",13,null,lenguajesMiguel);
        ArrayList lenguajesMario= new ArrayList();
        Jugadores j3= new Jugadores ("Mario","Baloncesto","Guadalajara",15,new Pais(1, "Spain"),lenguajesMario);
        ArrayList lenguajesAlicia= new ArrayList();
        lenguajesAlicia.add("Español");
        lenguajesAlicia.add("Inglés");
        lenguajesAlicia.add("Francés");
        Jugadores j4= new Jugadores ("Alicia","Tenis","Madrid",16,new Pais(1,"Spain"),lenguajesAlicia);
        
        //Creamos la conexión con la BD con la siguiente instrucción
        // en caso de no existir crea la base de datos
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();        
        
        //Para realizar cualquier modificación de los elementos que contiene la base de datos se trendrá que definir una transacción
        em.getTransaction().begin();

        //Realizamos el almacenamiento de objetos
        
        em.persist(j1);
        em.persist(j2);
        em.persist(j3);
        em.persist(j4);

        
        //Realizando un commit nos aseguraremos que los cambios se reflejen en la BD
        em.getTransaction().commit();

        //Recuperamos los objetos, en este caso serán todos aquellos objetos que se guarden en la BD del tipo Jugadores
        
        TypedQuery<Jugadores> query =
            em.createQuery("SELECT j FROM Jugadores j", Jugadores.class);
        List<Jugadores> results = query.getResultList();
        
        //Mostramos el número de coincidencias que se han recuperado        
        System.out.println("Se han recuperado "+results.size());

        
        for (Jugadores j : results) {
            //Como tenemos el operador ToString sobrecargado en la clase Jugadores podemos recurrir a él para que no muestre los datos del mismo
            System.out.println(j);
        }
        
        //Cerramos la Base de Datos
        em.close();
        emf.close();
    }


    private static void consultasSencillasTenis() {
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager(); 
        
        //Para obtener el resultado ObjectDb proporciona dos tipos de consultas, una utilizando JPQL (Similar a SQL) o JPA Criteria Query
        
        //Con JPA Criteria Query se utiliza una serie de clases Java para definir los criterios de búsqueda
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        
        //Definición de una consulta con parámetros
        CriteriaQuery<Jugadores> filtro = cb.createQuery(Jugadores.class);
        Root<Jugadores> j = filtro.from(Jugadores.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        filtro.select(j).where(cb.equal(j.get("deporte"), p));
        
        //Con la siguiente instrucción se ordenarían los resultados producidos por la consulta
        filtro.orderBy(cb.asc(j.get("nombre")),cb.desc(j.get("edad")));
        
        //Definimos el parámetro p que se utilizará para cribar los resultados de la consulta
        TypedQuery<Jugadores> query = em.createQuery(filtro);
        query.setParameter(p, "Tenis");
        List<Jugadores> results = query.getResultList();
        
        
        //Imprimimos los resultados obtenidos en la ejecución de la consulta
        for(Jugadores jug: results){
            System.out.println(jug);
        }
        
        //Si utilizamos JPQL para ejecutar la consulta, podemos utilizar una nomenclatura similar a SQL para componer los criterios de filtrado
        //En este caso se ha de notar que se devuelve un solo parámetro de la instancia de la clase Jugadores, en este caso el atributo nombre
        TypedQuery<String> consulta = em.createQuery("SELECT j.nombre FROM Jugadores j WHERE j.deporte= :parametrodeporte", String.class);
        //También se pueden establecer parámetros en la sentencia JPQL con la posición de los parámetros
        //TypedQuery<String> consulta = em.createQuery("SELECT j.nombre FROM Jugadores j WHERE j.deporte= ?1", String.class);
       
        consulta.setParameter("parametrodeporte", "Tenis");
        //El método setParameter para configurar el parámetro por posición sería la siguiente
        //consulta.setParameter(1, "tenis");
        
        List<String> jugadoresDeTenis = consulta.getResultList();
        
        //
        
        //Imprimimos los resultados obtenidos en la ejecución de la consulta
        for(String nombres: jugadoresDeTenis){
            System.out.println(nombres);
        }
        
        
        //Cerramos la BD
        em.close();
        emf.close();
    }

    private static void modificarObjetosBD() {
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        
        //Generamos la consulta para conseguir el objeto que queremos modificar
        TypedQuery consulta = em.createQuery("SELECT j FROM Jugadores j WHERE j.nombre='Maria'", Jugadores.class);
        
        
        
        //Con el método getSingleResult obtenemos una solo resultado como respuesta de la consulta.
        Jugadores jug = (Jugadores) consulta.getSingleResult();
        
        System.out.println("\nAntes de modificar el deporte de la jugadora\n"+jug);
        
        jug.setDeporte("Voley Playa");
        
        //Comenzamos una transacción puesto que vamos a modificar un objeto ya almacenado en la base de datos.
        em.getTransaction().begin();
        
        //Actualizamos la instancia de la clase Jugadores que acabamos de modificar.
        em.persist(jug);
        
        //Realizamos el commit para que los datos se confirmen en la BD
        em.getTransaction().commit();
        
        System.out.println("Después de modificar el deporte de la jugadora\n"+jug);
        
        //Cerramos la BD
        em.close();
        emf.close();
    }

    private static void borrarObjetosBD() {
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        
        /*
        Al igual que el anterior ejemplo primero tenemos que recuperar el objeto que tenemos insertado en la base de datos
        Lo realizamos mediante una consulta mediante la clase JPQL
        */
        TypedQuery consulta = em.createQuery("SELECT j FROM Jugadores j WHERE j.nombre='Miguel'", Jugadores.class);
        
        //Obtenemos la instancia devuelta con el método getFirst, puesto que solo hay un jugador de nombre Miguel
        Jugadores jug= (Jugadores) consulta.getSingleResult();
        
        //Vamos a realizar una modificación de la base de datos y por tanto tendremos que comenzar una transacción
        em.getTransaction().begin();
        
        //Borramos el jugador con el método delete() pasandole la instancia del objeto que queremos borrar
        em.remove(jug);
        
        //Consolidamos los cambios con el método commit
        em.getTransaction().commit();
        System.out.println("El jugador "+jug.getNombre()+" ha sido borrado de la base de datos");
        
        //Por último cerramos la BD
        em.close();
        emf.close();
    }

    private static void ejemploConsultasBDOO() {
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Jugadores> consultaGeneral = em.createQuery("SELECT j FROM Jugadores j", Jugadores.class);
        System.out.println("\nTodos los jugadores almacenados en la BD");
        System.out.println("--------------------------------------");
        for (Jugadores j: consultaGeneral.getResultList()){
            System.out.println(j);
        }
        
        /*
        Para realizar consultas en ObjectDB podemos utilizar tanto el lenguaje JPQL como la interfaz de criterios que proporciona JPA.
        La sencillez que proporciona las similitudes del lenguaje JPQL con SQL lo pueden hacer menos legible en consultas complejas con parámetros
        donde la utilización de JPA puede clarificar el código si trabajamos con multitud de parámetros que puedan provenir de un formulario.
        */
        //En el siguiente ejemplo mostraremos todos los jugadores cuyo nombre empieza por M
        TypedQuery consulta1 = em.createQuery("SELECT j FROM Jugadores j WHERE j.nombre LIKE 'M%'", Jugadores.class);
        
        //Ejecutamos la consulta
        List<Jugadores> resultado1= consulta1.getResultList();
        
        
        //Mostramos los resultados por pantalla
        System.out.println("\nJuadores cuyo nombre empieza por M");
        System.out.println("--------------------------------------");
        Iterator<Jugadores> iterador = resultado1.iterator();
        while(iterador.hasNext()){
            Jugadores jug= iterador.next();
            System.out.println(jug);
        }
        System.out.println();
        
        //En el siguiente ejemplo mostraremos todos los jugadores cuyo nombre no empieza por M
        TypedQuery consulta2 = em.createQuery("SELECT j FROM Jugadores j WHERE j.nombre NOT LIKE 'M%'", Jugadores.class);
        List<Jugadores> resultado2= consulta2.getResultList();
        
        System.out.println("Jugadores cuyo nombre NO empieza por M");
        System.out.println("--------------------------------------");
        for(Jugadores jug: resultado2){
            System.out.println(jug);
        }
        
        System.out.println();
        
        //En el siguiente ejemplo mostraremos todos los jugadores cuya edad es mayor que 14 años
        TypedQuery consulta3 = em.createQuery("SELECT j FROM Jugadores j WHERE j.edad>14", Jugadores.class);
        List<Jugadores> resultado3 = consulta3.getResultList();
        System.out.println("Jugadores cuya edad sea mayor que 14 años");
        System.out.println("--------------------------------------");
        for(Jugadores jug:resultado3){
            System.out.println(jug);
        }
        System.out.println();
        
        //En el siguiente ejemplo mostraremos todos los jugadores cuya edad es mayor o igual que 14 años
        TypedQuery consulta4 = em.createQuery("SELECT j FROM Jugadores j WHERE j.edad>=14", Jugadores.class);
        List<Jugadores> resultado4 = consulta4.getResultList();
        System.out.println("Jugadores cuya edad sea mayor o igual que 14 años");
        System.out.println("--------------------------------------");
        for(Jugadores jug:resultado4){
            System.out.println(jug);
        }
        System.out.println();
        
        
        //En el siguiente ejemplo se comprueba si un atributo no es nulo. En este ejemplo aquellos jugadores cuya ciudad no es nula 
        //además de los jugadores cuya edad es mayor o igual que 13 años
        TypedQuery consulta5 = em.createQuery("SELECT j FROM Jugadores j WHERE j.ciudad IS NOT NULL AND j.edad>13", Jugadores.class);
        List<Jugadores> resultado5 = consulta5.getResultList();
        System.out.println("Juadores cuya edad sea mayor que 13 años y esté asociado a una ciudad");
        System.out.println("--------------------------------------");
        for(Jugadores jug:resultado5){
            System.out.println(jug);
        }
        System.out.println();
        
        
        //Cerramos la BD
        em.close();
        emf.close();
    }

    private static void consultasConColecciones() {
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        
        //Con JPQL podemos acceder a datos que estén almacenados dentro de colecciones que pertenezcan a la clase que estamos almacenando.
        
        //En el ejemplo buscaremos aquellos jugadores de los que no tenemos almacenados ningún idioma
        TypedQuery<Jugadores> consulta1 = em.createQuery("SELECT j FROM Jugadores j WHERE j.idiomas IS EMPTY", Jugadores.class);
        List<Jugadores> resultados1 = consulta1.getResultList();
        System.out.println("Juadores que de los que no sabemos el idioma");
        System.out.println("--------------------------------------------");
        for(Jugadores jug: resultados1){
            System.out.println(jug);
        }
        
        
        //En el siguiente ejemplo buscaremos aquellos jugadores que saben Inglés
        TypedQuery<Jugadores> consulta2 = em.createQuery("SELECT j FROM Jugadores j WHERE 'Inglés' IN j.idiomas", Jugadores.class);
        //TypedQuery<Jugadores> consulta2 = em.createQuery("SELECT j FROM Jugadores j WHERE 'Inglés' MEMBER OF j.idiomas", Jugadores.class);
        List<Jugadores> resultados2 = consulta2.getResultList();
        System.out.println("Juadores que saben hablar Inglés");
        System.out.println("--------------------------------------------");
        for(Jugadores jug: resultados2){
            System.out.println(jug);
        }
        
        //En el siguiente ejemplo buscaremos aquellos jugadores que saben más de dos idiomas
        TypedQuery<Jugadores> consulta3 = em.createQuery("SELECT j FROM Jugadores j WHERE SIZE(j.idiomas)>2", Jugadores.class);
        List<Jugadores> resultados3 = consulta3.getResultList();
        System.out.println("Juadores que saben más de dos idiomas");
        System.out.println("--------------------------------------------");
        for(Jugadores jug: resultados3){
            System.out.println(jug);
        }
    }

    private static void actualizarEdadJugadoresPais(Pais pais) {
        
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);
        
        //En el ejemplo buscaremos aquellos jugadores de los que no tenemos almacenados ningún idioma
        TypedQuery<Jugadores> consulta1 = em.createQuery("SELECT j FROM Jugadores j WHERE j.pais.nombrepais=:npais", Jugadores.class);
        consulta1.setParameter("npais", pais.getNombrepais());
        List<Jugadores> resultados1 = consulta1.getResultList();
        System.out.println("Juadores nacidos en "+pais.getNombrepais());
        System.out.println("--------------------------------------------");
        for(Jugadores jug: resultados1){
            System.out.println(jug);
        }
        
        //También se pueden actualizar múltiples objetos con una sola sentencia con la ejecución de un UPDATE en JPQL
        //Creamos una transacción para realizar una modificación de la base de datos
        
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE Jugadores j SET j.edad=j.edad +1 WHERE j.pais = ?1");
        
        q.setParameter(1,pais);
        int modificaciones = q.executeUpdate();
        
        
        
        //Realizamos el commit para persistir los cambios realizados a la base de datos
        em.getTransaction().commit();
        
        //Permite mostrar los cambios realizados en la base de datos sin tener que cerrar la conexión del EntityManager
        em.clear();
        
        
        System.out.println("Se ha aumentado la edad de "+modificaciones+" jugadores");
        
        
        TypedQuery<Jugadores> consultaJugadores = em.createQuery("SELECT j FROM Jugadores j WHERE j.pais.nombrepais=:npais", Jugadores.class);
        consultaJugadores.setFlushMode(FlushModeType.COMMIT);
        consultaJugadores.setParameter("npais", pais.getNombrepais());
        List<Jugadores> jugadoresModificados = consultaJugadores.getResultList();
        System.out.println("Jugadores actualizados");
        System.out.println("--------------------------------------------");
        for(Jugadores jug: jugadoresModificados){
            System.out.println(jug);
        }
        
        //Cerramos la BD
        em.close();
        emf.close();
        
    }

    private static void consultasConFuncionesDeAgregado() {
        
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        
        
        /*-----------------------------------------------------------------------------------------------
                                    Obtenemos la suma de las edades de los jugadores
        -------------------------------------------------------------------------------------------------*/
        //Se puede utilizar la función Query que nos devolvería un Object al que tendríamos que realizar un cast
        Query q = em.createQuery("SELECT SUM(j.edad) FROM Jugadores j");
        long sumaEdad = (long) q.getSingleResult();
        System.out.println("La suma de las edades de los jugadores que hay almacenados en la BD es: "+sumaEdad);
        
        /*-----------------------------------------------------------------------------------------------
                                    Media de las edades de los jugadores
        -------------------------------------------------------------------------------------------------*/
        //Lo realizamos esta vez con TypedQuery al que se definirá el tipo de resultado que vamos a obtener
        TypedQuery<Double> q1 = em.createQuery("SELECT avg(j.edad) FROM Jugadores j", Double.class);
        Double mediaEdad = q1.getSingleResult();
        System.out.println("La media de edad de los jugadores es: "+mediaEdad);
    

        /*-----------------------------------------------------------------------------------------------
                                    Obtenemos el número de jugadores que tenemos en la BD
        -------------------------------------------------------------------------------------------------*/
        
        //La función COUNT devolverá un valor long que representa el número de elementos 
        Query q2 = em.createQuery("SELECT COUNT(j) FROM Jugadores j");
        long numeroJugadores = (long) q2.getSingleResult();
        System.out.println("Tenemos almacenados "+numeroJugadores+" en la base de datos");
        

        
        /*-----------------------------------------------------------------------------------------------
                    Obtenemos la Edad Maxima de los Jugadores que tenemos almacenados en la BD
        -------------------------------------------------------------------------------------------------*/
        
        //La función MAX devolverá un valor long que representa el número de elementos 
        TypedQuery<Integer> q3 = em.createQuery("SELECT MAX(j.edad) FROM Jugadores j", Integer.class);
        int edadmaxima = q3.getSingleResult();
        System.out.println("El jugador de mayor edad tiene "+edadmaxima+" años");
        
        /*-----------------------------------------------------------------------------------------------
                    Obtenemos la Edad Mínima de los jugadores que tenemos alacenados en la BD
        -------------------------------------------------------------------------------------------------*/
        TypedQuery<Integer> q4 = em.createQuery("SELECT MIN(j.edad) FROM Jugadores j", Integer.class);
        int edadminima = q4.getSingleResult();
        System.out.println("El jugador de menor edad tiene "+edadminima+" años");
        
        /*-----------------------------------------------------------------------------------------------
                    Consultas con varias funciones de agregados que devuelven un Array de Objetos
        -------------------------------------------------------------------------------------------------*/
        
        TypedQuery<Object[]> consulta = em.createQuery("SELECT COUNT(j), MAX(j.edad), COUNT(DISTINCT(j.pais.nombrepais)) FROM Jugadores j", Object[].class);
        Object[] resultado = consulta.getSingleResult();
        System.out.println("Tenemos "+ resultado[0] +" jugadores almacenados. De "+ resultado[2]+" paises diferentes y cuya mayor edad es: "+resultado[1]);
        
        /*-----------------------------------------------------------------------------------------------
                    Consultas con funciones de agregado con filtros sobre colecciones
        -------------------------------------------------------------------------------------------------*/
       
        TypedQuery<Double> consulta3 = em.createQuery("SELECT avg(j.edad) FROM Jugadores j WHERE 'Inglés' MEMBER OF j.idiomas", Double.class);
        Double resultado3 = consulta3.getSingleResult();
        System.out.println("La media de edad de los jugadores que saben inglés es: "+resultado3);
        
        
        //Cerramos la BD
        em.close();
        emf.close();
        
        
        
    }

    private static void consultasConGroupBy() {
        
        
        //Abrimos la base de datos donde hemos insertado los jugadores
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:db/equipos.odb");
        EntityManager em = emf.createEntityManager();
        
        
        /*-----------------------------------------------------------------------------------------------
                    Media de edad de los jugadores por paises
        -------------------------------------------------------------------------------------------------*/
        
        //Si se necesitan realizar grupos de los elementos que tenemos almacenados en la base de datos podemos recurrir a la opción GROUP BY
        //Como introducimos dos campos, el nombre del país y la media, nos devolverá un array de objetos
        TypedQuery<Object[]> consulta1 = em.createQuery("SELECT j.pais.nombrepais,avg(j.edad) FROM Jugadores j GROUP BY j.pais.nombrepais", Object[].class);
        //Obtenemos los resultados devueltos por la consulta en una colección de arrays de objetos donde el primer valor del array será el país y el segundo la media
        List<Object[]> resultado1 = consulta1.getResultList();
        
        //Recorremos la lista de Arrays de Objetos obteniendo los valores en String del nombre del país y en Double la media de edad de los jugadores del mismo.
        for(Object[] o: resultado1){
            String pais= (String) o[0];
            Double mediaedad = (Double) o[1];
            System.out.println("El país "+pais+" tiene una media de edad de "+mediaedad);
        }
        
        /*-----------------------------------------------------------------------------------------------
                    Utilización de la clausula HAVING para cribar los resultados del GROUP BY
        -------------------------------------------------------------------------------------------------*/
        //Vamos a realizar una consulta que nos devuelva el nombre del pais y la media de edad siempre que esta sea mayor o igual a 15
        TypedQuery<Object[]> consulta2 = em.createQuery("SELECT j.pais.nombrepais,avg(j.edad) FROM Jugadores j GROUP BY j.pais.nombrepais HAVING avg(j.edad)>=15", Object[].class);
        //Obtenemos los resultados devueltos por la consulta en una colección de arrays de objetos donde el primer valor del array será el país y el segundo la media
        List<Object[]> resultado2 = consulta2.getResultList();
        
        //Recorremos la lista de Arrays de Objetos obteniendo los valores en String del nombre del país y en Double la media de edad de los jugadores del mismo.
        for(Object[] o: resultado2){
            String pais= (String) o[0];
            Double mediaedad = (Double) o[1];
            System.out.println("El pais "+pais+" tiene una media de edad mayor de 15, en concreto: "+mediaedad);
        }      
      
                
        
        
        
        //Cerramos la BD
        em.close();
        emf.close();
    }
        
}
