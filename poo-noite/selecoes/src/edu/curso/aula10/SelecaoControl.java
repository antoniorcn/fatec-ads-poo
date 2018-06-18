package edu.curso.aula10;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.curso.dao.SelecaoDAO;
import edu.curso.dao.SelecaoDAOImpl;

public class SelecaoControl implements TableModel {
	private List<Selecao> lista = new ArrayList<>();
	private SelecaoDAO selDAO = new SelecaoDAOImpl();
	private List<Selecao> listaPesquisados = new ArrayList<>();
	private String[] columnNames = {"Pais", "Posição no Ranking", "Grupo", 
			"Titulos Mundiais", "Confederação", "Data Estreia", "Nome do Tecnico"};
	private Connection con;
	
	public SelecaoControl() { 	
	}
	
	public void adicionar(Selecao s) {
		selDAO.adicionar( s );
	}
	
	public List<Selecao> pesquisarPorPais(String pais) { 
		listaPesquisados = selDAO.pesquisaPorPais( pais );
		return listaPesquisados;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) { 
			return String.class;
		} else if (columnIndex == 1) { 
			return Integer.class;
		} else if (columnIndex == 2) { 
			return String.class;
		} else if (columnIndex == 3) { 
			return Integer.class;
		} else if (columnIndex == 4) { 
			return String.class;
		} else if (columnIndex == 5) { 
			return Date.class;	
		} else if (columnIndex == 6) { 
			return String.class;			
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return listaPesquisados.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Selecao s = listaPesquisados.get(rowIndex);
		if (columnIndex == 0){ 
			return s.getPais();
		} else if (columnIndex == 1){
			return s.getPosicaoRanking();
		} else if (columnIndex == 2){
			return s.getGrupo();
		} else if (columnIndex == 3){
			return s.getTitulosMundiais();
		} else if (columnIndex == 4){
			return s.getConfederacao();
		} else if (columnIndex == 5){
			return s.getDataEstreia();
		} else if (columnIndex == 6){
			return s.getNomeTecnico();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 2) { 
			return true;
		} else { 
			return false;
		}
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}
}
