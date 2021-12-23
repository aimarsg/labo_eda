package eda.practica3;
import eda.Actor;
import eda.ListaActores;
import eda.Pelicula;
import eda.Reloj;
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


    }
    @AfterEach
    public void tierDown() {
        lista.eliminarActoresParaPruebas();
    }
    @Test
    public void crearGrafoTest() {
        //Lista sin actores
        lista.eliminarActoresParaPruebas();
        g.crearGrafo(lista);
        assertEquals(0, g.getG().size());
        //g.print();
        //Un solo actor
        lista.anadirActor("Lucas");
        g.crearGrafo(lista);
        assertEquals(1, g.getG().size());
        //lista de varios elementos
        lista.anadirActor("andy");
        lista.anadirActor("pepe");
        g.crearGrafo(lista);
        assertEquals(3, g.getG().size());

        g = new GraphHash();
        lista.cargarLista("FilmsActors20212022-20000-first-lines.txt");
        Reloj mireloj = new Reloj();
        g.crearGrafo(lista);
        System.out.println(mireloj.elapsedTime());

    }
    @Test
    public void estanConectadosTest(){
        lista.eliminarActoresParaPruebas();
        //lista de un elemento
        lista.anadirActor("pepe");
        lista.anadirPeliculaActor("buscando a nemo", 10f,"pepe");
        assertTrue(g.estanConectados("pepe", "pepe"));
        lista.eliminarActor("pepe");

        lista.cargarLista("doc1.txt");
        g=new GraphHash();
        g.crearGrafo(lista);

        //casos
        //uno consigo mismo
        assertTrue(g.estanConectados("a1", "a1"));
        //estan conectados directamente
        assertTrue(g.estanConectados("a1", "a3"));
        //estan conectados indirectamente
        assertTrue(g.estanConectados("a1", "a13"));
        //no estan conectados
        assertFalse(g.estanConectados("a2", "a20"));
        //actor aislado
        assertFalse(g.estanConectados("a2", "a15"));

        lista.eliminarActoresParaPruebas();
        lista.cargarLista("FilmsActors20212022-50000-first-lines.txt");
        g=new GraphHash();
        g.crearGrafo(lista);

        //fichero grande
        //estan conectados
        assertTrue(g.estanConectados("Rodriquez, Michelle", "Devon, Tony"));
        //no estan conectados
        assertFalse(g.estanConectados("Devon, Tony", "Singh, Jaspal"));



    }

    @Test
    public void caminoTest(){
        lista.eliminarActoresParaPruebas();
        //lista de un elemento
        lista.anadirActor("pepe");
        lista.anadirPeliculaActor("buscando a nemo", 10f,"pepe");
        ArrayList<String> camino= g.camino("pepe", "pepe");
        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }
        lista.eliminarActor("pepe");
        
        lista.cargarLista("doc1.txt");
        g=new GraphHash();
        g.crearGrafo(lista);

        //no hay camino
        assertNull(g.camino("a2", "a20"));

        //hay camino
        //uno consigo
        camino= g.camino("a1", "a1");
        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }
        //a1, a5, a6, a17
        camino= g.camino("a1", "a17");
        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }
        //a1, a3
        camino= g.camino("a1", "a3");
        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }

        lista.eliminarActoresParaPruebas();
        lista.cargarLista("FilmsActors20212022-50000-first-lines.txt");
        g=new GraphHash();
        g.crearGrafo(lista);

        //fichero grande
        //hay camino
        assertNull(g.camino("Devon, Tony", "Singh, Jaspal"));
        //no hay camino
        camino=g.camino("Rodriquez, Michelle", "Devon, Tony");

        for(int i = 0; i < camino.size(); i++) {
            System.out.println(camino.get(i));
        }
    }
    @Test
    public void calcularTiempoTest(){
        lista.cargarLista("FilmsActors20212022-20000-first-lines.txt");
        Reloj miReloj = new Reloj();
        g.crearGrafo(lista);
        System.out.println(" Time (crearGrafo): " + miReloj.elapsedTime());

        miReloj = new Reloj();
        g.calcularConexiones(50);
        System.out.println(" Time (calcularConexiones(50)): " + miReloj.elapsedTime());
    }
}
