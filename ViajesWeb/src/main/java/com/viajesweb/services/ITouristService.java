package com.viajesweb.services;

import java.util.List;
import java.util.Optional;

import com.viajesweb.models.Tourist;

public interface ITouristService {

	Optional<Tourist> get(int id);

	List<Tourist> listTourist();

	void addTourist(Tourist tourist);

	void updateTourist(Tourist tourist, Integer id);

	void deleteTourist(Integer id);
}
