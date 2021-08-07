package com.viajesweb.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * La clase City representa una ciudad. La ciudad representara un lugar al cual
 * se podra viajar.
 * 
 * @author Diego Rodriguez
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "City")
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_city")
	private int idCity;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "amount_population")
	private int amountPopulation;

	@Column(name = "touristic_place")
	private String touristicPlace;

	@Column(name = "reserved_hotel")
	private String reservedHotel;

	@JsonIgnore
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<Travel> travel;
}
