package edu.aula8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private JComboBox<String> cmbSetor = new JComboBox<>(setores);
	private JButton btnPesquisar;
	private JButton btnAdicionar;
	
	private List<Funcionario> lista = new ArrayList<>();
	
	public FuncionarioBoundary() { 
		JFrame janela = new JFrame("Gestão de Funcionarios");
		JPanel painel = new JPanel(new GridLayout(4, 2));
	
		btnAdicionar = new JButton("Adicionar");
		btnPesquisar = new JButton("Pesquisar");
		
//		JLabel lblNome = new JLabel("Nome:");
//		painel.add(lblNome);
		painel.add(new JLabel("Nome:"));
		painel.add(txtNome);
		painel.add(new JLabel("Documento:"));
		painel.add(txtDoc);
		painel.add(new JLabel("Setor:"));
		painel.add(cmbSetor);
		painel.add(btnAdicionar);
		painel.add(btnPesquisar);
		
		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		
		// btnAdicionar.setActionCommand("adicionar");
		
		janela.setContentPane(painel);
		janela.setSize(400, 150);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals(cmd)) {
			Funcionario func = new Funcionario();
			func.setNome(txtNome.getText());
			func.setDocumento(txtDoc.getText());
			String setor = setores[cmbSetor.getSelectedIndex()];
			func.setSetor(setor);
			
			lista.add( func );
			
			System.out.printf("Lista tem %d elementos\n", lista.size());
		} else if ("Pesquisar".equals(cmd)) {
			for ( Funcionario f : lista ) {
				if (f.getNome().contains(txtNome.getText())) { 
					txtNome.setText(f.getNome());
					txtDoc.setText(f.getDocumento());
					cmbSetor.setSelectedItem(f.getSetor());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new FuncionarioBoundary();
	}
}
