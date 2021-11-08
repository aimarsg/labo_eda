package eda;

import java.lang.annotation.Inherited;
import java.util.HashMap;

public class Pelicula {
	private String titulo;
	private float recaudacion;
	private HashMap<String,Actor> actoresdePeli;
	//
	public Pelicula(String pTitulo, float pRecaudacion) {
		this.recaudacion=pRecaudacion;
		this.titulo=pTitulo;
		this.actoresdePeli=new  HashMap<String,Actor> ();
	}
	
	public void incrementarRecaudacion(float pCuanto) {
		this.recaudacion=this.recaudacion+pCuanto;}

	public boolean equals (Object pPelicula) {
		return(((Pelicula)pPelicula).titulo.equals(this.titulo));}
	
	public String getTitulo (){
		return (this.titulo);
	}
	public void imprimir(){
		System.out.print(this.titulo);
	}

	public float getRecaudacion() {
		return recaudacion;
	}
	//anadir actor
	public void anadirActor(Actor pActor){
		if (!this.actoresdePeli.containsKey(pActor.getNombre())){
			actoresdePeli.put(pActor.getNombre(), pActor);
		}
	}
	//eliminar actor
	public Actor eliminarActor (String pNombre){
		Actor actorEliminado;
		if (actoresdePeli.containsKey(pNombre)) {
			actorEliminado=actoresdePeli.get(pNombre);
			actoresdePeli.remove(pNombre);
			return (actorEliminado);
		}
		return null;
	}
	//get la lista de actores
	public HashMap<String,Actor> getActores(){
		return this.actoresdePeli;
	}
	//buscar actor
	/*public Actor buscarActor(String pNombre){
		if (actoresdePeli.containsKey(pNombre)){
			return (actoresdePeli.get(pNombre));
		}else{
			return null;
		}
	}*/

}
