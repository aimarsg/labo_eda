package eda.practica3;
import eda.Actor;
import eda.ListaActores;
import eda.Pelicula;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {
    GraphHash g;
    ListaActores lista;


    @BeforeEach
    public void setUp() {
        g=new GraphHash();
        lista=ListaActores.getMiLista();
        lista.cargarLista();

    }
    @AfterEach
    public void tierDown() {
        lista.eliminarActoresParaPruebas();
    }
    @Test
    public void crearGrafoTest() {
        g.crearGrafo(lista);
        //g.print();

    }
    @Test
    public void estanConectadosTest(){

        g.crearGrafo(lista);
        //casos
        //estan conectados directamente
        assertTrue(g.estanConectados("a1", "a3"));
        //estan conectados indirectamente
        assertTrue(g.estanConectados("a1", "a13"));
        //no estan conectados
        assertFalse(g.estanConectados("a2", "a20"));
        //actor aislado
        assertFalse(g.estanConectados("a2", "a15"));

        //assertTrue(g.estanConectados("Rodriquez, Michelle", "Devon, Tony"));
        //assertFalse(g.estanConectados("Devon, Tony", "Singh, Jaspal"));

    }

    @Test
    public void caminoTest(){
        g.crearGrafo(lista);
        assertNull(g.camino("a2", "a20"));
        ArrayList<String> camino= g.camino("a1", "a17");


        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }
        camino= g.camino("a1", "a3");


        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }

    }
}
