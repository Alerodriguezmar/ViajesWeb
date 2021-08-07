package com.viajesweb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.viajesweb.models.Travel;
import com.viajesweb.services.ITravelService;

@RestController
public class TravelController {
	
	@Autowired
	private ITravelService travelService;
	
	/**
	 * Restorna todas las asignaciones existentes entre una ciudad y un turista en
	 * la tabla travel
	 * 
	 * @return Una lista de todas las asignaciones encontradas de lo cotrario
	 *         retornara una lista vacia.
	 */
	@GetMapping("/viajes")
	public List<Travel> listTravel() {
		return travelService.listTravel();
	}
	
	/**
	 * Se encarga de asignar/insetar un viaje entre una ciudad y un turista en la
	 * tabla travel. En caso de que se encuentre ya una asignacion entonces se
	 * inserta como una nuev asignacion o viaje.
	 * 
	 * @param travel Corresponde a la información de una nueva asignacion/insercion
	 *               de un viaje a realizarse entre una ciduad y un turista;
	 */
	@PostMapping("/viajes")
	public void addCity(@RequestBody Travel travel) {
		travelService.addTravelOptional(travel);
	}
	
	/**
	 * Busca las asignaciones de viajes hechas para una ciudad.
	 * 
	 * @param id indica el valor del indentificador de una ciudad a buscar en la
	 *           tabla travel.
	 * @return todos los turistas cuyo indentificador de ciudad es el valor id.
	 */
	@GetMapping("/viajesCiudad/{idCity}")
	public List<Travel> listTravelCity(@PathVariable(value = "idCity") int idCity) {
		return travelService.getCity(idCity);
	}
	
	/**
	 * Busca las asignaciones de viajes hechas para una turista.
	 * 
	 * @param id indica el valor del indentificador de un turista a buscar en la
	 *           tabla travel.
	 * @return todas las ciudades cuyo indentificador de turista es la cuyo valor
	 *         id.
	 */
	@GetMapping("/viajesTurista/{identification}")
	public List<Travel> listTravelTourist(@PathVariable(value = "identification") String identification) {
		return travelService.getTourist(identification);
	}
	
	/**
	 * Se encarga de asignar/insetar un viaje entre una ciudad y un turista en la
	 * tabla travel. En caso de que se encuentre ya una asignacion entonces se
	 * inserta como una nueva asignacion o viaje.
	 * 
	 * @param identificationTourist indica el numero de identificacion de un turista
	 *                              por el cual va a ser buscado en la tabla tourist
	 * @param nameCity              indica el nombre de la ciudad por el cual se va
	 *                              a buscar en la tabla city
	 * @param dateTravel            indica la fecha la cual se va a realizar el
	 *                              viaje , se le asigna a aca travel.}
	 * @param travel                travel Corresponde a la información de una nueva
	 *                              asignacion la cual tomara los datos de las
	 *                              busquedas realizadas y si asignacion de fecha.
	 */
	@PostMapping("/viajes/{nameCity}/{identificationTourist}/{dateTravel}")
	public void addTravel(Travel travel, @PathVariable(value = "nameCity") String nameCity, 
			@PathVariable(value = "identificationTourist") String nameidentificationTourist,
			@PathVariable(value = "dateTravel") String dateTravel) {
		travelService.addTravel(nameidentificationTourist, nameCity, travel, dateTravel);
	}				
}


