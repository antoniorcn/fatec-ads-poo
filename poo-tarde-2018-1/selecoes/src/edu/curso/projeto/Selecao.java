package edu.curso.projeto;

import java.util.Date;

public class Selecao {
	
	private String pais;
	private String grupo;
	private int rankingFifa;
	private int titulosMundiais;
	private String confederacao;
	private Date data = new Date();
	private String tecnico;
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public int getRankingFifa() {
		return rankingFifa;
	}
	public void setRankingFifa(int rankingFifa) {
		this.rankingFifa = rankingFifa;
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
	public void setConfederacao(String confedereacao) {
		this.confederacao = confedereacao;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	@Override
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Pais : " + getPais() + "\n");
		sb.append("Titulos : " + getTitulosMundiais() + "\n");
		sb.append("Tecnico : " + getTecnico() + "\n");
		sb.append("Data de Estreia : " + getData() + "\n");
		return sb.toString();
	}
}
