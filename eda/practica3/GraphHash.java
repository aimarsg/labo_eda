package eda.practica3;

import eda.Actor;
import eda.ListaActores;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphHash {
    HashMap<String, ArrayList<String>> g;

    public void crearGrafo(ListaActores lActores) {

        // Post: crea el grafo desde la lista de actores
        // Los nodos son nombres de actores

        // COMPLETAR CÓDIGO
        HashMap<String, Actor> lista=lActores.getTabla();
        HashMap<>
        Actor actor;
        for (String a:lista.keySet()){
            actor=lista.get(a);

        }

    }
    public void print(){
        int i = 1;
        for (String s: g.keySet()){
            System.out.print("Element: " + i++ + " " + s + " --> ");
            for (String k: g.get(s)){
                System.out.print(k + " ### ");
            }
            System.out.println();
        }
    }
    public boolean estanConectados(String a1, String a2)
    // COMPLETAR CÓDIGO
}
