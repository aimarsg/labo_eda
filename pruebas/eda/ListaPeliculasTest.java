package eda;

import eda.practica2.ListaPeliculas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ListaPeliculasTest {
    ListaPeliculas lista;
    Pelicula p1, p2,p3, p4, p5, p6;
    Actor a1, a2;

    @BeforeEach
    void setUp() {
        lista=new ListaPeliculas();
        p1=new Pelicula("el hombe calcetin",0);
        p2=new Pelicula("ben 11", 0);
        p3=new Pelicula("los 7 granditos", 0);
        p4=new Pelicula("navidad en manhattan", 0);
        p5=new Pelicula("paladin", 0);
        p6=new Pelicula("se me acaban las ideas", 0);
        a1=new Actor("perico");
        a2= new Actor("hermenegildo");

    }

    @AfterEach
    void tearDown() {
        lista=null;
        p1=null;
        p2=null;
        p3=null;
        p4=null;
        p5=null;
        p6=null;
    }
    @Test

    void anadirPelicula(){
        //lista vacia
        assertEquals(lista.getLength(), 0);
        lista.anadirPelicula(p1);
        assertEquals(lista.getLength(), 1);
        assertTrue(lista.esta(p1));

        //un elemento

        lista.anadirPelicula(p2);
        assertEquals(lista.getLength(), 2);
        assertTrue(lista.esta(p2));

        //varios elementos
        lista.anadirPelicula(p3);
        lista.anadirPelicula(p4);
        lista.anadirPelicula(p5);
        lista.anadirPelicula(p6);
        assertEquals(lista.getLength(), 6);
        assertTrue(lista.esta(p4));
        assertTrue(lista.esta(p3));
        assertTrue(lista.esta(p5));
        assertTrue(lista.esta(p6));
    }
    @Test
    void esta(){
        //lista vacia
        assertEquals(lista.getLength(), 0);
        lista.anadirPelicula(p1);
        assertEquals(lista.getLength(), 1);
        assertTrue(lista.esta(p1));

        //un elemento

        lista.anadirPelicula(p2);
        assertEquals(lista.getLength(), 2);
        assertTrue(lista.esta(p2));

        //varios elementos
        lista.anadirPelicula(p3);
        lista.anadirPelicula(p4);
        lista.anadirPelicula(p5);
        lista.anadirPelicula(p6);
        assertEquals(lista.getLength(), 6);
        assertTrue(lista.esta(p4));
        assertTrue(lista.esta(p3));
        assertTrue(lista.esta(p5));
        assertTrue(lista.esta(p6));

    }
    @Test
    void buscarPelicula(){
        //lista vacia
        assertEquals(lista.getLength(), 0);
        assertNull(lista.buscarPelicula("juanito periquito"));

        //un elemento

        lista.anadirPelicula(p2);
        assertNull(lista.buscarPelicula("juanito periquito"));
        assertNotNull(lista.buscarPelicula("ben 11"));

        //varios elementos
        lista.anadirPelicula(p3);
        lista.anadirPelicula(p4);
        lista.anadirPelicula(p5);
        lista.anadirPelicula(p6);

        assertNull(lista.buscarPelicula("juanito periquito"));
        assertNotNull(lista.buscarPelicula("paladin"));
    }
    @Test
    void eliminarPeli(){
        //lista vacia
        assertEquals(lista.getLength(), 0);
        lista.eliminarPeli(p1);
        assertEquals(lista.getLength(), 0);



        //lista un elemento
        lista.anadirPelicula(p1);
        assertEquals(lista.getLength(), 1);
        lista.eliminarPeli(p1);
        assertEquals(lista.getLength(), 0);


        //lista varios elementos
        lista.anadirPelicula(p3);
        lista.anadirPelicula(p4);
        lista.anadirPelicula(p5);
        lista.anadirPelicula(p6);

        assertEquals(lista.getLength(), 4);
        lista.eliminarPeli(p3);
        assertEquals(lista.getLength(), 3);
        lista.eliminarPeli(p4);
        assertEquals(lista.getLength(), 2);
    }
    @Test
    void eliminarActor(){
        p1.anadirActor(a1);
        p1.anadirActor(a2);
        p2.anadirActor(a1);
        p3.anadirActor(a1);
        lista.anadirPelicula(p1);
        lista.anadirPelicula(p2);
        lista.anadirPelicula(p3);
        lista.eliminarActor(a1);
        assertEquals(p1.getActores().size(), 1);
        assertEquals(p2.getActores().size(), 0);
        assertEquals(p3.getActores().size(), 0);



    }

}
