package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Avis;
import com.inti.repository.IAvisRepository;

@Controller
@RequestMapping("avis")
public class AvisController {
	@Autowired
	IAvisRepository iar;
	
	
			@GetMapping("ajout")
			public String formAvis() {
				return "formAvis";
			}

			@PostMapping("saveA")
			public String saveAvis(@ModelAttribute("avis") Avis a) {
				iar.save(a);
				return "redirect:/avis/liste";
			}
			// Afficher la liste
			@GetMapping("liste")
			public String listeAvis(Model m) {
				m.addAttribute("listeAvis", iar.findAll());
				return "listeAvis";
			}
			
			// Supprimer
			@GetMapping("delete")
			public String deleteAvis(@RequestParam("id") long id) {
				iar.deleteById(id);
				return "redirect:/avis/liste";
			}
			
			// Modifier
			@GetMapping("modifier")
			public String modifieAvis(@RequestParam("id") long id, Model m)
			{
				m.addAttribute("avis", iar.findById(id).get());
				return "modifierAvis";
			}
			
			@PostMapping("update")
			public String updateAvis(@ModelAttribute("avis") Avis a)
			{
				iar.save(a);
				return "redirect:/avis/liste";
			}
			


}
