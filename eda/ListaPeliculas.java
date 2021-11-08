package eda;

import eda.practica2.UnorderedDoubleLinkedList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

public class ListaPeliculas {
	
	//private ArrayList<Pelicula> lista;
	//private HashMap<String, Pelicula> tabla;
	private UnorderedDoubleLinkedList<Pelicula> lista;
	public ListaPeliculas() {
		//this.tabla= new HashMap<String, Pelicula>();
		this.lista=new UnorderedDoubleLinkedList<Pelicula>();
	}

	public int getLength(){
		return (tabla.size());
	}//para pruebas

	
	
	/*private Iterator<Pelicula> getIterator() {
		return (tabla.iterator());
	}*/
	
	public void anadirPelicula(Pelicula pPeli) {
		this.lista.addToRear(pPeli);
		//this.tabla.put(pPeli.getTitulo(),pPeli);
	}
	
	public Pelicula buscarPelicula(String pTitulo) {
		return(this.tabla.get(pTitulo));
	}
	
	public boolean esta(Pelicula pPelicula) {
		//return (this.tabla.containsValue(pPelicula));
		return(this.lista.contains(pPelicula));
	}

	public void imprimirLista(){
		Pelicula p=null;
		//for (String key : tabla.keySet()){
		Iterator<Pelicula> itr=this.lista.iterator();
		while (itr.hasNext()){
			//p= this.tabla.get(key);
			p=itr.next();
			p.imprimir();
			System.out.print(", ");
		}
	}
	public void eliminarPeli(Pelicula p){
		this.tabla.remove(p.getTitulo());
	}

	public void guardarLista(){
		try{
			String dirActual = System.getProperty("user.dir");
			String pathOut = dirActual + File.separator + "ficheroGuardado.txt";

			FileWriter fichero = null;
			PrintWriter pw = null;
			fichero = new FileWriter(pathOut, true);
			pw = new PrintWriter(fichero);

			//for(String titulo: tabla.keySet()) {
			Iterator<Pelicula> itr=this.lista.iterator();
			Pelicula p;
			while (itr.hasNext()){
				p=itr.next();
				pw.print(p.getTitulo() + " --->>> ");
				String imprimir="";
				boolean primero=true;
				HashMap<String, Actor> listaActores=p.getActores();
				for(String nombre: listaActores.keySet()) {
					if(!primero) {
						imprimir=imprimir+" ##### " + nombre;
					}else{
						imprimir=nombre;
						primero=false;
					}

				}
				pw.println(imprimir);
			}
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void eliminarActor(Actor pActor){//eliminar un actor de todas las peliculas de la lista
		for (String key: tabla.keySet()){
			tabla.get(key).eliminarActor(pActor.getNombre());
		}
	}
	
}
