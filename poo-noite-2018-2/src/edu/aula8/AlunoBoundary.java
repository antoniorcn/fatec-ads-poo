package edu.aula8;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlunoBoundary {
	
	private JFrame janela;
	private JTextField txtNome;
	private JTextField txtRa;
	
	public AlunoBoundary() { 
		janela = new JFrame("Registro de Alunos");
		JPanel painel = new JPanel(new GridLayout(2, 2));
		JLabel lblNome = new JLabel("Nome do Aluno:");
		JLabel lblRa = new JLabel("RA:");
		
		txtNome = new JTextField(30);
		txtRa = new JTextField(10);
		
//		GridLayout grid = new GridLayout(2, 2);
//		painel.setLayout( grid );
		
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblRa);
		painel.add(txtRa);
		
		janela.setContentPane(painel);
		
		janela.setSize(300, 100);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AlunoBoundary();
	}
	

}
