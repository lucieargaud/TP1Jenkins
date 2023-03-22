package com.inti.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.inti.model.Voyageur;
import com.inti.repository.IVoyageurRepository;

@WebMvcTest(controllers = VoyageurController.class)
public class VoyageurControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IVoyageurRepository ivr;
	
	@Test
	@DisplayName("Test d'inscription d'un voyageur")
	public void ajoutVoyageur() throws Exception
	{
		try {
			mockMvc.perform(get("/ajoutV"))
			.andExpect(status().isOk())
			.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Test d'enregistrement d'un voyageur")
	public void enregistrementVoyageur() throws Exception
	{
		try {
			mockMvc.perform(post("/saveV").sessionAttr("voyageur", new Voyageur("Duprès", "Dan", 25)))
			.andExpect(status().is3xxRedirection())
			.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Test d'affichage de tous les voyageurs")
	public void getallVoyageur() throws Exception
	{
		try {
			mockMvc.perform(get("/listeV"))
			.andExpect(status().isOk())
			.andExpect(view().name("listeV"))
			.andExpect((ResultMatcher) content().string(containsString("Nom")))
			.andDo(print());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	@DisplayName("Test suppression d'un voyageur")
	public void deleteVoyageur() throws Exception
	{
		try {
			mockMvc.perform(get("/deleteV/1"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/listeV"))
			.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
