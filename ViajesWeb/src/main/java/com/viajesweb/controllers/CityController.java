package com.viajesweb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.viajesweb.models.City;
import com.viajesweb.services.ICityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CityController {

	@Autowired
	private ICityService cityservice;

	/**
	 * Restorna todas las Ciudades existentes en la tabla city
	 * 
	 * @return Una lista de todas las ciudades encontradas de lo cotrario retornara
	 *         una lista vacia.
	 */
	@GetMapping("/ciudades")
	public List<City> listCity() {
		return cityservice.listCity();
	}

	/**
	 * Busca una ciudad por su identificador .
	 * 
	 * @param id indica el valor del indentificador a buscar en la tabla city.
	 * @return Una ciudad cuyo valor de id o identificador es igual a (id).
	 */
	@GetMapping("/ciudad/{id}")
	public Optional<City> getOne(@PathVariable(value = "id") Integer id) {
		return cityservice.get(id);
	}

	/**
	 * Elimina una ciudad en la tabla city por su identificador.
	 * 
	 * @param id identificar de la ciudad a eliminar en la tabla city
	 */
	@DeleteMapping(value = "/ciudad/{id}")
	public void deleteCity(@PathVariable("id") Integer id) {
		cityservice.deleteCity(id);
	}

	/**
	 * Se encarga de insertar una nueva ciudad en la base de datos. En caso de que
	 * encuentre que la ciudad ya existe entonces la información se sobreescribe.
	 * 
	 * @param ciudad Corresponde a la información de la nueva ciudad a insertar.
	 */
	@PostMapping("/ciudad")
	public void addCity(@RequestBody City city) {
		cityservice.addCity(city);
	}

	/**
	 * Actualiza una ciudad en la tabla city sobreescribiendo la informacion
	 * 
	 * @param city corresponde a la nueva información que va a tomar la ciudad ya
	 *             existente
	 */
	@PutMapping("/ciudad")
	public void updateCity(@RequestBody City city) {
		cityservice.addCity(city);
	}

	/**
	 * Busca una ciudad por su Nombre .
	 * 
	 * @param nameCity indica el nombre de la ciudad a buscar en la tabla city.
	 * @return Una ciudad cuyo nombre es igual a (nameCity) de lo contrario retorna
	 *         vacio.
	 */
	@GetMapping("/ciudades/{name}")
	public City searchNameCity(@PathVariable(value = "name") String name) {
		return cityservice.getCityname(name);
	}
}
