package edu.aula3;

public class Aluno {

	String nome;
	String ra;
	
	public Aluno() { 
		nome = "<sem nome>";
		ra = "000";
	}
	
	public Aluno(String nome) { 
		this.nome = nome;
	}
	
	public void imprimir() { 
		System.out.println("Ra : " + ra + "  Nome : " + nome);
	}
}
