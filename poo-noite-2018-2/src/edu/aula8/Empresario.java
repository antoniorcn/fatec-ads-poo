package edu.aula8;

public class Empresario implements Assinante {
	private String nome;
	
	public Empresario(String nome) {
		this.setNome(nome); 
	}
	
	@Override
	public void receberNoticia(String noticia) {
		System.out.println(nome + " tomando um café e lendo a noticia " + noticia);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
