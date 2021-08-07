package com.viajesweb.services;

import java.util.List;
import java.util.Optional;

import com.viajesweb.models.City;

public interface ICityService {

	Optional<City> get(int id);

	City getCityname(String nameCity);

	List<City> listCity();

	void addCity(City city);

	void updateCity(City city, int id);

	void deleteCity(Integer id);
}
