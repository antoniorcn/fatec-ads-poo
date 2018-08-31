package edu.aula5;

public class Amoxil extends Medicamento {
	@Override
	public String tarjaDoProduto() {
		return "Vermelha";
	}

	@Override
	public String forma() {
		return "Comprimido";
	}

	@Override
	public int dosar(int idade) {
		if (idade < 12){ 
			return 1;
		} else { 
			return 2;
		}
	}

	@Override
	public String faixaEtaria() {
		return "Todas as idades";
	}

	@Override
	public boolean liberar(int idade) {
		return true;
	}

}
