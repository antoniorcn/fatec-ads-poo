package edu.aula9;

import java.util.Date;
import java.util.Random;

public class Funcionario {
	private String nome = "";
	private String documento = "";
	private String setor = "Operacional";
	private String cargo = "";
	private float salario;
	private Date nascimento = new Date();
	
	public Funcionario() { 
		Random rnd = new Random();
		int numero  = rnd.nextInt();
		documento = String.valueOf(Math.abs(numero % 2001));
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
}
