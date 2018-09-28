package edu.aula7;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesteSwing {

	public static void main(String[] args) {
		JLabel lblHello = new JLabel("Hello World");
		JPanel painel = new JPanel();
		JFrame janela = new JFrame("Hello World");
		
		janela.setContentPane(painel);
		painel.add( lblHello );
		
		janela.setSize(400, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
