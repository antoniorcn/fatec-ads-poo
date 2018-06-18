package edu.curso.aula10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String urldb = "jdbc:mariadb://localhost:3306/poonoite";
			Connection con = 
				DriverManager.getConnection( urldb, "root", "");
			System.out.println("Conectado...");
			Statement stmt = con.createStatement();
			String sql = "insert into alunos (nome, ra, nascimento) "
					+ "values ('Antenogenes', '000002', '2000-08-04');";
//			String sql = "create table alunos (	nome char(50), ra char(20),	nascimento date );";
			int i = stmt.executeUpdate( sql );
			System.out.printf("Insert executado, foram criados %d registros\n", i);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
