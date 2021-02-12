package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityAddImplDao implements CityAddDao{

	private Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8081/world", "omdev", "omdev");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public String addCity(String name, String countryCode, String district, int population, int id) {
		
		Connection conn = getConnection();
		String sql = "INSERT INTO  city SET Name = ?, CountryCode = ?, District = ?, Population = ?, ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, countryCode);
			stmt.setString(3, district);
			stmt.setInt(4, population);
			stmt.setInt(5, id);
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return "La citta e stata aggiunta";
	
	}
}
