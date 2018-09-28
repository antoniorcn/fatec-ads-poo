package edu.aula7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class TesteSet {

	public static void main(String[] args) {
		Set<String> conjunto = new HashSet<>();
		
		conjunto.add("Um");
		conjunto.add("Dois");
		conjunto.add("Três");
		conjunto.add("Quatro");
		conjunto.add("Cinco");
		
		if (conjunto.contains("Seis")) { 
			System.out.println("Contém");
		} else { 
			System.out.println("Não Contém");
		}
			
		/*Iterator<String> it = conjunto.iterator();

		while( it.hasNext() ) {
			String e = it.next();
			System.out.println( e );
		}*/
		
		//Stream<String> maiusc = conjunto.stream().map(a -> ("123" + a.toUpperCase()));
		//Stream<String> filtrado = maiusc.filter(a -> (a.contains("U")));
		
		for ( String e : conjunto ) { 
			System.out.println( e );
		}
				

	}

}
