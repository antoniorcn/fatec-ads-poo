package edu.curso.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.curso.dao.SelecaoDAO;
import edu.curso.dao.SelecaoDAOImpl;

public class SelecaoControl implements TableModel {
	private List<Selecao> selecoes = new ArrayList<>();
	private SelecaoDAO selDao = new SelecaoDAOImpl();
	private Selecao selecaoAtual = new Selecao();

	
	public void adicionar(Selecao s) {
		selDao.adicionar( s );
	}
	
	public List<Selecao> pesquisarPorPais(String nomePais) {
		selecoes = selDao.pesquisarPorPais( nomePais );
		return selecoes;		
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int col) {
		Class<?>[] tipos = {String.class, String.class, Integer.class, Integer.class, 
							String.class, Date.class, String.class};
//		if (col == 0) { 
//			return String.class;
//		} else if (col == 1) { 
//			return String.class;
//		}
		return tipos[col];
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int col) {
		String[] nomes = {"Pais", "Grupo", "Ranking Fifa", "Titulos Mundiais", 
				"Confederação", "Data do 1o Jogo", "Nome do técnico"}; 
		return nomes[col];
	}

	@Override
	public int getRowCount() {
		return selecoes.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Selecao s = selecoes.get( row );
		if (col == 0) { 
			return s.getPais();
		} else if (col == 1) { 
			return s.getGrupo();
		} else if (col == 2) { 
			return s.getRankingFifa();
		} else if (col == 3) { 
			return s.getTitulosMundiais();
		} else if (col == 4) { 
			return s.getConfederacao();
		} else if (col == 5) { 
			return s.getData();
		} else if (col == 6) { 
			return s.getTecnico();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
	}

	@Override
	public void setValueAt(Object elemento, int row, int col) {
	}

	public Selecao getSelecaoAtual() {
		return selecaoAtual;
	}

	public void setSelecaoAtual(Selecao selecaoAtual) {
		this.selecaoAtual = selecaoAtual;
	}

	public void currentSelected(int selectedRow) {
		if (selectedRow < selecoes.size()) { 
			setSelecaoAtual( selecoes.get(selectedRow) );
		}
		
	}
}
