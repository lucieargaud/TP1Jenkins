package com.inti.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Destination;
import com.inti.repository.IDestinationRepository;

@WebMvcTest(controllers = DestinationController.class)
public class DestinationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IDestinationRepository ier;

	
	@Test
	public void readDestinationTest() {
		try {
			mockMvc.perform(get("/destination/read")).andExpect(status().isOk())
					.andExpect(view().name("readDestination")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createDestinationTest() {
		try {
			mockMvc.perform(get("/destination/create")).andExpect(status().isOk())
					.andExpect(view().name("createDestination")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void saveDestinationTest() {
		try {
			mockMvc.perform(post("/destination/create").sessionAttr("destination", new Destination(150, 160)))
					.andExpect(status().is3xxRedirection()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateDestinationTest() {
		try {
			mockMvc.perform(get("/destination/update/1")).andExpect(status().isOk())
					.andExpect(view().name("updateEntreprise")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDestinationTest() {
		try {
			mockMvc.perform(get("/destination/delete/1")).andExpect(status().is3xxRedirection())
					.andExpect(redirectedUrl("/destination/read")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
