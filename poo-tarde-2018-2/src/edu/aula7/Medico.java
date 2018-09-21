package edu.aula7;

public class Medico implements Assinante {
	
	void fazerCirurgia() { 
		System.out.println("Fazendo cirurgia");
	}

	@Override
	public void recebeNoticia(String noticia) {
		System.out.println("Lendo " + noticia + " na sala de operação");
	}
}
