package it.objectmethods.esercizi.dao;

import it.objectmethods.esercizi.model.Country;

public interface CountryDao {

	public Country findCountryByNameAndContinent(String name, String continent);
}
