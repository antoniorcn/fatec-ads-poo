package edu.aula12;

import java.sql.SQLException;
import java.util.List;

public interface AlunoDAO {
	
	void adicionar(Aluno a) throws SQLException;
	List<Aluno> pesquisarPorNome(String nome) throws SQLException;

}
