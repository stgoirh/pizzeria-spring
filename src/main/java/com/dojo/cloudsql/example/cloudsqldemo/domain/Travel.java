package com.dojo.cloudsql.example.cloudsqldemo.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Travel")
@Table(name = "travel")
public class Travel {
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "arrival_airport")
	private String arrivalAirport;
	@Column(name = "departure_airport")
	private String departureAirport;
	@Column(name = "flight_date")
	private LocalDate flightDate;
	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "pax_dni")
	private Pax pax;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
