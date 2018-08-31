package edu.aula5;

import java.util.Scanner;

public class Farmacia {

	public static void main(String[] args) {
//		Tylenol t1 = new Tylenol();
//		Tylenol t2 = new Tylenol();
//		Rivotril r1 = new Rivotril();
//		Rivotril r2 = new Rivotril();
//		Amoxil a1 = new Amoxil();
//		Amoxil a2 = new Amoxil();
//		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o medicamento (R)ivotril, (A)moxil, (T)ylenol : ");
		char c = scan.nextLine().charAt(0);

		System.out.println("Informe sua idade : ");
		int idade = scan.nextInt();

		Medicamento m;
		if(c == 'R') { 
			m = new Rivotril();
		} else if (c == 'A') { 
			m = new Amoxil();
		} else {
			m = new Tylenol();
		}
		System.out.printf(
				"Rapaz de %d anos quer comprar %s \n", idade, m.getClass().getName() );
		System.out.println("Autorizado : " + m.liberar(idade));
		if (m.liberar(idade)) { 
			System.out.println("Tomar : " + m.dosar(idade));
		} else { 
			System.out.println("Faixa Etaria : " + m.faixaEtaria());
		}
		scan.close();
	}

}
