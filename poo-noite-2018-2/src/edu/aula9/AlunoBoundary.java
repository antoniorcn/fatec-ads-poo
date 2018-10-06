package edu.aula9;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlunoBoundary implements ActionListener {
	private final static String[] CURSOS = {"ADS", "Polimeros", "Logistica", 
											"Comex", "RH","Gestão Empresarial"};
	
	private JFrame janela;
	private JTextField txtNome = new JTextField(30);
	private JTextField txtRa = new JTextField(10);
	private JTextField txtNascimento = new JTextField(10);
	private JTextField txtEmail = new JTextField(30);
	private JComboBox<String> cmbCurso = new JComboBox<>(CURSOS);
	private JTextField txtAltura = new JTextField(10);
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private List<Aluno> alunos = new ArrayList<>();
	
	public AlunoBoundary() { 
		janela = new JFrame("Registro de Alunos");
		JPanel painel = new JPanel(new GridLayout(7, 2));
		
		painel.add(new JLabel("Nome do Aluno:"));
		painel.add(txtNome);
		painel.add(new JLabel("RA:"));
		painel.add(txtRa);
		painel.add(new JLabel("Data de Nascimento:"));
		painel.add(txtNascimento);
		painel.add(new JLabel("Email:"));
		painel.add(txtEmail);
		painel.add(new JLabel("Nome do Curso:"));
		painel.add(cmbCurso);
		painel.add(new JLabel("Altura:"));
		painel.add(txtAltura);		
		painel.add(btnAdicionar);
		painel.add(btnPesquisar);
		
		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
				
		janela.setContentPane(painel);
		
		janela.setSize(600, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AlunoBoundary();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals(cmd)) {
			Aluno a = new Aluno();
			a.setNome(txtNome.getText());
			a.setRa(txtRa.getText());
			a.setEmail(txtEmail.getText());
			a.setCurso(CURSOS[cmbCurso.getSelectedIndex()]);
			a.setAltura(Float.parseFloat(txtAltura.getText()));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date d = sdf.parse(txtNascimento.getText());
				a.setNascimento(d);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			alunos.add(a);
			System.out.println("Aluno cadastrado, a lista tem " + 
									alunos.size() + " alunos ");
		} else {
			System.out.println("Procurando aluno");
			for (Aluno a : alunos) { 
				if (a.getNome().contains(txtNome.getText())) { 
					txtNome.setText(a.getNome());
					txtRa.setText(a.getRa());
					txtEmail.setText(a.getEmail());
					cmbCurso.setSelectedItem(a.getCurso());
				}
			}
		}
	}
	

}
