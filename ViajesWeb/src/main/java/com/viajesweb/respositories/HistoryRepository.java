package com.viajesweb.respositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.viajesweb.models.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Integer> {
	
	List<History> findByNameCity(String nameCity);
	
	List<History> findByIdentificationTuorist(String identification);		
}
