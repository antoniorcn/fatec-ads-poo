package edu.aula7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteList {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("Um");
		lista.add("Dois");
		lista.add("Três");
		lista.add("Quatro");
		lista.add("Cinco");
		
		// System.out.println( lista.get(3) );
		
		System.out.println("A lista tem " + lista.size() + " elementos");
		lista.remove("Três");
		System.out.println("A lista tem " + lista.size() + " elementos");
		
		/*
	 	for (String e : lista) { 
			System.out.println( e );
		}
		*/
		
		mostraLista(lista);


	}
	
	public static void mostraLista(List<String> l) { 
		Iterator<String> it = l.iterator();
		
		while(it.hasNext()) { 
			String e = it.next();
			System.out.println( e );
			
		}
	}

}
