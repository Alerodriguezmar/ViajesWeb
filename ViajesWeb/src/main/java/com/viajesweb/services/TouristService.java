package com.viajesweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viajesweb.models.Tourist;
import com.viajesweb.respositories.TouristRepository;

@Service
public class TouristService implements ITouristService {

	@Autowired
	private TouristRepository touristRepository;
	
	/**
	 * Busca una turista por su identificador .
	 * 
	 * @param id indica el valor del indentificador a buscar en la tabla tourist.
	 * @return Una ciudad cuyo valor de id o identificador es igual a (id).
	 */
	@Override
	public Optional<Tourist> get(int id) {
		return touristRepository.findById(id);
	}

	/**
	 * Restorna todas los turistas existentes en la tabla tourist
	 * 
	 * @return Una lista de todos los turistas encontrados de lo cotrario retornara
	 *         una lista vacia.
	 */
	@Override
	public List<Tourist> listTourist() {
		return (List<Tourist>) touristRepository.findAll();
	}

	/**
	 * Se encarga de insertar un nuevo turista en la tabla tourist. En caso de que se
	 * encuentre el turista entonces la información se sobreescribe.
	 * 
	 * @param Tourist tourist Corresponde a la información de un nuevo turista a insertar.
	 */
	@Override
	public void addTourist(Tourist tourist) {
		touristRepository.save(tourist);

	}

	/**
	 * Elimina un turista en la tabla tourist por su identificador.
	 * 
	 * @param id identificador de un turista a eliminar en la tabla tourist
	 */
	@Override
	public void deleteTourist(Integer id) {
		touristRepository.deleteById(id);
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
	@Override
	public void updateTourist(Tourist tourist, Integer id) {
		touristRepository.findById(id).ifPresent(x -> {
			tourist.setIdTourist(id);
			touristRepository.save(tourist);
		});
	}
}
