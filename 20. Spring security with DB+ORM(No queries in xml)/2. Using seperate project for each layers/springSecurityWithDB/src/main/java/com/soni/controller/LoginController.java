package com.soni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soni.model.User;
import com.soni.service.role.RoleService;
import com.soni.service.user.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
		
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String home() {
		return "home.def";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/submitLogin")
	public String submit() {
		return "home.def";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/logoutSuccess")
	public String logoutSuccess() {
		return "loginForm";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registerForm")
	public String registerForm() {
		return "register/registerForm";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/submitRegister")
	public String register(@ModelAttribute(value="user") User user) throws JsonProcessingException {
		String message  = userService.registerUser(user);
		roleService.assignIndividualAuthoritiesToUser(user.getUserName(), "ROLE_USER");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(message);
	}
}
