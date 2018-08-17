package edu.aula3;

public class TesteAluno {

	public static void main(String[] args) {

		Aluno a1 = new Aluno();
		a1.nome="Pedro";
		a1.ra="123";
		a1.imprimir();
		
		Aluno a2 = new Aluno("Antonio");
		a2.imprimir();

	}

}
