package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityUpdateImplDao implements CityUpdateDao{
	
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
	public String updateCity(String name, String countryCode, String district, int population, String oldName) {

		Connection conn = getConnection();
		String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE Name = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, countryCode);
			stmt.setString(3, district);
			stmt.setInt(4, population);
			stmt.setString(5, oldName);
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return "La citta e stata modificata";
	}

	

}
