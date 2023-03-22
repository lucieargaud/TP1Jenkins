package com.inti.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table
@Data@NoArgsConstructor@AllArgsConstructor
public class Voyageur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVoyageur;
	private String nom;
	private String prenom;
	private int age;
	
	
	public Voyageur(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	

}
