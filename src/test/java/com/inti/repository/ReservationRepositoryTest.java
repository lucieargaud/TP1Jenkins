//package com.inti.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.inti.model.Reservation;
//import com.inti.repository.IReservationRepository;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ReservationRepositoryTest {
//
//	@Autowired
//	IReservationRepository irr;
//	Reservation r;
//	Reservation savedR;
//	
//	@BeforeEach
//	public void setUtp()
//	{
//		System.out.println("Begin : " + LocalDateTime.now());
//		r = new Reservation(LocalDate.parse("2020-12-06"), 4);
//		savedR = irr.save(r);
//		
//	}
//	
//	@Test
//	public void saveReservation()
//	{
//		// Given
//		
//		// When
//		
//		// Then
//		assertThat(savedR).isNotNull();
//		assertThat(savedR.getIdReservation()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void modifyReservation()
//	{
//		// Given
//		r.setNbJours(2);
//		
//		// When
//		savedR = irr.save(r);
//		// Then
//		assertThat(savedR.getNbJours()).isEqualTo(r.getNbJours());
//	}
//	
//	@Test
//	public void deleteReservation()
//	{
//		// Given déjà dans le setup
//		// When
//		irr.delete(savedR);
//		// Then
//		Assertions.assertThrows(Exception.class, ()-> irr.getReferenceById(savedR.getIdReservation()));	
//	}
//	
//	@Test
//	public void getAllEntreprise()
//	{
//		// Given déjà dans le setup
//		irr.save(new Reservation(LocalDate.parse("2023-05-13"), 3));
//		Reservation r1= irr.save(new Reservation(LocalDate.parse("2019-08-22"), 5));
//		// When
//		List<Reservation> listeR = irr.findAll();
//		// Then
//		assertThat(listeR).isNotEmpty();
//		assertThat(listeR).hasSize(3);
//		assertThat(listeR.get(0).getClass()).hasSameClassAs(Reservation.class);
//		assertThat(listeR.get(2).toString()).hasToString(r1.toString());
//	}
//	
//	@AfterEach
//	public void end()
//	{
//		System.out.println("End : " + LocalDateTime.now());
//	}
//	
//}
