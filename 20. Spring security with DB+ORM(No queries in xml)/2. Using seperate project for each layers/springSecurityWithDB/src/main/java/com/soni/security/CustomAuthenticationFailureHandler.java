package com.soni.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
			throws IOException, ServletException {
		// Do some logic here if you want something to be done whenever the user authentication fails.
		
		request.getSession().setAttribute("authEx", authEx.getMessage());
		response.sendRedirect("/springSecurityWithDB/login?error");
	}
}
