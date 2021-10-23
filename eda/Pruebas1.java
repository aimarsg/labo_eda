package eda;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;

public class Pruebas1 {


    public static void cargarLista1(String nomF){
        try{
            Scanner entrada = new Scanner(new FileReader(nomF));

            String linea;
            //ArrayList<String> listaPeliculas;
            //ArrayList<String> listaActores;


            HashMap<String, Actor> tablaActores = new HashMap <String, Actor> ();
            HashMap<String, Pelicula> tablaPelis = new HashMap <String, Pelicula> ();


            //listaPeliculas= new ArrayList<String>();
            //listaActores= new ArrayList<String>();
            int i=0;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String[] partePeli = linea.split("--->>>");
                //System.out.println("Pelicula: " + partes[0]);
                //System.out.println("Actores: " + partes[1]);

                //añadir peliculas al array de peliculas;

                Pelicula unP=new Pelicula(partePeli[0],0);
                tablaPelis.put(partePeli[0], unP);


                //listaPeliculas.add(partePeli[0]);
                //i++;
                //System.out.println("Lista de Peliculas():"+ i  + listaPeliculas);
                String[] parteActores = partePeli[1].split("#####");
                //meter Actores en la lista
                for(String a: parteActores) {
                    if (!tablaActores.containsKey(a)){
                        Actor unA=new Actor(a);
                        tablaActores.put(a,unA);
                    }
                    /*boolean b = listaActores.contains(a);
                    if (!listaActores.contains(a)) {
                        listaActores.add(a);
                    }*/
                }


            }
            entrada.close();

            //Escribir listas
            //System.out.println("Lista de Peliculas:" + listaPeliculas);
            //System.out.println("Lista de Actores:" + listaActores);
            //String actor = listaActores.get(0);
            //System.out.println(actor);
            System.out.println(tablaPelis);
            System.out.println(tablaActores);
        }
        catch(IOException e) {e.printStackTrace();}
    }

    public static void cargarLista2(String nomF){
        try{
            Scanner entrada = new Scanner(new FileReader(nomF));

            String linea;
            ArrayList<String> listaPeliculas;
            ArrayList<String> listaActores;

            listaPeliculas= new ArrayList<String>();
            listaActores= new ArrayList<String>();
            int i=0;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String[] partePeli = linea.split("--->>>");
                //System.out.println("Pelicula: " + partes[0]);
                //System.out.println("Actores: " + partes[1]);

                //añadir peliculas al array de peliculas;
                listaPeliculas.add(partePeli[0]);
                i++;
                System.out.println("Lista de Peliculas():"+ i  + listaPeliculas);
                String[] parteActores = partePeli[1].split("#####");
                //meter Actores en la lista
                for(String a: parteActores) {
                    boolean b = listaActores.contains(a);
                    if (!listaActores.contains(a)) {
                        listaActores.add(a);
                    }
                }


            }
            entrada.close();

            //Escribir listas
            System.out.println("Lista de Peliculas:" + listaPeliculas);
            System.out.println("Lista de Actores:" + listaActores);
            String actor = listaActores.get(0);
            System.out.println(actor);
        }
        catch(IOException e) {e.printStackTrace();}
    }


}
