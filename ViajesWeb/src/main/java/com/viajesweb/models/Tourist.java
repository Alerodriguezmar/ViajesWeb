package com.viajesweb.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase tourist representa un turista el cual se le podra asignar un destino
 * al cual podra viajar en una fecha determinada o no.
 * 
 * @author Diego Rodriguez
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tourist")
public class Tourist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tourist")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTourist;

	@Column(name = "tourist_name")
	private String touristName;

	@Column(name = "tourist_lastname")
	private String touristLastname;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "identification")
	private String identification;

	@Column(name = "type_id")
	private String typeId;

	@Column(name = "travel_frecuency")
	private int travelFrequency;

	@Column(name = "travel_budget")
	private Double travelBudget;

	@Column(name = "credit_card")
	private boolean creditCard;

	@JsonIgnore
	@OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL)
	private List<Travel> travel;
}
