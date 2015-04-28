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
	%>
	<br/>
	<c:out value="${message}"/>
	<form action="submitLogin" method="post">
		Enter Username<input type="text" name="username"/><br/>
		Enter Password<input type="password" name="password"/><br/>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>