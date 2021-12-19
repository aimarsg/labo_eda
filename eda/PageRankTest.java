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
        ListaActores.getMiLista().pageRank("doc2.txt");

    }
    @Test
    public void ordenarTest(){
        String[] l= {"a", "b", "c", "d", "e"};
        ArrayList<String> lista = new ArrayList<String>(List.of(l));
        ArrayList<Par> ordenado= ListaActores.getMiLista().ordenarPorPageRank(lista , "doc2.txt");

        for(Par p: ordenado){
            System.out.println(p.actor + ":" + p.pageRank);
        }
    }
}
