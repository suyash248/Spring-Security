<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Login</title>
</head>
<body>
	<p style="color:red">
		<% 
			if(request.getParameter("error") != null) {
				out.println("Please provide correct credentials");
			} 
		%>
		<% 
			if(session.getAttribute("authEx") !=null) {
				out.println(session.getAttribute("authEx"));
			} 
			if(session.getAttribute("accessDeniedMsg") !=null) {
				out.println(session.getAttribute("accessDeniedMsg"));
			} 
		%>
		${sessionScope.msg}
	</p>
	<form action="submitLogin" method="post">
		<table>
			<tr><td>Enter Username <input type="text" name="username"/></td></tr>
			<tr><td>Enter Password <input type="password" name="password"/></td></tr>
			<tr><td><input type="submit" value="Login"/></td></tr>
		</table>
	</form>
	
	<form action="j_spring_openid_security_check" method="post">
		<table>
			<input name="openid_identifier" size="50" maxlength="100" type="hidden" value="https://www.google.com/accounts/o8/id"/>
			<tr><td><input type="submit" value="Sign with Google"/></td></tr>
		</table>
	</form>
</body>
</html>