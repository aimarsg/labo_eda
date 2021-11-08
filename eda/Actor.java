package eda;

import eda.practica2.ListaPeliculas;

public class Actor implements Comparable<Actor> {
	
	private String nombre;
	private ListaPeliculas lista;
	//private int edad;

	public Actor(String pNombre/*, int pEdad*/) {
		this.nombre = pNombre;
		//this.edad = pEdad;
		this.lista = new ListaPeliculas();
	}
	
	public Pelicula buscarPeli(String pPeli) {		
		return (this.lista.buscarPelicula(pPeli));
	}
	
	public String getNombre() {
		return (this.nombre);
	}
	
	public ListaPeliculas getMiLista() {
		return (this.lista);
	}
	
	/*public int getEdad() {
		return (this.edad);
	}*/
	
	public void anadirPelicula(Pelicula pPelicula) {
		if(this.buscarPeli(pPelicula.getTitulo())==null) {
			this.lista.anadirPelicula(pPelicula);
		}
	}

	public int compareTo(Actor pActor) {
		return(this.nombre.compareTo(pActor.nombre));
		// 1 si lo de las parentesis es mas cercano a "a"
		// 0 si son iguales
		// -1 si lo de las parentesis es mas cercano a "z"
	}

	public void eliminarPeli(Pelicula pPeli){

		this.lista.eliminarPeli(pPeli);

	}


}
