package eda.practica2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class PruebaDoubleLinkedList {
	
	public void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	@Test
	public void pruebaDoubleLinkedList() {

		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();
		assertEquals(l.size(), 0);
		l.addToRear(1);//lista vacia
		assertEquals(l.size(), 1);
		l.addToRear(3);//lista 1 elemento
		assertEquals(l.size(), 2);
		l.addToRear(6);
		l.addToRear(7);
		assertEquals(l.last(), 7);//para comprobar que se esta añadiendo al final
		l.addToRear(20);
		assertEquals(l.last(), 20);//para comprobar que se esta añadiendo al final
		assertEquals(l.size(), 5);
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());

		assertEquals(l.removeLast(),20);

		assertFalse(l.contains(20));
		visualizarNodos(l);
		assertNull(l.find(20));

		assertEquals(l.find(1),1);
		assertTrue(l.contains(7));
		assertFalse(l.contains(33));
		assertEquals(l.find(6),6);
		assertEquals(l.find(30),null);

		assertFalse(l.isEmpty());
		assertEquals(l.removeLast(),7);
		assertEquals(l.removeLast(),6);
		assertEquals(l.removeLast(),3);

		assertFalse(l.contains(33));//lista 1 elemento
		assertTrue(l.contains(1));
		assertEquals(l.find(33),null);//lista 1 elento
		assertEquals(l.find(1), 1);
		assertEquals(l.removeLast(),1);//lista 1 elemento
		assertEquals(l.removeLast(),null);//lista vacia
		assertTrue(l.isEmpty());
		assertEquals(l.find(22), null);//lista vacia
		assertFalse(l.contains(2220));//lista vacia

		//lista vacia
		assertNull(l.remove(2));

		l.addToFront(0);
		//lista de 1 elemento
		assertNull(l.remove(2));
		assertEquals(l.remove(0),0);
		l.addToFront(0);
		//lista varios elementos
		l.addAfter(1,0);//lista 1 elemento
		assertNull(l.remove(3));

		l.addAfter(2,1);
		assertEquals(l.remove(2),2);
		l.addAfter(3,1);
		l.addAfter(4,3);

		l.addAfter(5,1);
		l.addAfter(6,0);
		l.remove(3);

		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());


		l = new UnorderedDoubleLinkedList<Integer>();
		//lista vacia
		assertEquals(l.size(), 0);
		assertEquals(l.first(),null);
		assertEquals(l.last(),null);

		//lista 1 elemento
		l.addToFront(1);//
		assertEquals(l.first(),1);
		assertEquals(l.last(),1);
		assertEquals(l.size(), 1);

		//lista no vacia
		assertEquals(l.size(), 1);
		l.addToFront(2);
		l.addToFront(3);
		l.addToFront(4);
		assertEquals(l.size(), 4);

		assertEquals(l.first(),4);
		assertEquals(l.last(),1);
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
		//remove first
		assertEquals(l.removeFirst(),4);//varios elementos
		assertEquals(l.removeFirst(),3);
		assertEquals(l.removeFirst(),2);
		assertEquals(l.removeFirst(),1); //un elemento
		assertEquals(l.removeFirst(),null); //lista vacia


		//prueba iterador
		//lista vacia
		Iterator<Integer> itr= l.iterator();
		assertEquals(itr.hasNext(),false);

		//lista 1 elemento
		l.addToRear(1);
		itr= l.iterator();
		assertEquals(itr.hasNext(),true);
		assertEquals(itr.next(),1);
		assertEquals(itr.hasNext(),false);
		visualizarNodos(l);

		//lista varios elementos
		l.addToRear(2);
		l.addToRear(3);
		l.addToRear(4);

		visualizarNodos(l);

		itr= l.iterator();
		assertEquals(itr.hasNext(),true);
		assertEquals(itr.next(),1);
		assertEquals(itr.next(),2);
		assertEquals(itr.next(),3);
		assertEquals(itr.next(),4);
		assertEquals(itr.hasNext(),false);

		visualizarNodos(l);
	}


}
