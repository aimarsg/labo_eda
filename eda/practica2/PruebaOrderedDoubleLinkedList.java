package eda.practica2;

public class PruebaOrderedDoubleLinkedList {	
		
		public static void main(String[] args)  {
			
			OrderedDoubleLinkedList<Integer> l = new OrderedDoubleLinkedList<Integer>();
			//lista vacia
			l.add(1);
			System.out.println(" Lista ...............");
			l.visualizarNodos();
			//lista de 1 elemento
			l.add(3);//añadir al final
			System.out.println(" Lista ...............");
			l.visualizarNodos();
			l.remove(3);
			l.add(0);//añadir al principio
			System.out.println(" Lista ...............");
			l.visualizarNodos();
			//lista varios elementos
			//añadir al final
			l.add(6);
			l.add(7);
			l.add(9);
			l.remove(0);
			//añadir al principio
			l.add(0);
			//añadir por la mitad
			l.add(8);
			System.out.println(" Lista ...............");
			l.visualizarNodos();
			System.out.println(" Num elementos: " + l.size());
					
			
			System.out.println("Prueba Find ...............");
			System.out.println("20? " + l.find(20));
			System.out.println("9? " + l.find(9));
			System.out.println("9? " + l.find(9));
			System.out.println("0? " + l.find(0));
			System.out.println("7? " + l.find(7));
			
			
			
			OrderedDoubleLinkedList<Persona> l2 = new OrderedDoubleLinkedList<Persona>();
			l2.add(new Persona("jon", "1111"));
			l2.add(new Persona("ana", "7777"));
			l2.add(new Persona("amaia", "3333"));
			l2.add(new Persona("unai", "8888"));
			l2.add(new Persona("pedro", "2222"));
			l2.add(new Persona("olatz", "5555"));

			l2.remove(new Persona("", "8888"));

			
			System.out.print(" Lista ...............");
			l2.visualizarNodos();
			System.out.println(" Num elementos: " + l2.size());
					
			
			System.out.println("Prueba Find ...............");
			System.out.println("2222? " + l2.find(new Persona("", "2222")));
			System.out.println("5555? " + l2.find(new Persona("", "5555")));
			System.out.println("7777? " + l2.find(new Persona("", "7777")));	
			System.out.println("8888? " + l2.find(new Persona("", "8888")));	
			
			//prueba del merge
			//las dos listas vacias
			OrderedDoubleLinkedList<Integer> lista1=new OrderedDoubleLinkedList<>();
			OrderedDoubleLinkedList<Integer> lista2=new OrderedDoubleLinkedList<>();
			System.out.println("lista vacia");
			lista1.merge(lista2);
			lista1.visualizarNodos();
			//una lista vacia y la otra no
			lista1.add(2);
			lista1.add(4);
			lista1.add(1);
			lista1.add(6);
			lista1.add(20);
			System.out.println("lista 1,2,4,6,20");
			lista1.merge(lista2);
			lista1.visualizarNodos();
			System.out.println("lista 1,2,4,6,20");
			lista2.merge(lista1);
			lista2.visualizarNodos();
			//listas no vacias
			lista2=new OrderedDoubleLinkedList<>();
			lista2.add(3);
			lista2.add(12);
			lista2.add(5);
			lista2.add(0);
			lista2.add(4);
			lista2.add(32);
			lista2.add(34);
			lista2.add(7);

			System.out.println("lista 0,1,2,3,4,4,5,6,7,12,20,32,34");
			lista1.merge(lista2);
			lista1.visualizarNodos();

			OrderedDoubleLinkedList<Integer> lista12=new OrderedDoubleLinkedList<>();
			lista12.add(2);
			lista12.add(4);
			lista12.add(1);
			lista12.add(6);
			lista12.add(20);
			System.out.println("lista 0,1,2,3,4,4,5,6,7,12,20,32,34");
			lista2.merge(lista12);
			lista2.visualizarNodos();
	}
	}

