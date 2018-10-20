package edu.aula11;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesteAbsolute {
	public TesteAbsolute() { 
		JFrame janela = new JFrame("Teste Absolute");
		JPanel painel = new JPanel();
		Insets insets = painel.getInsets();
		JLabel lblTeste = new JLabel("Teste de Label");
		painel.setLayout(null);
		painel.add(lblTeste);
		lblTeste.setBounds(250, 100, 100, 50);
		
		janela.setContentPane(painel);
		
		janela.setSize(400, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		new TesteAbsolute();

	}

}
