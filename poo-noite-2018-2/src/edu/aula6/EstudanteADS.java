package edu.aula6;

public class EstudanteADS implements Estudante {
	@Override
	public void naoDormir() {
		System.out.println("Colocando gelo no sapato");
	}

	@Override
	public void virSabados() {
		System.out.println("Pegando onibus as 06:30h no sabado");
	}

	@Override
	public void estudar() {
		System.out.println("Fazendo resumo de POO");
	}

}
