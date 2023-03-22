package com.inti.controller;

import java.time.LocalDate;

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
		public String saveReservation(@RequestParam("dateReservation") String dateR, @RequestParam("nbJours") int nbJours) {
			irr.save(new Reservation(LocalDate.parse(dateR), nbJours));
			return "redirect:/reservation/liste";
		}
		// Afficher la liste
		@GetMapping("liste")
		public String listeReservation(Model m) {
			m.addAttribute("listeR", irr.findAll());
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
			return "updateReservation";
		}
		
		@PostMapping("update")
		public String updateReservation(@RequestParam("idReservation") long idR, @RequestParam("dateReservation") String dateR, @RequestParam("nbJours") int nbJours)
		{
			irr.save(new Reservation(idR, LocalDate.parse(dateR), nbJours));
			return "redirect:/reservation/liste";
		}
		

		
}
