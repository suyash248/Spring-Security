package com.soni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soni.model.User;
import com.soni.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Secured(value="ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, value = "/movie")
	public String createMovie(Model model) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		org.springframework.security.core.userdetails.User secUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		
		User user = userService.getUserDetails(secUser.getUsername());
		
		model.addAttribute("genre", "Horror");
		model.addAttribute("msg", user.getUserName()+" is creating movie.");
		model.addAttribute("authorities", user.getAuthorities());
		return "created.def";
	}
}