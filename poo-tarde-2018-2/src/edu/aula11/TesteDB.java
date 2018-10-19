package edu.aula11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDB {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mariadb://localhost:3306/pootarde";
			String user = "root";
			String pass = "";
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
