<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p style="color:red">
	<% 
			if(session.getAttribute("authEx") !=null) {
				out.println(session.getAttribute("authEx"));
			} 
			if(session.getAttribute("accessDeniedMsg") !=null) {
				out.println(session.getAttribute("accessDeniedMsg"));
			} 
	%>
</p>
<a href="<c:url value='/admin/movie'/>">Create Movie</a> <br/>
<a href="<c:url value='/springSecurity/logout'/>">Logout</a>