package edu.aula7;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if (o1.contains("Terceiro")) { 
					return -1;
				} else { 
					return 1;
				}
			}	
		}; 
		Queue<String> fila = new PriorityQueue<>(comparator);
		
		fila.add("Primeiro");
		fila.add("Segundo");
		fila.add("Terceiro");
		fila.add("Quarto");

		System.out.println("Fila tem " + fila.size() + " elementos");
		String e = fila.peek();
		System.out.println( e );
		System.out.println("Fila tem " + fila.size() + " elementos");
		/*		
 		e = fila.poll();
		System.out.println( e );
		e = fila.poll();
		System.out.println( e );
		
		*/	
		
		for (String elemento : fila) { 
			System.out.println(elemento);
		}

	}

}
