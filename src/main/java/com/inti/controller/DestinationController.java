package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.inti.model.Destination;
import com.inti.repository.IDestinationRepository;

@Controller
@RequestMapping("destination")
public class DestinationController {

	@Autowired
	IDestinationRepository idr;
	
	@GetMapping("create")
	public String createForm() {
		return "createDestination";
	}
	@PostMapping("create")
	public String create(@ModelAttribute("destination") Destination d) {
		idr.save(d);
		return "redirect:/destination/create";
	}
	
	@GetMapping("read")
	public String readForm(Model m) {
		List<Destination> listeD = idr.findAll();
		m.addAttribute("listeD", listeD);
		return "readDestination";
	}
	
	@GetMapping("update/{id}")
	public String updateForm(@PathVariable int id, Model m) {
		m.addAttribute("destination", idr.getReferenceById(id));
		return "updateDestination";
	}
	@PostMapping("update")
	public String update(@ModelAttribute("dest") Destination d) {
		idr.save(d);
		return "redirect:/destination/read";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		idr.delete(idr.getReferenceById(id));
		return "redirect:/destination/read";
	}
}
