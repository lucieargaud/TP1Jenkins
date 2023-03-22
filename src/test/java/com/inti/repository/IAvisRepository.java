package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Avis;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IAvisRepository {

	@Autowired
	IAvisRepository iar;
	Avis a;
	Avis savedAvis;

	@BeforeEach
	public void setUp() {
		a = new Avis("Bon hotel");
		
	}
	
	@Test
	public void saveTest()
	{
	//Given : voir setUp
	
	//When
		Avis savedAvis = iar.save(a);
	//Then
		assertThat(savedAvis).isNotNull();
		assertThat(savedAvis.getId()).isGreaterThan(0);
	}
	
	@Test
	public void updateTest()
	{
		//When
		savedAvis.setCommentaire("Bon hotel, personnels accueillants");
		
		Avis avisModified = iar.save(savedAvis);
		
		//Then
		assertThat(avisModified).isNotNull();
		assertThat(avisModified.getCommentaire()).isEqualTo("Bon hotel, personnels accueillants");
	
	}
	
	@Test
	public void deleteTest()
	{
		//Given : voir setUp
		
		//When

		iar.delete(savedAvis);
				
		//Then 
		Assertions.assertThrows(Exception.class,() -> iar.getReferenceById(savedAvis.getIdAvis()));
			
}
	@AfterEach
	public void end()
	{
		System.out.println("Fin");
	}
	
}
