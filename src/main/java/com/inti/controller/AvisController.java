package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.inti.repository.IAvisRepository;

@Controller
public class AvisController {
	@Autowired
	IAvisRepository iar;

}
