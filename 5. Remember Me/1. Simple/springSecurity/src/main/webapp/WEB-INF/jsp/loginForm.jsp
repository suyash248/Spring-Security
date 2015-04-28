<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<% 
		if(request.getParameter("error") != null) {
			out.println("Please provide correct credentials");
		} 
	%>
	<br/>
	<% 
		if(session.getAttribute("authEx") !=null) {
			out.println(session.getAttribute("authEx"));
		} 
		if(session.getAttribute("accessDeniedMsg") !=null) {
			out.println(session.getAttribute("accessDeniedMsg"));
		} 
	%>
	<br/>
	<form action="submitLogin" method="post">
		<table>
			<tr><td>Enter Username <input type="text" name="username"/></td></tr>
			<tr><td>Enter Password <input type="password" name="password"/></td></tr>
			<tr><td>Remember me <input type="checkbox" name="remember_me"/></td></tr>
			<tr><td><input type="submit" value="Login"/></td></tr>
		</table>
	</form>
</body>
</html>