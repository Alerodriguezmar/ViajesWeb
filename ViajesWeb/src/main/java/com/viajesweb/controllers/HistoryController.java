package com.viajesweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.viajesweb.models.History;

import com.viajesweb.services.IHistorialService;

@RestController
public class HistoryController {
	
	@Autowired
	private IHistorialService serviceoHistory;
	
	/**
	 * Restorna todas las asignaciones a viajes registradas en la tabla travel junto
	 * a su hora de ingreso
	 * 
	 * @return Una lista de todas las asignaciones encontradas de lo cotrario
	 *         retornara una lista vacia.
	 */
	@GetMapping("/historial")
	public List<History> listHistory() {
		return serviceoHistory.listHistory();
	}
	
	/**
	 * Restorna todas las asignaciones de viajes registradas con el nombre de una
	 * ciudad en la tabla history junto a su hora de ingreso
	 * 
	 * @return Una lista de todas las asignaciones encontradas para una ciudad de lo
	 *         cotrario retornara una lista vacia.
	 */
	@GetMapping("/historial/ciudad/{nameCity}")
	public List<History> listHistoyCity(@PathVariable(value = "nameCity") String nameCity) {
		return serviceoHistory.listHistoryCity(nameCity);
	}
	
	/**
	 * Restorna todas las asignaciones de viajes registradas con el numero de identificacion de un
	 * turista en la tabla history junto a su hora de ingreso
	 * 
	 * @return Una lista de todas las asignaciones encontradas para un turista de lo
	 *         cotrario retornara una lista vacia.
	 */
	@GetMapping("/historial/turista/{identification}")
	public List<History> listHistoTourist(@PathVariable(value = "identification") String identification) {
		return serviceoHistory.listHistoryTourist(identification);
	}
}
