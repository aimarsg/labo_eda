package eda.practica2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> eliminado=null;
		if (this.last==null){return null;
		}
		else{
			if (count==1){
				eliminado=last;
				this.last=null;
				this.count--;

			}
			else{
				eliminado=last.next;
				last.next.next.prev=last;
				last.next=last.next.next;

				this.count--;

			}
		}
		return eliminado.data;
		// COSTE CONSTANTE
	}

	public T removeLast() {
		// Elimina el �ltimo elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if (this.last!=null){
			Node<T> temp=this.last;
			if (count==1){
				this.last=null;
			}else{
				this.last.prev.next=this.last.next;
				this.last.next.prev=this.last.prev;
				last=last.prev;
			}
			count--;
			return (temp.data);
		}
		else return null;
		//Coste: O(1) coste constante
	}


	public T remove(T elem) {
		if (this.isEmpty() || !this.contains(elem)) {
			return null;
		} else {
			if (count ==1){
				count=0;
				last=null;
				return elem;
			}else {
				Node<T> act = this.last;
				if (act.data.equals(elem)) {
					this.last = act.prev;
				} else {
					while (!act.data.equals(elem)) {
						act = act.next;
					}
				}
				act.prev.next = act.next;
				act.next.prev = act.prev;
				this.count--;

				return act.data;
			}
			//Elimina un elemento concreto de la lista
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
			//O(n) para siendo n igual al numero de elementos de la lista
		}
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		if (isEmpty()) return false;
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		else{
			boolean enc=false;
			Node<T> act=this.last;
			int cont=1;
			while (cont<=this.count && !enc){

				if (act.data.equals(elem)){

					enc=true;
				}else{
					act=act.next;
					cont++;
				}
			}
			return(enc);
		}
		//Coste: O(n), coste lineal, siendo n el numero de elementos de la lista
	}

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if (contains(elem)){

			Node<T> act = this.last;
			while(!act.data.equals(elem)){
				act = act.next;
			}
			return act.data;
		}else { return null;}
		//O(n) siendo n igual al numero de elementos de la lista
	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return last == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {
		   private Node<T> act;
		   private int cont=0;
		   //constructora
		   public ListIterator(){
			   if (last!=null){
				   act=last.next;
			   }
		   }

		   // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		   public boolean hasNext(){
			   return (this.cont<count);
			   //coste O(1) costante
		   }

		   public T next () {
			   if (!hasNext()) throw new NoSuchElementException();

			   act = act.next;
			   this.cont++;
			   T elem = act.prev.data;
			   return elem;
			   // coste O(1) constante
		   }


		} // private class


         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}

}
