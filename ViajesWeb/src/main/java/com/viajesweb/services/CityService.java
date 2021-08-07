package com.viajesweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajesweb.models.City;
import com.viajesweb.respositories.CityRepository;

@Service
public class CityService implements ICityService {

	@Autowired
	private CityRepository cityrepository;

	/**
	 * Busca una ciudad por su identificador .
	 * 
	 * @param id indica el valor del indentificador a buscar en la tabla city.
	 * @return Una ciudad cuyo valor de id o identificador es igual a (id).
	 */
	@Override
	public Optional<City> get(int id) {
		return cityrepository.findById(id);
	}

	/**
	 * Restorna todas las Ciudades existentes en la tabla city
	 * 
	 * @return Una lista de todas las ciudades encontradas de lo cotrario retornara
	 *         una lista vacia.
	 */
	@Override
	public List<City> listCity() {
		return (List<City>) cityrepository.findAll();
	}

	/**
	 * Se encarga de insertar una nueva ciudad en la tabla city. En caso de que se
	 * encuentre la ciudad entonces la información se sobreescribe.
	 * 
	 * @param City city Corresponde a la información de la nueva ciudad a insertar.
	 */
	@Override
	public void addCity(City city) {
		cityrepository.save(city);
	}

	/**
	 * Elimina una ciudad en la tabla city por su identificador.
	 * 
	 * @param id identificar de la ciudad a eliminar en la tabla city
	 */
	@Override
	public void deleteCity(Integer id) {
		cityrepository.deleteById(id);
	}

	/**
	 * Busca una ciudad por su Nombre .
	 * 
	 * @param nameCity indica el nombre de la ciudad a buscar en la tabla city.
	 * @return Una ciudad cuyo nombre es igual a (nameCity) de lo contrario retorna
	 *         vacio.
	 */
	@Override
	public City getCityname(String nameCity) {
		return cityrepository.findBycityName(nameCity);
	}

	/**
	 * Actualiza una ciudad existente en la tabla city buscandola por su
	 * identificador y luego sobre-escribiendo su informacion.
	 * 
	 * @param city Corresponde a la nueva información que va a tomar la ciudad ya
	 *             existente
	 * @param id   identificador de la ciudad a buscar para reemplazar o actualizar
	 *             su informacion.
	 */
	@Override
	public void updateCity(City city, int id) {
		cityrepository.findById(id).ifPresent( x -> {
			city.setIdCity(id);
			cityrepository.save(city);
		});
	}
}
