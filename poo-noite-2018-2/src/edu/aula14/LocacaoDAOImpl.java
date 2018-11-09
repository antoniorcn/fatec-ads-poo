package edu.aula14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDAOImpl implements LocacaoDAO {
	private static String url = 
			"jdbc:mariadb://localhost:3306/bicicleta?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";
	
	public LocacaoDAOImpl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(LocacaoBicicleta l) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			String sql = "INSERT INTO locacao "
					+ " (nome_cliente, modelo, data, preco) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, l.getNomeCliente());
			stmt.setString(2, l.getModeloBike());
			long timestamp = l.getDataLocacao().getTime();  //java.util.Date
			java.sql.Date sqld = new java.sql.Date( timestamp );
			stmt.setDate(3, sqld); // java.sql.Date
			stmt.setFloat(4,  l.getPreco());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<LocacaoBicicleta> pesquisarPorNomeCliente(String nomeCliente) {
		List<LocacaoBicicleta> lista = new ArrayList<>();
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM locacao "
					+ " WHERE nome_cliente LIKE ?";			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nomeCliente + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LocacaoBicicleta l = new LocacaoBicicleta();
				l.setNomeCliente(rs.getString("nome_cliente"));
				l.setModeloBike(rs.getString("modelo"));
				l.setPreco(rs.getFloat("preco"));
				l.setDataLocacao(rs.getDate("data"));
				lista.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
