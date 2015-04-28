package com.soni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return "login.def";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/submitLogin")
	public String submit() {
		return "redirect:admin/movie";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/accessDenied")
	public String accessDenied() {
		return "login.def";
	}
}
