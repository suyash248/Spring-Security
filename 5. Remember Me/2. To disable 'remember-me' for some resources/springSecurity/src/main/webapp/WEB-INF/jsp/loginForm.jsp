<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
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
	${sessionScope.msg}
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