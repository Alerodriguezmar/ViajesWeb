package com.viajesweb.services;

import java.util.List;
import com.viajesweb.models.Travel;

public interface ITravelService {

	List<Travel> listTravel();

	void addTravel(String identificationTourist, String nameCity, Travel travel, String dateTravel);

	void addTravelOptional(Travel travel);

	List<Travel> getCity(int id);

	List<Travel> getTourist(String identification);
}
