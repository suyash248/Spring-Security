package com.soni.action;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component
public class AdminAction extends ActionSupport {
	public String execute(){
		
		return SUCCESS;
	}
	
}
