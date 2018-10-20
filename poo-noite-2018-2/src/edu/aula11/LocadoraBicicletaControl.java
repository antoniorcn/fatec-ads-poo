package edu.aula11;

import java.util.ArrayList;
import java.util.List;

public class LocadoraBicicletaControl {
	
	public List<LocadoraBicicleta> locacoes = new ArrayList<>();
	
	public void adicionar(LocadoraBicicleta l) { 
		locacoes.add(l);
	}
	
	public LocadoraBicicleta pesquisarPorNome(String nomeCliente) { 
		for (LocadoraBicicleta l : locacoes) {
			if (l.getNomeCliente().contains(nomeCliente)) { 
				return l;
			}
		}
		return null;
	}

}
