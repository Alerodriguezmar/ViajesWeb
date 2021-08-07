package com.viajesweb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.viajesweb.models.Tourist;
import com.viajesweb.services.ITouristService;

@RestController
public class TouristController {

	@Autowired
	private ITouristService touristService;
	
	/**
	 * Restorna todos los turistas existentes en la tabla tourist
	 * 
	 * @return Una lista de todos los turistas encontrados de lo cotrario retornara
	 *         una lista vacia.
	 */
	@GetMapping("/turistas")
	public List<Tourist> listTourist() {
		return touristService.listTourist();
	}

	/**
	 * Busca una turista por su identificador .
	 * 
	 * @param id indica el valor del indentificador a buscar en la tabla tourist.
	 * @return Una ciudad cuyo valor de id o identificador es igual a (id).
	 */
	@GetMapping("/turista/{id}")
	public Optional<Tourist> getOne(@PathVariable(value = "id") Integer id) {
		return touristService.get(id);
	}

	/**
	 * Elimina un turista en la tabla tourist por su identificador.
	 * 
	 * @param id identificador de un turista a eliminar en la tabla tourist
	 */
	@DeleteMapping(value = "/turista/{id}")
	public void deleteTourist(@PathVariable("id") Integer id) {
		touristService.deleteTourist(id);
	}

	/**
	 * Se encarga de insertar un nuevo turista en la tabla tourist. En caso de que se
	 * encuentre el turista entonces la información se sobreescribe.
	 * 
	 * @param Tourist tourist Corresponde a la información de un nuevo turista a insertar.
	 */
	@PostMapping("/turista")
	public void addTourist(@RequestBody Tourist tourist) {
		touristService.addTourist(tourist);
	}
	
	/**
	 * Actualiza un turista existente en la tabla tourist buscandolo por su
	 * identificador y luego sobre-escribiendo su informacion.
	 * 
	 * @param city Corresponde a la nueva información que va a tomar el turista ya
	 *             existente
	 * @param id   identificador de el turista a buscar para reemplazar o actualizar
	 *             su informacion.
	 */
	@PutMapping("/turistas/{id}")
	public void updateTourist(Tourist tourist, @PathVariable(value = "id") Integer id) {
		touristService.updateTourist(tourist, id);
	}	
}
