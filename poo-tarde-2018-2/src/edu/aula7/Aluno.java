package edu.aula7;

public class Aluno implements Assinante {
	
	private String nome;

	public Aluno(String nome) { 
		this.nome = nome;
	}
	
	public void estudar() { 
		System.out.println("Estudando");
	}

	@Override
	public void recebeNoticia(String noticia) {
		System.out.println("Aluno " + this.nome + 
				" esta lendo a noticia " + noticia + " no intervalo da aula.");
	}

}
