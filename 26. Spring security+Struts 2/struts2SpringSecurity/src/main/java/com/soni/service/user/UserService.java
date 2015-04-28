package com.soni.service.user;

import java.util.List;

import com.soni.model.User;
import com.soni.model.UserAuthority;

public interface UserService {
	public User getUserDetails(String userName);
	public String registerUser(User user);
	public List<UserAuthority> getIndividualUserAuthorities(String userName);
}
