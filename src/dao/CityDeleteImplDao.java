package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityDeleteImplDao implements CityDeleteDao {

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
	public String deleteCityByName(String name) {
		Connection conn = getConnection();
		String sql = "DELETE FROM city WHERE Name = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);

			stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "La città è stata eleminata";
	}

}
