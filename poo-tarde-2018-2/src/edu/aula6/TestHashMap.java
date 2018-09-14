package edu.aula6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
	
		Map<String, Integer> map = new HashMap<>();
		
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		Integer i3 = new Integer(3);
		Integer i4 = new Integer(4);
		
		map.put("um", i1);
		map.put("dois", i2);
		map.put("tres", i3);
		map.put("quatro", i4);
		
		System.out.println( map.get("tres") );
		
		System.out.println("Chaves :");
		Set<String> chaves = map.keySet();
		Iterator<String> it = chaves.iterator();
		
		String texto = "Fulano vendeu quatro biscoitos para"
				+ " João que comeu dois e deixou um para Maria";
		
		while(it.hasNext()) { 
			String chave = it.next();
			Integer valor = map.get(chave);
			System.out.printf("\nChave: %s   Valor:%d", 
					chave, valor);
			texto = texto.replace(chave, String.valueOf(valor));
		}
		System.out.println("\n" + texto);
		
	}
}
