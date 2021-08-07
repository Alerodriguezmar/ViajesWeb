package com.viajesweb.services;

import java.util.List;
import com.viajesweb.models.History;

public interface IHistorialService {

	 List<History> listHistory();
	 
	 List<History> listHistoryCity(String cityName);
	 
	 List<History> listHistoryTourist(String identification);
}
