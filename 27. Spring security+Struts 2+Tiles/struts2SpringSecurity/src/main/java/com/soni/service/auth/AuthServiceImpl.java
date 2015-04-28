package com.soni.service.auth;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soni.model.GroupAuthority;
import com.soni.model.GroupMember;
import com.soni.model.User;
import com.soni.model.UserAuthority;
import com.soni.service.group.GroupService;
import com.soni.service.user.UserService;

@Repository("authService")
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class AuthServiceImpl implements AuthService, UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.getUserDetails(userName);
		Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<GrantedAuthority>();
		// Adding user's individual authorities.
		for(UserAuthority userAuthority : userService.getIndividualUserAuthorities(userName)){
			grantedAuthorities.add(new SimpleGrantedAuthority(userAuthority.getAuthority().getAuthName()));
		}
		
		// Adding the authorities inherited from groups the user belongs.
		for(GroupMember grpMem : groupService.getUserGroups(userName)){
			List<GroupAuthority> groupAuthorities = groupService.getGroupAuthorities(grpMem.getGroup().getGroupId());
			for(GroupAuthority grpAuth : groupAuthorities){
				grantedAuthorities.add(new SimpleGrantedAuthority(grpAuth.getAuthority().getAuthName()));
			}
		}
		SecureUser secureUser = new SecureUser(userName, user.getUserPass(), grantedAuthorities);
		secureUser.setUser(user);
		return secureUser;
	}

	@Getter @Setter
	public static class SecureUser extends org.springframework.security.core.userdetails.User {
		private User user;
		
		public SecureUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
			super(username, password, authorities);
		}
		
	}
}
