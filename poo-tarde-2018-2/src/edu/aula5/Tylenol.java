package edu.aula5;

public class Tylenol extends Medicamento {

	@Override
	public String tarjaDoProduto() {
		return "Branca";
	}

	@Override
	public String forma() {
		return "Xarope";
	}

	@Override
	public int dosar(int idade) {
		if (idade < 10) { 
			return 5;
		} else if (idade < 15) { 
			return 8;
		} else { 
			return 10;
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
