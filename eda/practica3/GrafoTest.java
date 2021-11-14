package eda.practica3;
import eda.Actor;
import eda.ListaActores;
import eda.Pelicula;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        g.print();

    }
    public void estanConectadosTest(){
        g.crearGrafo(lista);
        assertTrue(g.estanConectados("a1", "a2"));
        assertFalse(g.estanConectados("a2", "a10"));

    }
}
