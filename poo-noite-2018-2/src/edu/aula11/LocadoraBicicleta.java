package edu.aula11;

import java.util.Date;

public class LocadoraBicicleta {
	private String nomeCliente;
	private String modeloBike;
	private Date dataLocacao;
	private float preco;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getModeloBike() {
		return modeloBike;
	}
	public void setModeloBike(String modeloBike) {
		this.modeloBike = modeloBike;
	}
	
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
