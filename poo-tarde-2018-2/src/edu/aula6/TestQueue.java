package edu.aula6;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<String> queue = new PriorityQueue<>();
		
		queue.add("Primeiro");
		queue.add("Segundo");
		queue.add("Terceiro");
		queue.add("Quarto");
		queue.add("Quinto");
		System.out.println("Tamanho : " + queue.size());
		System.out.println(queue.poll());
		System.out.println("Tamanho : " + queue.size());
		
		Iterator<String> it = queue.iterator();
		while (it.hasNext()) { 
			System.out.println( it.next() );
		}
		
	}

}

