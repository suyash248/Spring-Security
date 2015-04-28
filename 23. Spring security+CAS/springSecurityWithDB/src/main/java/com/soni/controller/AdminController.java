package com.soni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soni.model.GroupAuthority;
import com.soni.model.GroupMember;
import com.soni.model.User;
import com.soni.model.UserAuthority;
import com.soni.service.GroupService;
import com.soni.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@Secured(value="ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, value = "/movie")
	public String createMovie(Model model) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		org.springframework.security.core.userdetails.User secUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		
		User user = userService.getUserDetails(secUser.getUsername());
		List<String> individualAuthorities = new ArrayList<String>();
		List<String> inheritiedAuthorities = new ArrayList<String>();
		
		for(UserAuthority userAuthority : userService.getIndividualUserAuthorities(user.getUserName())){
			individualAuthorities.add(userAuthority.getAuthority().getAuthName());
		}
		
		for(GroupMember grpMem : groupService.getUserGroups(secUser.getUsername())){
			List<GroupAuthority> groupAuthorities = groupService.getGroupAuthorities(grpMem.getGroup().getGroupId());
			for(GroupAuthority grpAuth : groupAuthorities){
				inheritiedAuthorities.add(grpAuth.getAuthority().getAuthName());
			}
		}
		
		model.addAttribute("genre", "Horror");
		model.addAttribute("msg", user.getUserName()+" is creating movie.");
		model.addAttribute("individualAuthorities", individualAuthorities);
		model.addAttribute("inheritiedAuthorities", inheritiedAuthorities);
		return "created.def";
	}
}