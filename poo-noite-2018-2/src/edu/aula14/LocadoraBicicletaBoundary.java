package edu.aula14;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class LocadoraBicicletaBoundary implements ActionListener {
	private JTextField txtNomeCliente = new JTextField(30);
	private JTextField txtModeloBike = new JTextField(30);
	private JTextField txtData = new JTextField(30);
	private JTextField txtPreco = new JTextField(30);
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private LocadoraBicicletaControl control = new LocadoraBicicletaControl();
	private JTable tabela = new JTable(control);
	public LocadoraBicicletaBoundary() { 
		JFrame janela = new JFrame("Locadora de Bicicleta");
		JPanel panPrincipal = new JPanel(new BorderLayout());
		JPanel panForm = new JPanel(new GridLayout(5, 2));
		JScrollPane panTabela = new JScrollPane();
		panTabela.getViewport().add(tabela);
		panForm.add(new JLabel("Nome do Cliente:"));
		panForm.add(txtNomeCliente);
		panForm.add(new JLabel("Modelo da Bicicleta:"));
		panForm.add(txtModeloBike);
		panForm.add(new JLabel("Data de Locação:"));
		panForm.add(txtData);
		panForm.add(new JLabel("Preço:"));
		panForm.add(txtPreco);
		btnAdicionar = new JButton("Adicionar");
		btnPesquisar = new JButton("Pesquisar");
		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		panForm.add(btnAdicionar);
		panForm.add(btnPesquisar);
		panPrincipal.add(panForm, BorderLayout.NORTH);
		panPrincipal.add(panTabela, BorderLayout.CENTER);
		janela.setContentPane(panPrincipal);
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
			LocacaoBicicleta locacaoBicicleta = new LocacaoBicicleta();
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
			List<LocacaoBicicleta> lista = 
					control.pesquisarPorNome( txtNomeCliente.getText() );
			if (lista.size() > 0) {
				LocacaoBicicleta lb = lista.get(0);
				txtNomeCliente.setText( lb.getNomeCliente() );
				txtModeloBike.setText( lb.getModeloBike() );
				txtPreco.setText( String.valueOf(lb.getPreco()) );
				txtData.setText( sdf.format(lb.getDataLocacao()) );
			}
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
			
		}
		
		
	}
}
