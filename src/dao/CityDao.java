package dao;

import model.City;

public interface CityDao {

	public City findCityByName(String name);
}
