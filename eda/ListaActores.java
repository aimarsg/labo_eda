package eda;
import eda.practica3.GraphHash;

import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class ListaActores {
	private static ListaActores miLista = null;
	private HashMap<String, Actor> tabla ;
	private ListaPeliculas listaPelis;

	private ListaActores() {
		this.tabla = new HashMap<String, Actor>();
		this.listaPelis= new ListaPeliculas();
	}

	public static ListaActores getMiLista() {
		if (ListaActores.miLista == null) {
			miLista = new ListaActores();
		}
		return (ListaActores.miLista);
	}

	public void anadirActor(String pNombre) {
		if (!this.tabla.containsKey(pNombre)){
			Actor pActor = new Actor(pNombre);
			tabla.put(pNombre, pActor);
		}else{
			System.out.println("El actor ya se encontraba en la lista.");
		}
	}

	public Actor eliminarActor(String pNombre) {
		Actor actorEliminado;
		if (tabla.containsKey(pNombre)) {
			actorEliminado=tabla.get(pNombre);
			tabla.remove(pNombre);
			//eliminar actor de las peliculas que lo contienen
			actorEliminado.getMiLista().eliminarActor(actorEliminado);
			return (actorEliminado);
		}
		return null;
	}

	public Actor buscarActor(String pNombre) {
		if (tabla.containsKey(pNombre)) {
			return (tabla.get(pNombre));
		}
		return null;
	}

	public Actor[] ordenarActores() {//Obtener una lista de actores ordenada por nombre y apellido
		Actor [] laTabla= this.tabla.values().toArray(new Actor[this.tabla.size()]);
		mergeSort(laTabla);

		//prueba para ver si se ha ordenado
		//for(Actor a : laTabla) {System.out.println(a.getNombre());}

		return (laTabla);
	}

	private void mergeSort(Actor[] laTabla){
		mergeSort(laTabla, 0, laTabla.length-1);
	}
	private void mergeSort (Actor[] tabla, int inicio, int fin){
		if ( inicio < fin ) { // hay más de un elemento en la tabla
			mergeSort(tabla, inicio, (inicio+fin)/2);
			mergeSort(tabla, ((inicio+fin)/2)+1, fin);
			mezcla(tabla, inicio, (inicio+fin)/2, fin);
		}

	}

	private void mezcla (Actor[] tabla, int i, int centro, int f){
		Actor[] laMezcla = (new Actor[f-i+1]);
		int izq = i;
		int der = centro+1;
		int k = 0; //indice para rellenar laMezcla
		while (izq <= centro && der <= f) {
			if (tabla[izq].compareTo(tabla[der]) <= 0) {
				laMezcla[k] = tabla[izq];
				k++;
				izq++;
			} else {
				laMezcla[k] = tabla[der];
				k++;
				der++;
			}
		}
		if (izq > centro) {
			while (der <= f) {
				laMezcla[k] = tabla[der];
				k++;
				der++;
			}
		}
		else {
			while (izq <= centro) {
				laMezcla[k] = tabla[izq];
				k++;
				izq++;
			}
		}
		for (int j = i; j <= f; j++)
			tabla[j] = laMezcla[j - i];
	}



	public void cargarLista(){

		try{
			String dirActual = System.getProperty("user.dir");
			String pathIn = dirActual + File.separator + "doc.txt";
			Scanner entrada = new Scanner(new FileReader(pathIn));
			String linea;

			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String[] partePeli = linea.split(" --->>> ");
				Pelicula unP=new Pelicula(partePeli[0],0);
				listaPelis.anadirPelicula(unP);
				if (partePeli.length>1) {
					String[] parteActores = partePeli[1].split(" ##### ");

					//meter Actores en la lista
					for (String a : parteActores) {
						Actor unA = this.buscarActor(a);
						if (unA == null) {
							unA = new Actor(a);
							tabla.put(a, unA);
						}
						unP.anadirActor(unA);
						unA.anadirPelicula(unP);
					}
				}
			}
			entrada.close();
		}
		//catch(IOException e) {e.printStackTrace();}
		catch (FileNotFoundException e){
			System.out.println("El archivo FilmsActors20212022.txt no se ha podido encontrar en la carpeta  "+System.getProperty("user.dir"));
			System.out.println("No se ha podido cargar la lista");}
	}
	public void anadirPeliculaActor(String pTitulo, Float pRecaudacion, String pActor){

		this.anadirActor(pActor);//se añade el actor, si ya esta no hace nada

		Pelicula p=this.listaPelis.buscarPelicula(pTitulo);
		if (p==null) {//la pelicula no existe
			p = new Pelicula(pTitulo, pRecaudacion);//se crea la pelicula y se añade
			this.listaPelis.anadirPelicula(p);
		}
		Actor a=this.buscarActor(pActor);
		a.anadirPelicula(p);//se añade la pelicula al actor dado

		p.anadirActor(a);//se añade el actor a la pelicula
	}
	public Pelicula eliminarPeli (String pTitulo){
		Pelicula p=this.buscarPelicula(pTitulo);
		if (p!=null){
			this.listaPelis.eliminarPeli(p);//se elimina de listapelis
			HashMap<String,Actor> actoresDePeli= p.getActores();
			for (String actor: actoresDePeli.keySet()){
				actoresDePeli.get(actor).eliminarPeli(p);//se elimina de los actores
			}

			/*Pelicula peliDeActor;
			for (String key: tabla.keySet()){
				peliDeActor=tabla.get(key).buscarPeli(pTitulo);
				if (peliDeActor!=null){
					tabla.get(key).eliminarPeli(peliDeActor);
				}
			}*/

		} return p;
	}

	public ListaPeliculas devolverPeliculasDeActor(String pActor){
		Actor actor= this.buscarActor(pActor);
		if (actor != null){
			return(actor.getMiLista());
		}
		else {
			return null;
		}
	}

	public Pelicula buscarPelicula (String pNombrePeli){
		return (this.listaPelis.buscarPelicula(pNombrePeli));
		/*for (String key: tabla.keySet()){
			Pelicula p=tabla.get(key).buscarPeli(pNombrePeli);
			if (p!=null){
				return p;
			}
		}
		return null;*/
	}

	public HashMap<String, Actor> devolverActoresDePeli(String pTitulo) {
		Pelicula p = this.listaPelis.buscarPelicula(pTitulo);
		if (p != null) {
			/*HashMap<String, Actor> listaActores = new HashMap<String, Actor>();
			Pelicula p;
			for (String actor : tabla.keySet()) {
				p = tabla.get(actor).buscarPeli(pTitulo);
				if (p != null) {
					listaActores.put(actor, this.tabla.get(actor));
				}
			}*/

			return (p.getActores());

		} else return null;

	}


	public void incrementarRecaudacion(String pTitulo, float pCantidad){
		Pelicula p= this.buscarPelicula(pTitulo);
		if(p != null){
			p.incrementarRecaudacion(pCantidad);
		}

	}

	public void guardarFichero(){
		this.listaPelis.guardarLista();

	}

	//metodo practica 3
	public GraphHash crearGrafo(){
		GraphHash grafo=new GraphHash();
		grafo.crearGrafo(this);
		return grafo;
	}
	public HashMap<String,Actor> getTabla(){
		return this.tabla;
	}

	public void eliminarActoresParaPruebas(){
		this.tabla = new HashMap<String, Actor>();
		this.listaPelis= new ListaPeliculas();
	}
	/*public int cuantasPelisParaPruebas(){
		return (this.listaPelis.getLength());
	}*/
	public int cuantosActoresParaPruebas(){
		return (this.tabla.size());
	}
}


