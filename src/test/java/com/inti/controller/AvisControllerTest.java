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

import com.inti.model.Avis;
import com.inti.repository.IAvisRepository;


@WebMvcTest(controllers = AvisController.class)
public class AvisControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IAvisRepository iar;


	@Test
	public void ajoutAvisTest() {
		try {
			mockMvc.perform(get("/avis/ajout")).andExpect(status().isOk())
					.andExpect(view().name("formAvis")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void saveAvisTest() {
		try {
			mockMvc.perform(post("/avis/saveA").sessionAttr("avis", new Avis("Bon hotel")))
					.andExpect(status().is3xxRedirection()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void modifierAvisTest() {
		try {
			mockMvc.perform(get("/avis/modifier/1")).andExpect(status().isOk())
					.andExpect(view().name("update")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteAvisTest() {
		try {
			mockMvc.perform(get("/avis/delete/1")).andExpect(status().is3xxRedirection())
					.andExpect(redirectedUrl("/avis/ajout")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
