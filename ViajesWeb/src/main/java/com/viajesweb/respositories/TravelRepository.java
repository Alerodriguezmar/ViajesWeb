package com.viajesweb.respositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.viajesweb.models.City;
import com.viajesweb.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Integer> {
	
	List<Travel> findByCityIdCity(int id);
	
	List<Travel> findByTouristIdentification(String identification);	
	
	long countByTravelDateAndCity(LocalDate date,City city);
}
