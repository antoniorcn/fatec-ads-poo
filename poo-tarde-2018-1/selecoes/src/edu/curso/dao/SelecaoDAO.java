package edu.curso.dao;

import java.util.List;

import edu.curso.projeto.Selecao;

public interface SelecaoDAO {
	
	public void adicionar(Selecao s);
	public List<Selecao> pesquisarPorPais(String pais);

}
