package com.soni.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User extends org.springframework.security.core.userdetails.User {

	private String lastName;
	private int age;
	
	public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String lastName, Integer age) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.lastName = lastName;
		this.age = age;
		
	}
	
	public User(String username, String password, Collection<? extends GrantedAuthority> authorities, String lastName, Integer age) {
		this(username, password, true, true, true, true, authorities, lastName, age);
	}
	
}
