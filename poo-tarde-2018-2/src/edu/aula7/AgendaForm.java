package edu.aula7;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AgendaForm {
	
	private JFrame janela;
	private JTextField txtPhone;
	private JTextArea txtName;
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	
	public AgendaForm() {
		janela = new JFrame("Agenda");
		JPanel painel = new JPanel();
		JLabel phone = new JLabel("Enter your phone number:");
		JLabel name = new JLabel("Enter your name:");
		txtPhone = new JTextField(10);
		txtName = new JTextArea(5, 20);
		btnAdicionar = new JButton("Add");
		btnPesquisar = new JButton("Search");
		painel.add(phone);
		painel.add(txtPhone);
		painel.add(name);
		painel.add(txtName);
		painel.add(btnAdicionar);
		painel.add(btnPesquisar);
		janela.setContentPane(painel);
		janela.setSize(400, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new AgendaForm();
	}

}
