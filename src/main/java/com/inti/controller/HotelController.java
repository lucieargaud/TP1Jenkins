package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;

@Controller
@RequestMapping("controller")
public class HotelController {
	
	@Autowired
	IHotelRepository ihr; 
	
	@GetMapping("formHotel")
	public String formHotel()
	{
		return("hotel");
	}
	
	@PostMapping("saveHotel")
	public String saveHotel(@ModelAttribute("hotel") Hotel h)
	{
		ihr.save(h);
		return("redirect:/reservation/liste");
	}
	
}
