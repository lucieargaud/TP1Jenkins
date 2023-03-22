package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

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

}
