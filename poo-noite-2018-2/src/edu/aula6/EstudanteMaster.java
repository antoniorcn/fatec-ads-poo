package edu.aula6;

public class EstudanteMaster implements Cestinha, Estudante {
	@Override
	public void naoDormir() {
		System.out.println("Prego nos olhos");
	}

	@Override
	public void virSabados() {
		System.out.println("Acordar e sair 03:40h da madrugada e vai correndo");
	}

	@Override
	public void estudar() {
		System.out.println("Fisica quantiva lendo em alemão");
	}

	@Override
	public void arremessarGarrafao() {
		System.out.println("Fazendo do garrafão");
	}

	@Override
	public void arremessarLinha3() {
		System.out.println("Fazendo pontos da linha de 3");		
	}

	@Override
	public void darToco() {
		System.out.println("Pula 1,69m para dor toco");		
	}

	@Override
	public void passe() {
		System.out.println("Passe perfeito");		
	}

	@Override
	public void driblar() {
		System.out.println("Drible perfeito");		
	}
}
