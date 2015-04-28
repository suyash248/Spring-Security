package com.soni.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.soni.model.User;

@Getter @Setter
public class CustomUserDetails implements UserDetailsService {
	
	private Map<String, User> users = new HashMap<String, User>();
	
	public CustomUserDetails(Collection<User> users) {
		for (User user : users) {
			this.users.put(user.getUsername().toLowerCase(), user);
		}
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = users.get(username.toLowerCase());
		if (user == null) { // https://www.google.com/accounts/o8/id?id=AItOawmS3VTQ8nF2lw5K-9L7TEuOHjPgx4qbqyc
			// If user tries to login by open id
			if(username.startsWith("https://www.google.com/accounts/o8/id?id=")){
				List<GrantedAuthority> openIdUserAuthorities = new ArrayList<GrantedAuthority>();
				openIdUserAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				openIdUserAuthorities.add(new SimpleGrantedAuthority("ROLE_AUDIENCE"));
				openIdUserAuthorities.add(new SimpleGrantedAuthority("ROLE_OPENID"));
				// Create new user
				User openIdUser = new User(username, "", openIdUserAuthorities, "", 0);
				return openIdUser;
			}else{
				throw new UsernameNotFoundException(username);
			}
		}
		User userNew = new User(user.getUsername(), user.getPassword(), user.getAuthorities(), user.getLastName(), user.getAge());
		return userNew;
	}

}
