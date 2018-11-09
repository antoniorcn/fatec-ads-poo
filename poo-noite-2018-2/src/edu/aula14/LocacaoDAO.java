package edu.aula14;

import java.util.List;

public interface LocacaoDAO {
	void adicionar(LocacaoBicicleta l);
	List<LocacaoBicicleta> pesquisarPorNomeCliente(String nomeCliente);
}
