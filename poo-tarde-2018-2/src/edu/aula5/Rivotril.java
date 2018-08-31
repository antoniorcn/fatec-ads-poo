package edu.aula5;

public class Rivotril extends Medicamento {

	@Override
	public String tarjaDoProduto() {
		return "Preta";
	}

	@Override
	public String forma() {
		return "Comprimido";
	}

	@Override
	public int dosar(int idade) {
		return 1;
	}

	@Override
	public String faixaEtaria() {
		return "apenas maiores de 18 anos";
	}

	@Override
	public boolean liberar(int idade) {
//		if (idade > 18) { 
//			return true;
//		} else { 
//			return false;
//		}
		return (idade > 18);
	}
}
