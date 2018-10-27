package edu.aula12;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TesteDB {
	private static String url = 
			"jdbc:mariadb://localhost:3306/bicicleta";
	private static String user = "root";
	private static String pass = "";
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada");
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado no DB");
			
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO locacao "
					+ " (nome_cliente, modelo, data, preco) "
					+ " VALUES ('Rafael', 'Caloi', '2018-10-25', 12.0)";
			int i = stmt.executeUpdate(sql);
			System.out.printf("Locacao inseridam foram inseridas %d linhas\n", i);
			
			String query = "SELECT * FROM locacao";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) { 
				System.out.printf("Cliente: %s  Modelo: %s \n", 
							rs.getString("nome_cliente"),
							rs.getString("modelo"));
			}
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
