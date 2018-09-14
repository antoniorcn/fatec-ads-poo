package edu.aula6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelloWorldSwing {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Hello World");
		JPanel painel = new JPanel();
		JLabel lblHello = new JLabel("Ola Mundo");
		painel.add(lblHello);
		janela.setContentPane(painel);
		janela.setSize(400, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
}
