package edu.aula12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LocadoraBicicletaControl {
	private static String url = 
			"jdbc:mariadb://localhost:3306/bicicleta?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";
	public List<LocadoraBicicleta> locacoes = new ArrayList<>();
	
	public LocadoraBicicletaControl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionar(LocadoraBicicleta l) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO locacao "
					+ " (nome_cliente, modelo, data, preco) "
					+ " VALUES ('" + l.getNomeCliente() + "', "
						+ "'" + l.getModeloBike() +  "', "
						+ "'" + sdf.format(l.getDataLocacao()) + "', "
						+ l.getPreco() + ")";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		//locacoes.add(l);
	}
	
	public LocadoraBicicleta pesquisarPorNome(String nomeCliente) {
		LocadoraBicicleta l = new LocadoraBicicleta();
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM locacao "
					+ " WHERE nome_cliente LIKE '%" + nomeCliente + "%'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				l.setNomeCliente(rs.getString("nome_cliente"));
				l.setModeloBike(rs.getString("modelo"));
				l.setPreco(rs.getFloat("preco"));
				l.setDataLocacao(rs.getDate("data"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
