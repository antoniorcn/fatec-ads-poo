package edu.aula12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {
	private Connection con;

	public AlunoDAOImpl() throws ClassNotFoundException, SQLException { 
		String url = "jdbc:mariadb://localhost:3306/escola";
		String user = "root";
		String pass = "";
		Class.forName("org.mariadb.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
	}
	
	@Override
	public void adicionar(Aluno a) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String sql = "INSERT INTO alunos "
				+ " (id, nome, ra, nascimento, email, curso, altura) "
				+ " VALUES (0, "
				+ "'" + a.getNome() + "', "
				+ "'" + a.getRa() + "', "
				+ "'" + sdf.format(a.getNascimento()) + "', "
				+ "'" + a.getEmail() + "', "
				+ "'" + a.getCurso() + "', " 
				+ a.getAltura() + ")";
		Statement stmt = con.createStatement();
		int i = stmt.executeUpdate(sql);
	}

	@Override
	public List<Aluno> pesquisarPorNome(String nome) throws SQLException {
		List<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos WHERE nome like '%" + nome + "%'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
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
