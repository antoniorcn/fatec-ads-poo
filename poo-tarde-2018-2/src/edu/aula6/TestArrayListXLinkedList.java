package edu.aula6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestArrayListXLinkedList {

	public static void main(String[] args) {
		class Elemento { 
			int [] dados = new int[100];
			int numero;
		}
		
		List<Elemento> lista = new ArrayList<>();
//		List<Elemento> lista = new LinkedList<>();
		long inicio = System.currentTimeMillis();
		System.out.println("Inicio");
		Random rnd = new Random();
		for (int i=0; i < 1000000; i++) { 
			Elemento e = new Elemento();
			e.numero = rnd.nextInt();
			lista.add( e );
		}
		long termino = System.currentTimeMillis();
		System.out.println("Fim");
		long diff = termino - inicio;
		System.out.println("Demorou " + diff + " milesimos de segundos");

	}

}
