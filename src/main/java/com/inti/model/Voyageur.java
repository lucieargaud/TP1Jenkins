package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
