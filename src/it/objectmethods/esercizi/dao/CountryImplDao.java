package it.objectmethods.esercizi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethods.esercizi.model.Country;

public class CountryImplDao implements CountryDao{

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
	public Country findCountryByNameAndContinent(String name, String continent) {

		Connection conn = getConnection();
		Country country = null;
		String sql = "SELECT * FROM country WHERE Name = ? AND Continent = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, continent);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				country = new Country();
				country.setName(rs.getString("Name"));
				country.setCountryCode(rs.getString("Code"));
				country.setContinent(rs.getString("Continent"));
				country.setSurfaceArea(rs.getFloat("SurfaceArea"));
				country.setPopulation(rs.getLong("Population"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return country;
	}
	}
