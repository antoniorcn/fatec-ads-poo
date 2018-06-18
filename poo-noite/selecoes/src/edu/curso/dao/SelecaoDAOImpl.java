package edu.curso.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.aula10.Selecao;
public class SelecaoDAOImpl implements SelecaoDAO {
	
	private Connection con;

	public SelecaoDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String urldb = "jdbc:mariadb://localhost:3306/selecoes?allowMultiQueries=true";
			con = DriverManager.getConnection( urldb, "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Selecao s) {
		try {
//			Statement stmt = con.createStatement();
//			String sql = "INSERT INTO selecao (pais, grupo, ranking, titulos, "
//					+ "confederacao, tecnico, estreia) VALUES ('" + 
//					s.getPais() + "', '" + 
//					s.getGrupo()+ "', " + 
//					s.getPosicaoRanking() + ", " + 
//					s.getTitulosMundiais() + ", '" + 
//					s.getConfederacao() + "', '" + 
//					s.getNomeTecnico() + "', '" + 
//					sdf.format(s.getDataEstreia()) + "')";
//			System.out.println( sql );
//			int i = stmt.executeUpdate(sql);
			String sql = "INSERT INTO selecao (pais, grupo, ranking, titulos, "
					+ "confederacao, tecnico, estreia) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setString(1, s.getPais());
			stmt.setString(2, s.getGrupo());
			stmt.setInt(3, s.getPosicaoRanking());
			stmt.setInt(4, s.getTitulosMundiais());
			stmt.setString(5,  s.getConfederacao());
			stmt.setString(6,  s.getNomeTecnico());
//			long mili = s.getDataEstreia().getTime();
//			java.sql.Date novaData = new java.sql.Date( mili );
//			stmt.setDate(7, novaData);
			stmt.setDate(7,  new java.sql.Date(s.getDataEstreia().getTime()));
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Selecao> pesquisaPorPais(String nomePais) {
		List<Selecao> lista = new ArrayList<>();
		try {
			String sql = "SELECT * from selecao WHERE pais like ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nomePais + "%");			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Selecao s = new Selecao();
				s.setPais( rs.getString("pais") );
				s.setGrupo( rs.getString("grupo") );
				s.setPosicaoRanking( rs.getInt("ranking") );
				s.setTitulosMundiais( rs.getInt("titulos") );
				s.setConfederacao( rs.getString("confederacao") );
				s.setNomeTecnico( rs.getString("tecnico") );
				s.setDataEstreia( rs.getDate("estreia") );
				lista.add( s );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
