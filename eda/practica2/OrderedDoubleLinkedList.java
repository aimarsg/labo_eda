package eda.practica2;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {

	public void add(T elem) {
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> anadir = new Node<>(elem);
		if (last == null) {
			anadir.next = anadir;
			anadir.prev = anadir;
			last = anadir;
		} else {
			Node<T> act = this.last.next;
			boolean enc = false;
			int cont = this.count;
			while (cont > 0 && !enc) {
				if (elem.compareTo(act.data) < 0) {
					enc = true;
				} else {
					act = act.next;
					cont--;
				}
			}
			if (enc) {
				//anadir antes de act
				act.prev.next = anadir;
				anadir.prev = act.prev;
				anadir.next = act;
				act.prev = anadir;
			} else {
				//anadir al final
				anadir.next = last.next;
				anadir.prev = last;
				last.next.prev = anadir;
				last.next = anadir;
				last = anadir;
			}
		}
		count++;
	} //COSTE: El coste es lineal ya que en el peor de los casos lo añades al final si es el mas grande de la lista.
		// O(n) siendo n el numero de elementos de la lista

	// -1 si lo de las parentesis es mas grande
	// 0 si son iguales
	// 1 si lo de las parentesis es mas pequeño
	public void merge(DoubleLinkedList<T> lista){
		//pre: lista es una lista ordenada
		//coste O(m+n) siendo m y n las longitudes de las dos listas
		if (last==null){
			last=lista.last;
			this.count=lista.count;
		}else{
			if (lista.last!=null) {
				Node<T> act = this.last.next;
				Node<T> actL = lista.last.next;
				Node<T> anadir= new Node<T>(actL.data);
				int contAct = 0;
				int contL = 0;
				while (contL<lista.count && contAct < this.count) {
					if (anadir.data.compareTo(act.data) < 0) {
						//poner anadir antes de act
						act.prev.next = anadir;
						anadir.prev = act.prev;
						anadir.next = act;
						act.prev = anadir;
						actL = actL.next;
						anadir = new Node<T>(actL.data);
						count++;
						contL++;

					} else {
						act=act.next;
						contAct++;
					}

				}
				while (contL<lista.count) {
					//anadir todas al final
					anadir.next = last.next;
					anadir.prev = last;
					last.next.prev = anadir;
					last.next = anadir;
					last = anadir;
					actL=actL.next;
					anadir=new Node<>(actL.data);
					contL++;
					count++;
				}
			}else{}
		}


	}


}
