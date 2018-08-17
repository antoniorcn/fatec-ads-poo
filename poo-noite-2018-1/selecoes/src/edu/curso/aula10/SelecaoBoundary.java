package edu.curso.aula10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SelecaoBoundary implements ActionListener {
	private static final String[] GRUPOS = 
			{"A", "B", "C", "D", "E", "F", "G", "H"};
	private static final String[] CONFEDERACOES = 
		{"Conmebol", "UEFA", "Asia", "Concacaf", "Africa"};
	private JTextField txtPais = new JTextField();
	private JTextField txtData = new JTextField();
	private JTextField txtTecnico = new JTextField();
	private JComboBox<String> cmbGrupo = new JComboBox<>(GRUPOS);
	private JComboBox<String> cmbConfederacao = new JComboBox<>(CONFEDERACOES);
	private JSpinner spnPosicao = new JSpinner();
	private JSpinner spnTitulos = new JSpinner();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private SelecaoControl control = new SelecaoControl();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTable tabela; 
	
	public SelecaoBoundary() {
		JFrame janela = new JFrame("Seleções da Copa");
		JPanel principal = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		JPanel painel = new JPanel( new GridLayout(8, 2) );
		
		tabela = new JTable(control);
		
		Action delete = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        JOptionPane.showMessageDialog(null, "Botão apertado na linha " + modelRow );
		    }
		};
		 
		ButtonColumn buttonColumn = new ButtonColumn(tabela, delete, 2);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		
		scroll.getViewport().add( tabela );
		
		painel.add( new JLabel("Pais") );
		painel.add( txtPais );
		painel.add( new JLabel("Grupo") );
		painel.add( cmbGrupo );
		painel.add( new JLabel("Posição no Ranking da FIFA") );
		painel.add( spnPosicao );
		painel.add( new JLabel("Titulos Mundiais") );
		painel.add( spnTitulos );
		painel.add( new JLabel("Confederação") );
		painel.add( cmbConfederacao );
		painel.add( new JLabel("Data do primeiro jogo") );
		painel.add( txtData );	
		painel.add( new JLabel("Nome do Tecnico") );
		painel.add( txtTecnico );
		painel.add(btnAdicionar);
		painel.add(btnPesquisar);

		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		principal.add(painel, BorderLayout.SOUTH);
		principal.add(scroll, BorderLayout.CENTER);
		
		janela.setContentPane( principal );
		janela.setSize(500, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SelecaoBoundary();
	}
	
	public Selecao boundaryToEntity() {
		Selecao s = new Selecao();
		s.setConfederacao( (String) cmbConfederacao.getSelectedItem() );
		try {
			s.setDataEstreia( sdf.parse( txtData.getText() ) );
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		s.setGrupo( (String) cmbGrupo.getSelectedItem() );
		s.setNomeTecnico( txtTecnico.getText() );
		s.setPais( txtPais.getText() );
		s.setPosicaoRanking( (Integer) spnPosicao.getValue() );
		s.setTitulosMundiais( (Integer) spnTitulos.getValue() );
		return s;
	}
	
	public void entityToBoundary(Selecao s) { 
		cmbConfederacao.setSelectedItem( s.getConfederacao() );
		txtData.setText( sdf.format(s.getDataEstreia()) );
		cmbGrupo.setSelectedItem( s.getGrupo() );
		txtTecnico.setText( s.getNomeTecnico() );
		txtPais.setText( s.getPais() );
		spnPosicao.setValue( s.getPosicaoRanking() );
		spnTitulos.setValue( s.getTitulosMundiais() );

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals(cmd)) {
			control.adicionar( boundaryToEntity() );
		} else if ("Pesquisar".equals(cmd)) { 
			List<Selecao> lista = control.pesquisarPorPais( txtPais.getText() );
			if (lista != null && lista.size() > 0) { 
				Selecao s = lista.get(0);
				entityToBoundary( s );
			}
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
		}
	}
}
