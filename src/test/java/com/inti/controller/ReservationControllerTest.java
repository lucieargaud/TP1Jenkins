package com.inti.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Reservation;
import com.inti.repository.IReservationRepository;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

	@Autowired
	private MockMvc mock;
	Reservation r1;
	
	@MockBean
	private IReservationRepository irr;
	
	@Test
	public void saveReservation() throws Exception
	{
		mock.perform(get("/reservation/form"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test enregistrement formulaire")
	public void enregistrementReservation() throws Exception
	{
		mock.perform(post("/reservation/save").param("dateReservation", "2023-04-12").param("nbJours", "5"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	public void allReservation() throws Exception
	{
		mock.perform(get("/reservation/liste"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test modification")
	public void modificationReservation() throws Exception
	{
		mock.perform(post("/reservation/save").param("idReservation", "1").param("dateReservation", "2023-04-12").param("nbJours", "7"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
//	@Test
//	public void supprReservation() throws Exception
//	{
//		mock.perform(get("/reservation/delete?id=8"))
//		.andExpect(status().is3xxRedirection())
//		.andDo(print());
//	}
}
