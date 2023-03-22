package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.inti.model.Voyageur;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class IVoyageurRepositoryTest {
	
	Voyageur v;
	Voyageur savedVoyageur;
	
	@Autowired
	IVoyageurRepository ivr;
	
	@BeforeEach
	public void setUp()
	{
	    v = new Voyageur("Durant", "Daniel", 34) ;
	    savedVoyageur = ivr.save(v);
	   
	}
	
	@Test
	public void saveTest()
	{
	//Given : dans le setUp
	
	//When
		Voyageur savedVoyageur = ivr.save(v);
	//Then
		assertThat(savedVoyageur).isNotNull();
		assertThat(savedVoyageur.getIdVoyageur()).isGreaterThan(0);
	}
	
	@Test
	public void getTest()
	{
		//Given : dans le setUp
		   Voyageur savedVoyageur = ivr.save(v);
		
		//When
			Voyageur getVoyageur = ivr.getReferenceById(v.getIdVoyageur());
		//Then
			
			assertThat(getVoyageur).isNotNull();
			assertThat(getVoyageur.getIdVoyageur()).isEqualTo(savedVoyageur.getIdVoyageur());
			assertThat(getVoyageur.getNom()).isEqualTo(savedVoyageur.getNom());
			assertThat(getVoyageur.getPrenom()).isEqualTo(savedVoyageur.getPrenom());
			assertThat(getVoyageur.getAge()).isEqualTo(savedVoyageur.getAge());
			assertThat(getVoyageur).isEqualTo(savedVoyageur);
			
			
	}
	
	@Test
	public void deleteTest()
	{
		//Given : dans le setUp
		
		//When

		ivr.delete(savedVoyageur);
				
		//Then 
		Assertions.assertThrows(Exception.class,() -> ivr.getReferenceById(savedVoyageur.getIdVoyageur()));
			
			
	}
	
	@Test
	public void updateTest()
	{
		//When
		savedVoyageur.setNom("Blaise");
		savedVoyageur.setPrenom("Louis");
		savedVoyageur.setAge(30);
		
		Voyageur voyageurModified = ivr.save(savedVoyageur);
		
		//Then
		assertThat(voyageurModified).isNotNull();
		assertThat(voyageurModified.getNom()).isEqualTo("Blaise");
		assertThat(voyageurModified.getPrenom()).isEqualTo("Louis");
		assertThat(voyageurModified.getAge()).isEqualTo(30);
		
	}
	
	@Test
	public void getAllSalarie()
	{
		//Given
		Voyageur v3 = ivr.save(new Voyageur("Margaud", "Steph", 42));
		Voyageur v4 = ivr.save(new Voyageur("Durand", "Patrick", 28));
		
		//When
		List<Voyageur> listeV = ivr.findAll();
		
		// Then
		//Verifie que la liste existe
		assertThat(listeV).isNotEmpty();
		//Verifie que la taille de la liste est de 3
		assertThat(listeV).hasSize(3);
		//On recupère le 1e objet savedSalarie et on verifie qu'il appartient à la classe Salarie
		assertThat(listeV.get(0).getClass()).hasSameClassAs(Voyageur.class);
		assertThat(listeV.get(1).toString()).hasToString(v3.toString());
	}

}
