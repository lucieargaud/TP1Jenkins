package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Reservation;
import com.inti.repository.IReservationRepository;

@Controller
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	IReservationRepository irr;
	
	// Enregistrer via un formulaire
		@GetMapping("form")
		public String formReservation() {
			return "formReservation";
		}

		@PostMapping("save")
		public String saveReservation(@ModelAttribute("reservation") Reservation r) {
			irr.save(r);
			return "redirect:/reservation/liste";
		}
		// Afficher la liste
		@GetMapping("liste")
		public String listeReservation(Model m) {
			m.addAttribute("listeReservation", irr.findAll());
			return "listeReservation";
		}
		
		// Supprimer
		@GetMapping("delete")
		public String deleteReservation(@RequestParam("id") long id) {
			irr.deleteById(id);
			return "redirect:/reservation/liste";
		}
		
		// Modifier
		@GetMapping("modifier")
		public String modifieReservation(@RequestParam("id") long id, Model m)
		{
			m.addAttribute("reservation", irr.findById(id).get());
			return "modifierReservation";
		}
		
		@PostMapping("update")
		public String updateReservation(@ModelAttribute("reservation") Reservation r)
		{
			irr.save(r);
			return "redirect:/reservation/liste";
		}
		

		
}
