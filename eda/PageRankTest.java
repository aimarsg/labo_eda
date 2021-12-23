package eda;

import eda.ListaActores;
import eda.practica3.GraphHash;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PageRankTest {

    @BeforeEach
    public void setUp() {



    }
    @AfterEach
    public void tierDown() {

    }
    @Test
    public void pageRankTest() {
        GraphHash g= new GraphHash();
        ListaActores lista = ListaActores.getMiLista();
        //casos de prueba
        //grafo vacio
        lista.pageRank(g);
        //un unico elemento
        g.anadirElemento("a1", new ArrayList<String>());
        lista.pageRank(g);
        //dos elementos
        // los dos conectados-> se acaba tras una iteracion
        g.anadirElemento("a1", "a2");
        g.anadirElemento("a2", "a1");
        ListaActores.getMiLista().pageRank(g);
        //solo una conexion
        g= new GraphHash();
        g.anadirElemento("a1", "a2");
        g.anadirElemento("a2", new ArrayList<>());
        ListaActores.getMiLista().pageRank(g);


        //varios elementos
        lista.cargarLista("doc2.txt");
        lista.pageRank();

        //lista de 20.000
        lista.eliminarActoresParaPruebas();
        lista.cargarLista("FilmsActors20212022-20000-first-lines.txt");
        Reloj reloj = new Reloj();
        ListaActores.getMiLista().pageRank();
        System.out.println(reloj.elapsedTime()+ " tiempo transcurrido");
    }
    @Test
    public void ordenarTest(){

        GraphHash g= new GraphHash();
        ListaActores lista = ListaActores.getMiLista();
        lista.eliminarActoresParaPruebas();

        //grafo vacio
        ArrayList<Par> ordenado = lista.ordenarPorPageRank(new ArrayList<>(),g);
        for(Par p: ordenado){
            System.out.println(p.actor + ":" + p.pageRank);
        }
        //grafo de un elemento
        g.anadirElemento("a", new ArrayList<>());
        ArrayList<String> lis= new ArrayList<>();
        lis.add("a");
        ordenado = lista.ordenarPorPageRank(lis,g);
        for(Par p: ordenado){
            System.out.println(p.actor + ":" + p.pageRank);
        }

        //varios elementos
        String[] l= {"a", "b", "c", "d", "e"};
        ArrayList<String> actores = new ArrayList<String>(List.of(l));
        lista.cargarLista("doc2.txt");
        ordenado= ListaActores.getMiLista().ordenarPorPageRank(actores);
        for(Par p: ordenado){
            System.out.println(p.actor + ":" + p.pageRank);
        }
        lista.eliminarActoresParaPruebas();
        lista.cargarLista("FilmsActors20212022-20000-first-lines.txt");

        actores = new ArrayList<String>();
        actores.add("Daugherty, Joseph");
        actores.add("Doctor, Roxy");
        actores.add("Hunter, Kirk (I)");
        actores.add("Nakache, G raldine");
        actores.add("Shin, Se-Kyung");
        Reloj reloj = new Reloj();
        ordenado= ListaActores.getMiLista().ordenarPorPageRank(actores);
        System.out.println(reloj.elapsedTime()+ " tiempo transcurrido");
        for(Par p: ordenado){
            System.out.println(p.actor + ":" + p.pageRank);
        }
    }
}
