package edu.aula14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {
	public AlunoDAOImpl() throws ClassNotFoundException, SQLException { 
	}
	
	@Override
	public void adicionar(Aluno a) throws SQLException {
		Connection con = DBUtil.getInstance().getConnection();
		String sql = "INSERT INTO alunos "
				+ " (id, nome, ra, nascimento, email, curso, altura) "
				+ " VALUES (0, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement( sql );
		stmt.setString(1, a.getNome());
		stmt.setString(2, a.getRa());
		long milisec = a.getNascimento().getTime(); 
		java.sql.Date sqlD = new java.sql.Date( milisec );
		stmt.setDate(3, sqlD);
		stmt.setString(4, a.getEmail());
		stmt.setString(5, a.getCurso());
		stmt.setFloat(6,  a.getAltura());
		int i = stmt.executeUpdate();
	}

	@Override
	public List<Aluno> pesquisarPorNome(String nome) throws SQLException {
		Connection con = DBUtil.getInstance().getConnection();
		List<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos WHERE nome like ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) { 
			Aluno a = new Aluno();
			a.setRa( rs.getString("ra") );
			a.setNome( rs.getString("nome") );
			a.setNascimento( rs.getDate("nascimento") );
			a.setEmail( rs.getString("email") );
			a.setCurso( rs.getString("curso") );
			a.setAltura( rs.getFloat("altura") );
			alunos.add(a);
		}
		return alunos;
	}
}
