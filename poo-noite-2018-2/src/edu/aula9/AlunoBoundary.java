package edu.aula9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	private AlunoControl control = new AlunoControl();
	private JTable table = new JTable(control);
		
	public AlunoBoundary() { 
		janela = new JFrame("Registro de Alunos");
		JPanel panCampos = new JPanel(new GridLayout(7, 2));
		JPanel panPrincipal = new JPanel( new BorderLayout());
		JScrollPane panTable = new JScrollPane();
		
		panCampos.add(new JLabel("Nome do Aluno:"));
		panCampos.add(txtNome);
		panCampos.add(new JLabel("RA:"));
		panCampos.add(txtRa);
		panCampos.add(new JLabel("Data de Nascimento:"));
		panCampos.add(txtNascimento);
		panCampos.add(new JLabel("Email:"));
		panCampos.add(txtEmail);
		panCampos.add(new JLabel("Nome do Curso:"));
		panCampos.add(cmbCurso);
		panCampos.add(new JLabel("Altura:"));
		panCampos.add(txtAltura);		
		panCampos.add(btnAdicionar);
		panCampos.add(btnPesquisar);
		
		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		panTable.getViewport().add(table);
		panPrincipal.add(panCampos, BorderLayout.NORTH);
		panPrincipal.add(panTable, BorderLayout.CENTER);
		janela.setContentPane(panPrincipal);
		
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
			control.adicionar(a);
			table.invalidate();
			table.revalidate();
			table.repaint();
		} else {
			Aluno a = control.pesquisarPorNome(txtNome.getText());
			if (a != null) { 
				txtNome.setText(a.getNome());
				txtRa.setText(a.getRa());
				txtEmail.setText(a.getEmail());
				cmbCurso.setSelectedItem(a.getCurso());
			}
		}
	}
}
