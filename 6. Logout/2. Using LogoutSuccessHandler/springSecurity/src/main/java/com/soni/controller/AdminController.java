package com.soni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/movie")
	public String createMovie(Model model) {
		model.addAttribute("genre", "Horror");
		return "created.def";
	}
}
