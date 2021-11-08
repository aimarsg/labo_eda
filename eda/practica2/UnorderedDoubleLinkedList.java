package eda.practica2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
		// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo= new Node<T>(elem);
		if (this.last==null){
			this.last=nuevo;
			nuevo.prev=nuevo;
			nuevo.next=nuevo;
		}else{
			last.next.prev=nuevo;
			nuevo.next=last.next;
			nuevo.prev=last;
			last.next=nuevo;
		}
		this.count++;
		//coste O(1) constante
	}

	public void addToRear(T elem) {
		// a�ade un elemento al final
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo= new Node<T>(elem);
		if (last==null){
			last=nuevo;
			nuevo.next=nuevo;
			nuevo.prev=nuevo;
		}
		else{
			last.next.prev= nuevo;
			nuevo.next=last.next;
			last.next=nuevo;
			nuevo.prev=last;
			last=nuevo;
		}
		this.count++;
		//coste O(1) constante
	}
	
	public void addAfter(T elem, T target) {
		// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
		// Pre: target se encuentra en la lista
		Node<T> anadir = new Node<T>(elem);
		Node<T> act = this.last;
		while (!act.data.equals(target)){
			act=act.next;
		}
		if (act==this.last){
			this.last=anadir;
		}
		act.next.prev = anadir;
		anadir.next = act.next;
		act.next = anadir;
		anadir.prev=act;
		this.count++;
		//O(n) siendo n el numero de elementos de la lista
	}

}
