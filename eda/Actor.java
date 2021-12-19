package eda;


import java.util.ArrayList;
import java.util.HashMap;

public class Actor implements Comparable<Actor> {
	
	private String nombre;
	private ListaPeliculas lista;
	private HashMap<String, Actor> colegas ;
	double pageRank;
	//private int edad;

	public Actor(String pNombre/*, int pEdad*/) {
		this.nombre = pNombre;
		//this.edad = pEdad;
		this.lista = new ListaPeliculas();
		this.colegas=new HashMap<>();
		this.pageRank=0.0;
	}

	public void anadirColega(Actor pActor){
		//post: se añade el colega solo si no esta y si no es el propio actor
		if (!colegas.containsKey(pActor.getNombre()) && !pActor.getNombre().equals(this.nombre)){
			this.colegas.put(pActor.nombre, pActor);
		}

	}
	public ArrayList<String> devolverColegas(){
		ArrayList<String> lista=new ArrayList<>(this.colegas.keySet());
		return (lista);
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
