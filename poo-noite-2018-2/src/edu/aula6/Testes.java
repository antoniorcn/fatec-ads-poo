package edu.aula6;

public class Testes {
	public static void main(String[] args) {
		EstudanteADS ads = new EstudanteADS();
		EstudanteComex comex = new EstudanteComex();
		EstudanteMaster master = new EstudanteMaster();
		
		System.out.println("Campeonato de Basquete");
		CampeonatoBasqueteFatec champ = 
				new CampeonatoBasqueteFatec();
		System.out.println("Entrevista 1");
		champ.inscricao( master );
		
		System.out.println("InterFatecs");
		InterFatec inter = new InterFatec();
		System.out.println("Entrevista 1");
		inter.inscricao(ads);
		System.out.println("Entrevista 2");
		inter.inscricao(comex);
		System.out.println("Entrevista 3");
		inter.inscricao(master);
	}
}
