package com.soni.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soni.model.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Secured(value="ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, value = "/movie")
	public String createMovie(Model model) {
		model.addAttribute("genre", "Horror");
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		User user = (User) authentication.getPrincipal();
		
		model.addAttribute("msg", user.getUsername()+" is creating movie.");
		model.addAttribute("age", user.getAge());
		return "created.def";
	}
}
