package com.soni.service;

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

@Repository("authService")
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class AuthServiceImpl extends AbstractServiceImpl implements AuthService, UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private RoleService roleService;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.getUserDetails(userName);
		Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<GrantedAuthority>();
		// If this is new user.
		if(user==null){
			// And this user is signing in using google OpenId, Then create a new user and assign a few authorities to this user.
			if(userName.startsWith("https://www.google.com/accounts/o8/id?id=")){
				user = userService.createOpenIdUser(userName);
				List<UserAuthority> userAuthorities = roleService.assignIndividualAuthoritiesToUser(userName, "ROLE_USER", "ROLE_AUDIENCE", "ROLE_OPENID");
				for(UserAuthority userAuthority : userAuthorities){
					grantedAuthorities.add(new SimpleGrantedAuthority(userAuthority.getAuthority().getAuthName()));
				}
				SecureUser openIdSecureUser = new SecureUser(userName, user.getUserPass(), grantedAuthorities);
				openIdSecureUser.setUser(user);
				return openIdSecureUser;
			}
			else{
				throw new UsernameNotFoundException(userName);
			}
		}
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
