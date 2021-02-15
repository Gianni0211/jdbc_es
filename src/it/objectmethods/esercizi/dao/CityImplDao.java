package it.objectmethods.esercizi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethods.esercizi.model.City;

public class CityImplDao implements CityDao {

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
	public City findCityByName(String name) {

		Connection conn = getConnection();
		City city = null;
		String sql = "SELECT * FROM city WHERE Name = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setId(rs.getLong("ID"));
				city.setCountry(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
				city.setDistrict(rs.getString("District"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	@Override
	public int addCity(City city) {
		int res = 0;
		Connection conn = getConnection();
		String sql = "INSERT INTO  city Value Name = ?, CountryCode = ?, District = ?, Population = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getName());
			stmt.setString(2, city.getCountry());
			stmt.setString(3, city.getDistrict());
			stmt.setInt(4, city.getPopulation());
			
			 res =stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deleteCityById(int id) {
		Connection conn = getConnection();
		int res = 0;
		String sql = "DELETE FROM city WHERE ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			res = stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateCity(City city, String oldName) {
		Connection conn = getConnection();
		int res = 0;
		String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE Name = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getName());
			stmt.setString(2, city.getCountry());
			stmt.setString(3, city.getDistrict());
			stmt.setInt(4, city.getPopulation());
			stmt.setString(5, oldName);
			res = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
