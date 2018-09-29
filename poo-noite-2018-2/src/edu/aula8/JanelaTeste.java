package edu.aula8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaTeste {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Teste de Botão");
		JPanel painel = new JPanel();
		JButton btnOk = new JButton("Aperte aqui");
		painel.add(btnOk);
		janela.setContentPane(painel);
		Ouvinte ouv = new Ouvinte();
		btnOk.addActionListener( ouv );
		janela.setSize(400, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
