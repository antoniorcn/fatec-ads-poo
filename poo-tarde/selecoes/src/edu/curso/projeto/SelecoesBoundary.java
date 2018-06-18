package edu.curso.projeto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecoesBoundary implements ActionListener {
	
	private static final String[] GRUPOS = 
						new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};
	private static final String[] CONFEDERACOES = 
			new String[] {"Asia", "UEFA", "ConmemBol", "Concacaf"};	
	private JTextField txtPais;
	private JComboBox<String> txtGrupo;
	private JSpinner txtPosRank;
	private JSpinner txtTitulos;
	private JComboBox<String> txtConfederacao;
	private JTextField txtDataEstreia;
	private JTextField txtTecnico;
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	
	private SelecaoControl control = new SelecaoControl();
	private JTable tabela;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public SelecoesBoundary() { 
		JFrame janela = new JFrame("Copa do mundo da Russia 2018");
		JPanel painel = new JPanel( new BorderLayout() );
		tabela = new JTable(control);
		
		JPanel painelCampos = new JPanel(new GridLayout(8, 2) );
		JScrollPane painelTabela = new JScrollPane();
		txtPais = new JTextField();
		txtGrupo = new JComboBox<>( GRUPOS );
		txtPosRank = new JSpinner();
		txtTitulos = new JSpinner();
		txtConfederacao = new JComboBox<>( CONFEDERACOES );
		txtDataEstreia = new JTextField();
		txtTecnico = new JTextField();
		
		btnAdicionar = new JButton("Adicionar");
		btnPesquisar = new JButton("Pesquisar");
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
			
		painelCampos.add( new JLabel("Pais") );
		painelCampos.add( txtPais );
		painelCampos.add( new JLabel("Grupo") );
		painelCampos.add( txtGrupo );
		painelCampos.add( new JLabel("Posição Ranking FIFA") );
		painelCampos.add( txtPosRank );
		painelCampos.add( new JLabel("Titulos Mundiais") );
		painelCampos.add( txtTitulos );
		painelCampos.add( new JLabel("Confederação") );
		painelCampos.add( txtConfederacao );
		painelCampos.add( new JLabel("Data Estreia na copa") );
		painelCampos.add( txtDataEstreia );
		painelCampos.add( new JLabel("Nome do Tecnico") );
		painelCampos.add( txtTecnico );
		painelCampos.add(btnAdicionar);
		painelCampos.add(btnPesquisar);
		
		painelTabela.getViewport().add( tabela );
		
		tabela.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				control.currentSelected( tabela.getSelectedRow() );	
				selecaoToBoundary( control.getSelecaoAtual() );
			} 
			
		});
		
		painel.add(painelCampos, BorderLayout.NORTH);
		painel.add(painelTabela, BorderLayout.CENTER);
		
		janela.setContentPane(painel);
		
		janela.setSize(500,  300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Adicionar".equals(e.getActionCommand())) {
			Selecao s = boundaryToSelecao();
			control.adicionar( s );
			System.out.println( "Seleção adicionada " + s.toString() );
		} else if ("Pesquisar".equals(e.getActionCommand())) {
			List<Selecao> selecoes = control.pesquisarPorPais( txtPais.getText() );
			if (selecoes != null && selecoes.size() > 0) {
				Selecao s = control.getSelecaoAtual();
				selecaoToBoundary(s);
				System.out.println("Encontrada a seleção");
				System.out.println( s );
			}
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
		}
		
	}

	private void selecaoToBoundary(Selecao s) {
		txtPais.setText( s.getPais() );
		txtConfederacao.setSelectedItem( s.getConfederacao() );
		txtDataEstreia.setText( sdf.format( s.getData() ) );
		txtGrupo.setSelectedItem( s.getGrupo() );
		txtPosRank.setValue( s.getRankingFifa() );
		txtTecnico.setText( s.getTecnico() );
		txtTitulos.setValue( s.getTitulosMundiais() );
	}

	private Selecao boundaryToSelecao() {
		Selecao s = new Selecao();
		s.setPais( txtPais.getText() );
		s.setConfederacao( (String) txtConfederacao.getSelectedItem());
		try {
			s.setData( sdf.parse( txtDataEstreia.getText() ) );
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		s.setGrupo( (String) txtGrupo.getSelectedItem() );
		s.setRankingFifa( (Integer) txtPosRank.getValue());
		s.setTecnico( txtTecnico.getText() );
		s.setTitulosMundiais( (Integer) txtTitulos.getValue() );
		return s;
	}
	
	public static void main(String[] args) {
		new SelecoesBoundary();
	}

}
