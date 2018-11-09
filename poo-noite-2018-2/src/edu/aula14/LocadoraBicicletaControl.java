package edu.aula14;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class LocadoraBicicletaControl implements TableModel {

	public List<LocacaoBicicleta> locacoes = new ArrayList<>();
	public LocacaoDAO locDAO = new LocacaoDAOImpl();
	public LocadoraBicicletaControl() {

	}
	
	public void adicionar(LocacaoBicicleta l) {
		locDAO.adicionar(l);
	}
	
	public List<LocacaoBicicleta> pesquisarPorNome(String nomeCliente) {
		locacoes = locDAO.pesquisarPorNomeCliente(nomeCliente);
		return locacoes;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return Date.class;
			case 3 : return Float.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0 : return "Nome do Cliente";
			case 1 : return "Modelo da Bicicleta";
			case 2 : return "Data da Locação";
			case 3 : return "Preço";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return locacoes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		LocacaoBicicleta loc = locacoes.get(rowIndex);
		switch (columnIndex) {
			case 0 : return loc.getNomeCliente();
			case 1 : return loc.getModeloBike();
			case 2 : return loc.getDataLocacao();
			case 3 : return loc.getPreco();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}
}
