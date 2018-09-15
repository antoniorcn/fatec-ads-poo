package edu.aula6;

public class EstudanteComex implements Estudante {
	@Override
	public void naoDormir() {
		System.out.println("Cochilos leves");
	}

	@Override
	public void virSabados() {
		System.out.println("Não preciso vir");
	}

	@Override
	public void estudar() {
		System.out.println("Assitir Youtube");
	}

}
