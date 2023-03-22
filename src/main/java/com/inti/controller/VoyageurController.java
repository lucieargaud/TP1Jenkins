package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.inti.model.Voyageur;
import com.inti.repository.IVoyageurRepository;

@Controller
@RequestMapping("voyageur")
public class VoyageurController {
	
	@Autowired
	IVoyageurRepository ivr;
	
	@GetMapping("ajoutV")
	public String ajoutVoyageur()
	{
		return"formVoyageur";
	}
	@PostMapping("saveV")
	public String saveVoiture(@ModelAttribute ("voyageur") Voyageur v)
	{
		 ivr.save(v);
			
		return "redirect:/ajoutVoyageur";
	}
	
	@GetMapping("listeV")
	public String listeVoyageur(Model m)
	{
	    m.addAttribute("listeV",ivr.findAll());
		return"listeV";
	}
	
	@GetMapping("getVoyageur")
	public String getVoyageur(@RequestParam("id") long id, Model m)
	{
		Voyageur v = ivr.findById(id).get();
		
		m.addAttribute("voyageur", v);
		return"afficherVoyageur";
	}
	
	@GetMapping("delete/{id}")
	public String deleteVoyageur(@PathVariable("id") long id)
	{
		ivr.deleteById(id);
		
		return "redirect:/listeV";
	}
	
	@GetMapping("update/{id}")
	public String ModifVoyageur(@PathVariable("id") long id, Model m)
	{
		m.addAttribute("voiture",ivr.getReferenceById(id));
		
		return "modifVoyageur";
	}
	
	@PostMapping("modifV")
	public String updateVoyageur(@ModelAttribute ("voy") Voyageur v)
	{
		//comme saveOrUpdate
		 ivr.save(v);
			
		return "redirect:/listeV";
	}

	

}
