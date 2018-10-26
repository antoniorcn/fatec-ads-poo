package edu.aula12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mariadb://localhost:3306/escola";
			String user = "root";
			String pass = "";
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado");
			String sql = "INSERT INTO alunos "
					+ " (id, nome, ra, nascimento, email, curso, altura) "
					+ " VALUES (0, 'Gabriel Silva', '00002', '1980-07-03', "
					+ " 'antoniorcn@hotmail.com', 'ads', 1.72)";

			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("Aluno inserido com sucesso retorno : " + i);
			
			// Fazer a consulta
			String query = "SELECT * FROM alunos;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) { 
				String ra = rs.getString("ra");
				String nome = rs.getString("nome");
				System.out.printf("RA: %s   Nome:%s \n", ra, nome);
			}
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
