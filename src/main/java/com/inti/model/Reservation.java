package com.inti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Reservation {

	private long idVoyageur;
	private LocalDate dateReservation;
	private int nbJours;
	
	
	public Reservation(LocalDate dateReservation, int nbJours) {
		super();
		this.dateReservation = dateReservation;
		this.nbJours = nbJours;
	}
	
}
