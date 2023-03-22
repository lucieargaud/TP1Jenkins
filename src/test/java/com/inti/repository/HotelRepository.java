package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Destination;
import com.inti.model.Hotel;

@ExtendWith(SpringExtension.class) // etendre les proprietes de junit à spring 
@DataJpaTest // annuler les requetes apres utilisation
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // config une BDD
public class HotelRepository {
	
	@Autowired
	IHotelRepository ihr;
	Hotel h;

	
	@BeforeEach
	public void setUp() {
		h = new Hotel("nomhoteltest", 2500);
	}
	
	@Test
	public void saveTest() {
		// Given

		// When
		Hotel hotelsauvegarde = ihr.save(h);
		// Then
		assertThat(hotelsauvegarde).isNotNull();
		assertThat(hotelsauvegarde.getIdHotel()).isGreaterThan(0);
	}
}
