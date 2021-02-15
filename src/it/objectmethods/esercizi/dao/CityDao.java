package it.objectmethods.esercizi.dao;

import it.objectmethods.esercizi.model.City;

public interface CityDao {

	public City findCityByName(String name);
	public int addCity(City city );
	public int deleteCityById(int id);
	public int updateCity(City city, String oldName);
}
