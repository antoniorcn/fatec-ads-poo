package edu.aula7;

public class TesteObserver {

	public static void main(String[] args) {
		Jornal jornalFatec = new Jornal();
		Jornal gazeta = new Jornal();
		
		Medico m1 = new Medico();
		Medico m2 = new Medico();
		Aluno a1 = new Aluno("João");
		Aluno a2 = new Aluno("Maria");
		
		jornalFatec.cadastrarAssinante( a1 );
		jornalFatec.cadastrarAssinante( a2 );
		jornalFatec.cadastrarAssinante( m1 );
		
		gazeta.cadastrarAssinante( m2 );
		gazeta.cadastrarAssinante( a1 );
		
		jornalFatec.divulgarNoticia("Abertas inscrições para o vestibular 2019");
		gazeta.divulgarNoticia("Debate dos presidenciaveis foi transferido para Curitiba");
	}

}
