package edu.aula8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela implements ActionListener {
	private JLabel lblTeste;
	public Janela() { 
		JFrame janela = new JFrame("Teste de Botão");
		JPanel painel = new JPanel();
		lblTeste = new JLabel("Aqui vai o texto");
		JButton btnOk = new JButton("Me aperte");
		painel.add(lblTeste);
		painel.add(btnOk);
		btnOk.addActionListener(this);
		janela.setContentPane(painel);
		janela.setSize(400, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lblTeste.setText("Botão Apertado");
	}
	public static void main(String[] args) {
		new Janela();
	}	
}
