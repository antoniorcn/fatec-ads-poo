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

public class FuncionarioBoundary implements ActionListener {
	private String[] setores = {"Administrativo", "Limpeza", 
							"Operacional", "RH"};
	
	private JTextField txtNome = new JTextField(30);
	private JTextField txtDoc = new JTextField(30);
	private JTextField txtCargo = new JTextField(30);
	private JTextField txtSalario = new JTextField(30);
	private JTextField txtNascimento = new JTextField(30);
	private JComboBox<String> cmbSetor = new JComboBox<>(setores);
	private JButton btnPesquisar;
	private JButton btnAdicionar;
	
	private List<Funcionario> lista = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public FuncionarioBoundary() { 
		JFrame janela = new JFrame("Gestão de Funcionarios");
		JPanel painel = new JPanel(new GridLayout(7, 2, 3, 10));
	
		btnAdicionar = new JButton("Adicionar");
		btnPesquisar = new JButton("Pesquisar");
		
		painel.add(new JLabel("Nome:"));
		painel.add(txtNome);
		painel.add(new JLabel("Documento:"));
		painel.add(txtDoc);
		painel.add(new JLabel("Setor:"));
		painel.add(cmbSetor);
		painel.add(new JLabel("Cargo:"));
		painel.add(txtCargo);
		painel.add(new JLabel("Salario:"));
		painel.add(txtSalario);
		painel.add(new JLabel("Data Nascimento:"));
		painel.add(txtNascimento);
		painel.add(btnAdicionar);
		painel.add(btnPesquisar);
		
		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		
		janela.setContentPane(painel);
		janela.setSize(600, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		funcionarioToForm(new Funcionario());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals(cmd)) {
			Funcionario func = formToFuncionario();
			lista.add( func );
			func = new Funcionario();
			funcionarioToForm(func);
			
			System.out.printf("Lista tem %d elementos\n", lista.size());
		} else if ("Pesquisar".equals(cmd)) {
			for ( Funcionario f : lista ) {
				if (f.getNome().contains(txtNome.getText())) { 
					funcionarioToForm(f);
				}
			}
		}
	}

	private void funcionarioToForm(Funcionario f) {
		txtNome.setText(f.getNome());
		txtDoc.setText(f.getDocumento());
		cmbSetor.setSelectedItem(f.getSetor());
		txtCargo.setText(f.getCargo());
		txtSalario.setText(String.valueOf(f.getSalario()));
		String date = sdf.format(f.getNascimento());
		txtNascimento.setText(date);
	}

	private Funcionario formToFuncionario() {
		Funcionario func = new Funcionario();
		func.setNome(txtNome.getText());
		func.setDocumento(txtDoc.getText());
		String setor = setores[cmbSetor.getSelectedIndex()];
		func.setSetor(setor);
		func.setCargo(txtCargo.getText());
		func.setSalario(Float.parseFloat(txtSalario.getText()));
		try {
			Date d = sdf.parse(txtNascimento.getText());
			func.setNascimento( d );
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return func;
	}
	
	public static void main(String[] args) {
		new FuncionarioBoundary();
	}
}
