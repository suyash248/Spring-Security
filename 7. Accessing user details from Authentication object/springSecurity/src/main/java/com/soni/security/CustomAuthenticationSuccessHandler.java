package com.soni.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

@Component(value="customAuthenticationSuccessHandler")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		// Do some logic here if you want something to be done whenever the user successfully logs in.
		
		String loggedUser = auth.getName();
		request.getSession().setAttribute("loggedUser", loggedUser);
		
		// Redirecting to the URL originally requested by user.
		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		if(savedRequest != null && savedRequest.getRedirectUrl() != null){
			String redirectUri = savedRequest.getRedirectUrl();
			response.sendRedirect(redirectUri);
		}
	}
}
