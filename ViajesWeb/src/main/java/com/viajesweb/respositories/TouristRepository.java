package com.viajesweb.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.viajesweb.models.Tourist;

@Repository
public interface TouristRepository extends CrudRepository<Tourist, Integer> {

	Tourist findByIdentification(String identification);
}
