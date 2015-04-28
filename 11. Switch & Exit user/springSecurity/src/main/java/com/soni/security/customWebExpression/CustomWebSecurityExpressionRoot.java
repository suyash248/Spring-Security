package com.soni.security.customWebExpression;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

import com.soni.model.User;

public class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot {

	public CustomWebSecurityExpressionRoot(Authentication authentication, FilterInvocation filterInvocation) {
		super(authentication, filterInvocation);
	}

	public boolean isOver18() {
		User user = (User) this.getAuthentication().getPrincipal();
		return user.getAge()>18;
	}

}
