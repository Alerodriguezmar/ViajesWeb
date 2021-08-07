package com.viajesweb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viajesweb.models.History;
import com.viajesweb.respositories.HistoryRepository;

@Service
public class HistoryService implements IHistorialService {

	@Autowired
	private HistoryRepository historyRepository;

	/**
	 * Restorna todas las asignaciones a viajes registradas en la tabla travel junto
	 * a su hora de ingreso
	 * 
	 * @return Una lista de todas las asignaciones encontradas de lo cotrario
	 *         retornara una lista vacia.
	 */
	@Override
	public List<History> listHistory() {
		return (List<History>) historyRepository.findAll();
	}

	/**
	 * Restorna todas las asignaciones de viajes registradas con el nombre de una
	 * ciudad en la tabla history junto a su hora de ingreso
	 * 
	 * @return Una lista de todas las asignaciones encontradas para una ciudad de lo
	 *         cotrario retornara una lista vacia.
	 */
	@Override
	public List<History> listHistoryCity(String cityname) {
		return historyRepository.findByNameCity(cityname);
	}

	/**
	 * Restorna todas las asignaciones de viajes registradas con el numero de identificacion de un
	 * turista en la tabla history junto a su hora de ingreso
	 * 
	 * @return Una lista de todas las asignaciones encontradas para un turista de lo
	 *         cotrario retornara una lista vacia.
	 */
	@Override
	public List<History> listHistoryTourist(String identification) {
		return historyRepository.findByIdentificationTuorist(identification);
	}
}



