package com.soni.action;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomeAction extends ActionSupport {
	public String execute(){
		
		return "home";
	}
	
	public String logout(){
		return "logout";
	}
}
