package com.soni.service;

import java.util.List;

import com.soni.model.Authority;
import com.soni.model.UserAuthority;

public interface RoleService {
	public Authority getAuthorityByName(String authorityName);
	public List<UserAuthority> assignIndividualAuthoritiesToUser(String userName, String... authorityNames);
}
