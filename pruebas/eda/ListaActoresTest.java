package eda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

class ListaActoresTest {
    ListaActores lista;
    @BeforeEach
    void setUp() {
        lista= ListaActores.getMiLista();
        //lista.cargarLista();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void anadirActor() {
        //lista vacia
        assertNull(lista.buscarActor("pepe"));
        lista.anadirActor("pepe");//actor que no esta
        assertNotNull(lista.buscarActor("pepe"));

        //anadir actor existente
        lista.anadirPeliculaActor("un dia", (float) 0,"Bakerdias, Keen" );//
        assertNotNull(lista.buscarActor("Bakerdias, Keen"));
        lista.anadirActor("Bakerdias, Keen");//actor que si esta
        assertNotNull(lista.buscarActor("Bakerdias, Keen"));

    }

    @Test
    void eliminarActor() {
        assertNull(lista.eliminarActor("juan")); //actor que no esta
        assertEquals(lista.buscarPelicula("un dia").getActores().size(),1);
        assertNotNull(lista.eliminarActor("Bakerdias, Keen"));//actor que si esta
        assertEquals(lista.buscarPelicula("un dia").getActores().size(),0);//el actor se ha eliminado de la peli
        assertNotNull(lista.eliminarActor("pepe"));//actor que si esta
        //lista vacia
        assertNull(lista.eliminarActor("juancho"));

        //lista 1 elemento
        lista.anadirActor("pedro");
        assertNull(lista.eliminarActor("paco"));
        assertEquals(lista.eliminarActor("pedro").getNombre(),"pedro");

    }

    @Test
    void buscarActor() {
        lista.anadirActor("pepe");
        //no vacio
        lista.anadirActor("luis");
        assertEquals(lista.buscarActor("pepe").getNombre(), "pepe");//esta
        assertNull(lista.buscarActor("perico"));//no esta
        //vacio
        lista.eliminarActor("pepe");
        lista.eliminarActor("luis");
        assertNull(lista.buscarActor("pepe"));

    }

    @Test
    void ordenarActores() {
        lista.eliminarActoresParaPruebas();
        //lista vacia
        assertEquals(lista.ordenarActores().length,0);


        //lista 1 elemento
        lista.anadirActor("z");
        assertEquals(lista.ordenarActores()[0].getNombre(),"z");
        assertEquals(lista.ordenarActores().length,1);

        //lista varios
        lista.anadirActor("b");
        lista.anadirActor("c");
        lista.anadirActor("a");
        lista.anadirActor("e");
        lista.anadirActor("d");
        assertEquals(lista.ordenarActores()[0].getNombre(),"a");
        assertEquals(lista.ordenarActores()[1].getNombre(),"b");
        assertEquals(lista.ordenarActores()[2].getNombre(),"c");
        assertEquals(lista.ordenarActores()[3].getNombre(),"d");
        assertEquals(lista.ordenarActores()[4].getNombre(),"e");

    }


    @Test
    void anadirPeliculaActor() {
        lista.anadirActor("b");
        lista.anadirActor("c");
        lista.anadirActor("a");
        lista.anadirActor("e");
        lista.anadirActor("d");
        //no existe ni pelicula ni actor
        assertNull(lista.buscarPelicula("Piolin"));
        assertNull(lista.buscarActor("f"));
        lista.anadirPeliculaActor("Piolin", (float)100.0, "f");
        assertNotNull(lista.buscarPelicula("Piolin"));
        assertNotNull(lista.buscarActor("f"));
        assertEquals(lista.buscarPelicula("Piolin").getActores().size(),1);

        //existe la peli, pero no el actor

        assertNotNull(lista.buscarPelicula("Piolin"));
        assertNull(lista.buscarActor("h"));
        lista.anadirPeliculaActor("Piolin", (float)100.0, "h");
        assertNotNull(lista.buscarActor("h"));
        assertEquals(lista.buscarPelicula("Piolin").getActores().size(),2);


        //existe el actor, pero no la peli
        assertNull(lista.buscarPelicula("Superlopez"));
        assertNotNull(lista.buscarActor("a"));
        lista.anadirPeliculaActor("Superlopez", (float)100.0, "a");
        assertEquals(lista.buscarPelicula("Superlopez").getActores().size(),1);



        //existe el actor y la peli
        assertNotNull(lista.buscarPelicula("Piolin"));
        assertNotNull(lista.buscarActor("h"));
        lista.anadirPeliculaActor("Piolin", (float)100.0, "a");
        assertEquals(lista.buscarActor("a").getMiLista().getLength(),2);
        assertEquals(lista.buscarPelicula("Piolin").getActores().size(),3);



    }

