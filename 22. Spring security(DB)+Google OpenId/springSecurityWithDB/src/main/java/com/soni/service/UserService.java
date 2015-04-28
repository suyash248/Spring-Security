package com.soni.service;

import java.util.List;

import com.soni.model.User;
import com.soni.model.UserAuthority;

public interface UserService {
	public User getUserDetails(String userName);
	public User createOpenIdUser(String userName);
	public List<UserAuthority> getIndividualUserAuthorities(String userName);
}
