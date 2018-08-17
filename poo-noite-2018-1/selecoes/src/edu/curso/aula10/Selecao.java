package edu.curso.aula10;

import java.util.Date;

public class Selecao {
	private String pais;
	private int posicaoRanking;
	private String grupo;
	private int titulosMundiais;
	private String confederacao;
	private Date dataEstreia;
	private String nomeTecnico;
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public int getPosicaoRanking() {
		return posicaoRanking;
	}
	public void setPosicaoRanking(int posicaoRanking) {
		this.posicaoRanking = posicaoRanking;
	}
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public int getTitulosMundiais() {
		return titulosMundiais;
	}
	public void setTitulosMundiais(int titulosMundiais) {
		this.titulosMundiais = titulosMundiais;
	}
	
	public String getConfederacao() {
		return confederacao;
	}
	public void setConfederacao(String confederacao) {
		this.confederacao = confederacao;
	}
	
	public Date getDataEstreia() {
		return dataEstreia;
	}
	public void setDataEstreia(Date dataEstreia) {
		this.dataEstreia = dataEstreia;
	}
	
	public String getNomeTecnico() {
		return nomeTecnico;
	}
	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	
	@Override
	public String toString() { 
		return "Pais: " + getPais();
	}
	
}
