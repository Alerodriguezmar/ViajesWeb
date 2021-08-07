package com.viajesweb.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viajesweb.models.Travel;
import com.viajesweb.respositories.CityRepository;
import com.viajesweb.respositories.TouristRepository;
import com.viajesweb.respositories.TravelRepository;

import ch.qos.logback.classic.Logger;

@Service
public class TravelService implements ITravelService {
	
	private static Logger log;
	
	@Autowired
	private TravelRepository travelRepository;

	@Autowired
	private TouristRepository touristRepository;

	@Autowired
	private CityRepository cityrepository;

	/**
	 * Restorna todas las asignaciones existentes entre una ciudad y un turista en
	 * la tabla travel
	 * 
	 * @return Una lista de todas las asignaciones encontradas de lo cotrario
	 *         retornara una lista vacia.
	 */
	@Override
	public List<Travel> listTravel() {
		return (List<Travel>) travelRepository.findAll();
	}

	/**
	 * Se encarga de asignar/insetar un viaje entre una ciudad y un turista en la
	 * tabla travel. En caso de que se encuentre ya una asignacion entonces se
	 * inserta como una nuev asignacion o viaje.
	 * 
	 * @param travel Corresponde a la información de una nueva asignacion/insercion
	 *               de un viaje a realizarse entre una ciduad y un turista;
	 */
	@Override
	public void addTravelOptional(Travel travel) {
		int amountTourist = (int) travelRepository.countByTravelDateAndCity(travel.getTravelDate(), travel.getCity());
		if(amountTourist > 4) {
			log.warn("YA EXISTEN 5 VIAJES PARA ESA CIUDAD EN ESA FECHA DETERMINADA");
		} else {
			travelRepository.save(travel);
		}	
	}

	/**
	 * Busca las asignaciones de viajes hechas para una ciudad.
	 * 
	 * @param id indica el valor del indentificador de una ciudad a buscar en la
	 *           tabla travel.
	 * @return todos los turistas cuyo indentificador de ciudad es el valor id.
	 */
	@Override
	public List<Travel> getCity(int id) {
		return travelRepository.findByCityIdCity(id);
	}

	/**
	 * Busca las asignaciones de viajes hechas para una turista.
	 * 
	 * @param id indica el valor del indentificador de un turista a buscar en la
	 *           tabla travel.
	 * @return todas las ciudades cuyo indentificador de turista es la cuyo valor
	 *         id.
	 */
	@Override
	public List<Travel> getTourist(String identification) {
		return travelRepository.findByTouristIdentification(identification);
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
	public void addTravel(String identificationTourist, String nameCity, Travel travel, String dateTravel) {
		travel.setCity(cityrepository.findBycityName(nameCity));
		travel.setTourist(touristRepository.findByIdentification(identificationTourist));
		travel.setTravelDate(LocalDate.parse(dateTravel));
		travelRepository.save(travel);
	}
}
