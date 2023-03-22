package com.inti.model;

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
@Data @AllArgsConstructor @NoArgsConstructor
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHotel;
	private String nom; 
	private int nbEtoile;
	
	
	public Hotel(String nom, int nbEtoile) {
		super();
		this.nom = nom;
		this.nbEtoile = nbEtoile;
	} 
	
	

}
