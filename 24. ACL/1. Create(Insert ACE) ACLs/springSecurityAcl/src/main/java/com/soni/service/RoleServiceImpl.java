package com.soni.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soni.model.Authority;
import com.soni.model.User;
import com.soni.model.UserAuthority;

@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class RoleServiceImpl extends AbstractServiceImpl implements RoleService {
	
	@Autowired
	private UserService userService;
	
	public Authority getAuthorityByName(String authorityName) {
		Authority authority;
		String sql = "select auth from Authority auth "
				+ " where auth.authName=:authorityName";
		Query query = getSession().createQuery(sql);
		query.setParameter("authorityName", authorityName);
		authority = (Authority) query.uniqueResult();
		return authority;
	}
	
	public List<UserAuthority> assignIndividualAuthoritiesToUser(String userName, String... authorityNames) {
		List<UserAuthority> userAuthorities = new ArrayList<UserAuthority>();
		User user = userService.getUserDetails(userName);
		UserAuthority userAuthority;
		for(String authorityName : authorityNames){
			userAuthority = new UserAuthority();
			userAuthority.setUser(user);
			userAuthority.setAuthority(getAuthorityByName(authorityName));
			getSession().saveOrUpdate(userAuthority);
			userAuthorities.add(userAuthority);
		}
		return userAuthorities;
	}
}
