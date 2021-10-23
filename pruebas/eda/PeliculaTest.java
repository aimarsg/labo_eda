package eda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeliculaTest {
    Pelicula p1,p2,p3;

    @BeforeEach
    public void setUp() throws Exception {

        p1= new Pelicula("piolin", (float)10.0);
        p2= new Pelicula("wally", (float)20.0);
        p3= new Pelicula("blancanieves", (float)30.0);

    }

    @AfterEach
    public void tearDown() throws Exception {
        p1=null;
        p2=null;
        p3=null;
    }


    @Test
    public void testIncrementarRecaudacion() {
        assertEquals((float)p1.getRecaudacion(),(float)10,0);
        p1.incrementarRecaudacion(5);
        assertEquals((float)p1.getRecaudacion(),(float)15,0);

    }

    @Test
    public void testAnadirActor() {
        Actor a1= new Actor("pepe");
        Actor a2= new Actor("juan");
        Actor a3= new Actor("jose");
        Actor a4= new Actor("txomin");

        //lista vacia
        assertEquals(p1.getActores().size(),0);
        p1.anadirActor(a1);
        assertEquals(p1.getActores().size(),1);
        assertEquals(p1.getActores().get("pepe"),a1);

        //lista con 1 elemento
        assertEquals(p1.getActores().size(),1);
        p1.anadirActor(a2);
        assertEquals(p1.getActores().size(),2);
        assertEquals(p1.getActores().get("juan"),a2);

        //lista con varios elementos
        p1.anadirActor(a3);
        assertEquals(p1.getActores().size(),3);
        p1.anadirActor(a4);
        assertEquals(p1.getActores().size(),4);
        assertEquals(p1.getActores().get("juan"),a2);
    }

    @Test
    public void testEliminarActor() {
        Actor a1= new Actor("pepe");
        Actor a2= new Actor("juan");
        Actor a3= new Actor("jose");
        Actor a4= new Actor("txomin");
        assertEquals(p1.getActores().size(),0);
        //lista vacia
        assertEquals(p1.eliminarActor("pepe"),null);

        //lista 1 elemento
        p1.anadirActor(a1);
        assertEquals(p1.getActores().size(),1);
        assertEquals(p1.eliminarActor("pepe"),a1);
        assertEquals(p1.getActores().size(),0);

        // lista varios elementos
        p1.anadirActor(a2);
        p1.anadirActor(a3);
        p1.anadirActor(a4);
        assertEquals(p1.getActores().size(),3);

        assertEquals(p1.eliminarActor("juan"),a2);
        assertEquals(p1.getActores().size(),2);


    }

}
