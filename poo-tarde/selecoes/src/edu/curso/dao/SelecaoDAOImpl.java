package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.projeto.Selecao;

public class SelecaoDAOImpl implements SelecaoDAO {
	
	private Connection con;
	
	public SelecaoDAOImpl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String urlDb = "jdbc:mariadb://localhost:3306/selecoes?allowMultiQueries=true";
			con = DriverManager.getConnection(urlDb, "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void adicionar(Selecao s) {	
		try {			
			String sql = "INSERT INTO selecao " +
					"(pais, grupo, ranking, titulos, confederacao, tecnico, estreia) " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, s.getPais() );
			stmt.setString(2, s.getGrupo() );
			stmt.setInt(3, s.getRankingFifa() );
			stmt.setInt(4, s.getTitulosMundiais() );
			stmt.setString(5, s.getConfederacao() );
			stmt.setString(6, s.getTecnico() );
//			long mili = s.getData().getTime();
//			java.sql.Date d = new java.sql.Date( mili );
//			stmt.setDate(7, d );
			stmt.setDate(7,  new java.sql.Date( s.getData().getTime() ) );
			stmt.executeUpdate( );
			
//			Statement stmt = con.createStatement();
//			String sql = "INSERT INTO selecao " +
//					"(pais, grupo, ranking, titulos, confederacao, tecnico, estreia) " +
//					" VALUES ('" + s.getPais() + 
//					"', '" + s.getGrupo() + 
//					"', " + s.getRankingFifa() +
//					", " + s.getTitulosMundiais() + 
//					", '" + s.getConfederacao() + 
//					"', '" + s.getTecnico() + 
//					"', '"+  sdf.format( s.getData() ) + "')";
//			stmt.executeUpdate( sql );
//			System.out.println( sql );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Selecao> pesquisarPorPais(String pais) {
		List<Selecao> selecoes = new ArrayList<>();
		try {
			String sql = 
				"select * from selecao WHERE pais like ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setString(1, "%" + pais + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Selecao s = new Selecao();
				s.setPais( rs.getString("pais")  );
				s.setGrupo( rs.getString("grupo")  );
				s.setConfederacao( rs.getString("confederacao")  );
				s.setTecnico( rs.getString("tecnico")  );
				s.setRankingFifa( rs.getInt("ranking") );
				s.setTitulosMundiais( rs.getInt("titulos") );
				s.setData( rs.getDate("estreia") );
				selecoes.add( s );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selecoes;
	}

}
