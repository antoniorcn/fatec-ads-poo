package edu.aula11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class AlunoControl implements TableModel {
	
	private List<Aluno> alunos = new ArrayList<>();
	
	public void adicionar(Aluno a) { 
		alunos.add( a );
		System.out.println("Aluno cadastrado, a lista tem " + 
				alunos.size() + " alunos ");
	}
	
	public Aluno pesquisarPorNome(String nome) { 
		System.out.println("Procurando aluno");
		for (Aluno a : alunos) { 
			if (a.getNome().contains(nome)) { 
				return a;
			}
		}
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) { 
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return String.class;
			case 3 : return String.class;
			case 4 : return Date.class;
			case 5 : return Float.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) { 
			case 0 : return "R.A.";
			case 1 : return "Nome";
			case 2 : return "eMail";
			case 3 : return "Curso";
			case 4 : return "Nascimento";
			case 5 : return "Altura";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return alunos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Aluno a = alunos.get(row);
		switch (col) { 
			case 0 : return a.getRa();
			case 1 : return a.getNome();
			case 2 : return a.getEmail();
			case 3 : return a.getCurso();
			case 4 : return a.getNascimento();
			case 5 : return a.getAltura();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
