package edu.aula11;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class LocadoraBicicletaBoundary implements ActionListener {
	private JTextField txtNomeCliente = new JTextField(30);
	private JTextField txtModeloBike = new JTextField(30);
	private JTextField txtData = new JTextField(30);
	private JTextField txtPreco = new JTextField(30);
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private LocadoraBicicletaControl control = new LocadoraBicicletaControl();
	public LocadoraBicicletaBoundary() { 
		JFrame janela = new JFrame("Locadora de Bicicleta");
		JPanel painel = new JPanel(new GridLayout(5, 2));
		painel.add(new JLabel("Nome do Cliente:"));
		painel.add(txtNomeCliente);
		painel.add(new JLabel("Modelo da Bicicleta:"));
		painel.add(txtModeloBike);
		painel.add(new JLabel("Data de Locação:"));
		painel.add(txtData);
		painel.add(new JLabel("Preço:"));
		painel.add(txtPreco);
		btnAdicionar = new JButton("Adicionar");
		btnPesquisar = new JButton("Pesquisar");
		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		painel.add(btnAdicionar);
		painel.add(btnPesquisar);
		janela.setContentPane(painel);
		janela.setSize(400, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new LocadoraBicicletaBoundary();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if ("Adicionar".equals(e.getActionCommand())) { 
			LocadoraBicicleta locacaoBicicleta = new LocadoraBicicleta();
			locacaoBicicleta.setNomeCliente(txtNomeCliente.getText());
			locacaoBicicleta.setModeloBike(txtModeloBike.getText());
			locacaoBicicleta.setPreco(Float.parseFloat(txtPreco.getText()));
			try {
				Date d = sdf.parse(txtData.getText());
				locacaoBicicleta.setDataLocacao(d);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			control.adicionar( locacaoBicicleta );
		} else if ("Pesquisar".equals(e.getActionCommand())) {
			LocadoraBicicleta lb = 
					control.pesquisarPorNome( txtNomeCliente.getText() );
			txtNomeCliente.setText( lb.getNomeCliente() );
			txtModeloBike.setText( lb.getModeloBike() );
			txtPreco.setText( String.valueOf(lb.getPreco()) );
			txtData.setText( sdf.format(lb.getDataLocacao()) );
		}
		
		
	}
}
