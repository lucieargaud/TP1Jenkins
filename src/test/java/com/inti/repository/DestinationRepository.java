package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Destination;

@ExtendWith(SpringExtension.class) // etendre les proprietes de junit à spring
@DataJpaTest // annuler les requetes apres utilisation
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // config une BDD
public class DestinationRepository {

	@Autowired
	IDestinationRepository idr;

	Destination d;

	@BeforeEach
	public void setUp() {
		d = new Destination(1500, 2500);
	}

	@Test
	public void saveTest() {
		// Given

		// When
		Destination savedDesti = idr.save(d);
		// Then
		assertThat(savedDesti).isNotNull();
		assertThat(savedDesti.getIdDestination()).isGreaterThan(0);
	}

	@Test
	public void getDestinationTest() {
		// Given
		Destination savedDestination = idr.save(d);
		// When
		Destination d2 = idr.getReferenceById(savedDestination.getIdDestination());
		// Then
		assertThat(d2).isNotNull();
		assertThat(d2.getIdDestination()).isEqualTo(savedDestination.getIdDestination());
		assertThat(d2.getLongitude()).isEqualTo(savedDestination.getLongitude());
		assertThat(d2.getLatitude()).isEqualTo(2500);
		assertThat(d2).isEqualTo(savedDestination); // on peut juste faire cette ligne
	}

	@Test
	public void getAllDestinationTest() {
		// Given
		Destination savedDestination = idr.save(d);
		Destination d3 = idr.save(new Destination(3000, 5000));
		Destination d4 = idr.save(new Destination(741852, 963852));
		// When
		List<Destination> listeD = idr.findAll();

		// Then
		assertThat(listeD).isNotEmpty();
		assertThat(listeD).hasSize(3);
		assertThat(listeD.get(0).getClass()).hasSameClassAs(Destination.class);
		assertThat(listeD.get(1).toString()).hasToString(d3.toString());
	}

	@Test
	public void updateTest() {
		// Given
		Destination savedDestination = idr.save(d);
//			Salarie s1 = new Salarie(savedSalarie.getId(), "Martin", "Mickael", "email.com");
		// When
//			Salarie s2 = isr.save(s1);

		savedDestination.setLongitude(123456);
		savedDestination.setLatitude(789456);
		
		Destination destinationModif = idr.save(savedDestination);

		// Then
//			assertThat(s2).isNotNull();
//			assertThat(s2.getId()).isEqualTo(savedSalarie.getId());

		assertThat(destinationModif).isNotNull();
		assertThat(destinationModif.getLongitude()).isEqualTo(123456);
		assertThat(destinationModif.getLatitude()).isEqualTo(789456);
	}

	@Test
	public void deleteTest() {
		// Given
		Destination savedDestination = idr.save(d);
		// When
		idr.deleteById(savedDestination.getIdDestination());
		// Then
		Assertions.assertThrows(Exception.class, () -> idr.getReferenceById(savedDestination.getIdDestination()));
	}

}
