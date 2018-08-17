package edu.curso.dao;

import java.util.List;

import edu.curso.aula10.Selecao;

public interface SelecaoDAO {
	
	public void adicionar(Selecao s);
	public List<Selecao> pesquisaPorPais( String nomePais );

}
