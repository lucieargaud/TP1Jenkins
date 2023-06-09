package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;

@Controller
@RequestMapping("hotel")
public class HotelController {
	
	@Autowired
	IHotelRepository ihr; 
	
	// Enregistrer via un formulaire
	@GetMapping("formHotel")
	public String formHotel()
	{
		return("formhotel");
	}
	
	@PostMapping("saveH")
	public String saveHotel(@ModelAttribute("hotel") Hotel h)
	{
		ihr.save(h);
		return("redirect:/hotel/formHotel");
	}
	
	
	// Afficher la liste
	@GetMapping("listeHotel")
	public String listeHotel(Model m) 
	{
		m.addAttribute("listeH", ihr.findAll());
		return "listeHotel";
	}
}
