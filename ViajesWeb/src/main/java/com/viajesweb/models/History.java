package com.viajesweb.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase almacena los datos de un viaje asignado junto a la hora de
 * creacion.
 * 
 * @author Diego Rodriguez
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historial")
public class History implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idHistory;

	@Column(name = "nombre_ciudad")
	private String nameCity;

	@Column(name = "nombre_turista")
	private String nameTuorist;

	@Column(name = "id_turista")
	private String identificationTuorist;

	@Column(name = "fecha_ingreso")
	private LocalDate admissionDate;
}
