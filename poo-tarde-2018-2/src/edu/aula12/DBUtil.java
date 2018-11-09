package edu.aula12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static DBUtil instancia;
	private Connection con;
	
	private DBUtil() { 
		String url = "jdbc:mariadb://localhost:3306/escola?allowMultiQueries=true";
		String user = "root";
		String pass = "";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static DBUtil getInstance() { 
		if (instancia == null) { 
			instancia = new DBUtil();
		}
		return instancia;
	}
	
	public Connection getConnection() { 
		return con;
	}

}
