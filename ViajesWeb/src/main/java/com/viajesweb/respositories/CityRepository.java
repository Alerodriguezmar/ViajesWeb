package com.viajesweb.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.viajesweb.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

	City findBycityName(String nameCity);
}
