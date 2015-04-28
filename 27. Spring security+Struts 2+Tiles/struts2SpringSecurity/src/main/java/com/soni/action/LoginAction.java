package com.soni.action;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component
public class LoginAction extends ActionSupport {
	public String execute(){
		
		return "login";
	}
	
}