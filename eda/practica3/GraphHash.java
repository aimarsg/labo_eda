package eda.practica3;

import eda.Actor;
import eda.ListaActores;
import eda.Pelicula;


import java.sql.Array;
import java.util.*;

public class GraphHash {
    public HashMap<String, ArrayList<String>> g;
    public void anadirElemento(String e1, String e2){
        ArrayList<String > lista = g.get(e1);
        if (lista==null){
            lista=new ArrayList<String>();
            lista.add(e2);
            g.put(e1, lista);
        }
        else {
            lista.add(e2);
            g.put(e1, lista);
        }
    }
    public void anadirElemento(String e1, ArrayList<String> e2){
        g.put(e1, e2);
    }

    public GraphHash(){
        this.g = new HashMap<String, ArrayList<String>>();
    }

    public HashMap<String, ArrayList<String>> getG(){
        return this.g;
    }

    public void crearGrafo(ListaActores lActores) {

        // Post: crea el grafo desde la lista de actores
        // Los nodos son nombres de actores

        HashMap <String, Actor> lista=lActores.getTabla();
        HashMap <String, Pelicula> pelis;
        HashMap <String, Actor> actores;
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
            g.put(a,actor.devolverColegas());
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
        Queue<String> porExaminar = new LinkedList<String>();
        HashSet<String> examinados = new HashSet<String>();
        boolean enc = false;
        String act;
        porExaminar.add(a1);
        while (!porExaminar.isEmpty() && !enc){
            act = porExaminar.remove();
            if (!examinados.contains(act)) {//por si ya esta examinado
                if (act.equals(a2)) {
                    enc = true;
                } else {
                    examinados.add(act);
                    for (String colega : g.get(act)) {
                        porExaminar.add(colega);
                    }
                }
            }
        }
        return enc;
    }
    public ArrayList<String> camino(String a1, String a2){
        Queue<Tupla<String>> porExaminar = new LinkedList<>();
        HashSet<String> examinados = new HashSet<String>();
        porExaminar.add(new Tupla<>(a1, new ArrayList<>()));
        examinados.add(a1);
        boolean enc = false;
        Tupla<String> act=null;
        ArrayList lista;
        while (!porExaminar.isEmpty() && !enc){
            act = porExaminar.remove();
            if (act.e1.equals(a2)){
                enc=true;
                act.e2.add(a2);
            }else{
                lista = act.e2;
                lista.add(act.e1);
                for (String colega : g.get(act.e1)) {
                    if (!examinados.contains(colega)){
                        porExaminar.add(new Tupla<String>(colega, lista));
                        examinados.add(colega);
                    }
                }
            }
        }
        if (enc) return act.e2;
        else return null;
    }
    private class Tupla<T>{
        T e1;
        ArrayList<T> e2;
        Tupla(T elem1, ArrayList<T> lista){
            e1 = elem1;
            e2 = new ArrayList<T>(lista);

        }
    }

    public void calcularConexiones(int n){
        Random randomGenerator = new Random();
        Object[] a = g.keySet().toArray();

        for (int i = 1; i <= n; i++){
            int x = randomGenerator.nextInt(g.size());
            int y = randomGenerator.nextInt(g.size());
            System.out.println("Prueba: " + i + " ");
            estanConectados((String) a[x], (String) a[y]);
        }
    }

}
