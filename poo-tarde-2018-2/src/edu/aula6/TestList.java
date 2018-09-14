package edu.aula6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestList {

	public static void main(String[] args) {
		List<String> lista = new Vector<>();
		System.out.println(lista.add("C"));
		System.out.println(lista.add("A"));
		System.out.println(lista.add("B"));
		System.out.println(lista.add("D"));
		System.out.println(lista.add("A"));
		System.out.println("Tamanho da lista : " 
		    + lista.size());	
		lista.remove("A");
		
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i));
//		}
		
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) { 
			System.out.println(it.next());
		}
		
		System.out.println("Tamanho da lista : " 
			    + lista.size());	
		
		
	}

}
