package edu.aula7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Aluno { 
	String nome;
	public Aluno(String nome) { 
		this.nome = nome;
	}
}

public class TesteMap {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Alexandre");
		Aluno a2 = new Aluno("Maria");
		Aluno a3 = new Aluno("Pedro");
		Aluno a4 = new Aluno("Camila");
		
		Map<String, Aluno> mapa = new HashMap<>();
		
		mapa.put("ALUNO1", a1);
		mapa.put("ALUNO2", a2);
		mapa.put("ALUNO3", a3);
		mapa.put("ALUNO4", a4);
		
		Aluno a = mapa.get("ALUNO2");
		System.out.println(a.nome);
		
		Set<String> conjunto = mapa.keySet();
		for (String nomeChave : conjunto) {
			System.out.print(nomeChave);
			Aluno valor = mapa.get(nomeChave);
			System.out.println(" - " + valor.nome);
		}
		
		Collection<Aluno> lista = mapa.values();
		for (Aluno aluno : lista) { 
			System.out.println("Nome do Aluno : " + aluno.nome);
		}		
	}

}
