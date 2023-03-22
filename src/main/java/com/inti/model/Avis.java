package com.inti.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table @javax.persistence.Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Avis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String commentaire;

@OneToMany(mappedBy = "avis", targetEntity = Hotel.class)
private List<Hotel>listeHotel;


public Avis(String commentaire) {
	super();
	this.commentaire = commentaire;
}

}
