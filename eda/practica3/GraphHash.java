package eda.practica3;

import eda.Actor;
import eda.ListaActores;
import eda.Pelicula;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphHash {
    HashMap<String, ArrayList<String>> g;

    public void crearGrafo(ListaActores lActores) {

        // Post: crea el grafo desde la lista de actores
        // Los nodos son nombres de actores

        // COMPLETAR CÓDIGO
        HashMap<String, Actor> lista=lActores.getTabla();
        HashMap<String, Pelicula> pelis;
        HashMap<String, Actor> actores;
        Actor actor;
        Pelicula peli;
        for (String a:lista.keySet()){
            actor=lista.get(a);
            pelis=actor.getMiLista().getTabla();
            for (String p:pelis.keySet()){
                peli=pelis.get(p);
                actores=peli.getActores();
                for (String actorDePeli:actores.keySet()){
                    actor.anadirColega(actores.get(actorDePeli));
                }
            }
            //pasar arraylist y eso
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
    public boolean estanConectados(String a1, String a2){

    }
    // COMPLETAR CÓDIGO
}