    @Test
    void eliminarPeli() {
        lista.anadirPeliculaActor("Piolin", (float)100.0, "f");
        lista.anadirPeliculaActor("Piolin", (float)100.0, "h");
        //la pelicula si esta
        assertNotNull(lista.eliminarPeli("Piolin"));
        assertNull(lista.buscarActor("f").buscarPeli("Piolin"));//la pelicula se ha eliminado del actor
        assertNull(lista.buscarActor("h").buscarPeli("Piolin"));//la pelicula se ha eliminado del actor

        //la pelicula no esta
        assertNull(lista.eliminarPeli("El gorro asesino"));

        //lista vacia
        assertNull(lista.eliminarPeli("unaPeli"));
    }

    @Test
    void devolverPeliculasDeActor() {
        lista.anadirPeliculaActor("pelicula", (float)0,"Tom");
        lista.anadirPeliculaActor("Kima", (float)0,"Tom");
        lista.anadirPeliculaActor("Kima", (float)0,"luis");
        lista.anadirPeliculaActor("la fiesta de las salchichas", (float)0,"jaime");

        //no existe el actor
        assertNull(lista.devolverPeliculasDeActor("juanito"));
        //actor existe
        assertEquals(lista.devolverPeliculasDeActor("Tom").buscarPelicula("Kima").getTitulo(), "Kima");
        assertEquals(lista.devolverPeliculasDeActor("Tom").buscarPelicula("pelicula").getTitulo(), "pelicula");
        assertEquals(lista.devolverPeliculasDeActor("Tom").buscarPelicula("Paquito chocolatero"), null);
        assertEquals(lista.devolverPeliculasDeActor("Tom").getLength(),2);
        //actor existe pero no tiene peliculas
        lista.anadirActor("Paco");
        assertEquals(lista.devolverPeliculasDeActor("Paco").getLength(),0);

        //lista vacia
        lista.eliminarActoresParaPruebas();
        assertNull(lista.devolverPeliculasDeActor("juanito"));
    }

    @Test
    void cargarLista() {
        lista.eliminarActoresParaPruebas();
        //la lista esta vacia
        assertEquals(lista.cuantosActoresParaPruebas(),0);
        assertEquals(lista.cuantasPelisParaPruebas(), 0);
        //se carga la lista
        lista.cargarLista();
        assertEquals(lista.cuantosActoresParaPruebas(),17);
        assertEquals(lista.cuantasPelisParaPruebas(), 8);

    }
    @Test
    void buscarPelicula() {
        lista.cargarLista();
        //Pelicula que existe
        assertNotNull(lista.buscarPelicula("Kima"));
        //Pelicula no existente
        assertNull(lista.buscarPelicula("El ventilador loco"));
        // lista vacia
        lista.eliminarActoresParaPruebas();
        assertNull(lista.buscarPelicula("Kima"));

        //lista con 1 elemento
        lista.anadirPeliculaActor("El Hombre Calcetin", (float)5, "paco mer");
        //Pelicula que existe
        assertNotNull(lista.buscarPelicula("El Hombre Calcetin"));
        //Pelicula no existente
        assertNull(lista.buscarPelicula("El ventilador loco"));
    }

    @Test
    void devolverActoresDePeli() {
        lista.anadirPeliculaActor("El Hombre Calcetin", (float)5, "paco mer");
        //solo 1 actor y 1 pelicula
        //existe
        assertEquals(lista.devolverActoresDePeli("El Hombre Calcetin").keySet().toArray()[0], "paco mer");
        assertEquals(lista.devolverActoresDePeli("El Hombre Calcetin").size(),1);
        //no existe
        assertNull(lista.devolverActoresDePeli("slow and furious"));
        //lista completa
        lista.cargarLista();
        //existe
        assertEquals(lista.devolverActoresDePeli("Brahmastram").size(),5);
        //no existe
        assertNull(lista.devolverActoresDePeli("slow and furious 2 "));
        //lista vacia
        lista.eliminarActoresParaPruebas();
        assertNull(lista.devolverActoresDePeli("La loca de los gatos"));

    }

    @Test
    void incrementarRecaudacion() {
        //Existe la peli
        lista.anadirPeliculaActor("Tarzan",(float)10.0,"Jose");
        lista.incrementarRecaudacion("Tarzan", (float)50.0);
        assertEquals(lista.buscarPelicula("Tarzan").getRecaudacion(),60.0);
        //No existe la peli
        lista.incrementarRecaudacion("Fronce", (float)50.0);

        //lista vacia
        lista.eliminarActoresParaPruebas();
        lista.incrementarRecaudacion("Fronce 2", (float)50.0);
    }

    @Test
    void guardarFichero() {
        lista.guardarFichero();
    }

}