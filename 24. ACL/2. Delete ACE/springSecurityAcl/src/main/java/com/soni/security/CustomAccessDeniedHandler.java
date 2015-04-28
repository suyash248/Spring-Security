package com.soni.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
		// Do something when user is denied to access a resource.
		String accessDeniedMsg = ex.getMessage();
		request.getSession().setAttribute("accessDeniedMsg", accessDeniedMsg);
		response.sendRedirect("/springSecurityAcl/accessDenied");
	}
}
