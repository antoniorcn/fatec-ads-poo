package edu.aula8;

public class SP {

	public static void main(String[] args) {
		Idoso valdir = new Idoso("Valdir");
		Idoso neide = new Idoso("Neide");
		
		Empresario gabriel = new Empresario("Gabriel");
		Empresario roberto = new Empresario("Roberto");
		
		Jornal folha = new Jornal();
		Jornal estadao = new Jornal();
		
		folha.adicionar(valdir);
		estadao.adicionar(neide);
		folha.adicionar(roberto);
		estadao.adicionar(roberto);
		
		folha.publicar("Corinthians vence o Barcelona, no Cícero Pompeu de Toledo");
		estadao.publicar("Dolar bate R$ 5,0");
		
		

	}

}
