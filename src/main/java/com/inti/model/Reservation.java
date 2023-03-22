package com.inti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReservation;
	private LocalDate dateReservation;
	private int nbJours;
	
	
	public Reservation(LocalDate dateReservation, int nbJours) {
		super();
		this.dateReservation = dateReservation;
		this.nbJours = nbJours;
	}
	
}
