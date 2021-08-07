package com.viajesweb.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase travel representa un viaje a realizarse. cada viaje se compone por
 * una ciudad(City) destino y un turista(Tourist) el cual realizara uno o varios
 * viajes en un fecha determinada o no.
 * 
 * @author Diego Rodriguez
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Travel")
public class Travel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_travel")
	private int idTravel;

	@Column(name = "travel_date")
	private LocalDate travelDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tourist")
	private Tourist tourist;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_city")
	private City city;
}
