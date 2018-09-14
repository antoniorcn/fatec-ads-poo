package edu.aula6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class TestSet {
	public static void main(String[] args) {
		Set<String> conjunto = new HashSet<>();
		String a = "A";
		String b = "B";
		String c = "C";
		System.out.println(conjunto.add(c));
		System.out.println(conjunto.add(a));
		System.out.println(conjunto.add(b));
		System.out.println(conjunto.add(a));
		System.out.println(conjunto.size());
		conjunto.remove(a);
		System.out.println(conjunto.size());
		if (conjunto.contains(a)) { 
			System.out.println("Contem o A");
		} else { 
			System.out.println("Não Contem o A");
		}
		System.out.println("Elementos do Vetor");
		Iterator<String> it = conjunto.iterator();
		while (it.hasNext()) { 
			System.out.println( it.next() );
		}
	}
}
