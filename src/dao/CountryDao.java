package dao;

import model.Country;

public interface CountryDao {

	public Country findCountryByNameAndContinent(String name, String continent);
}
