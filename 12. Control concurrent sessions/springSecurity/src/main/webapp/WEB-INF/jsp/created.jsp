<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script>
	$(function(){
		$('#switchUserLink').on('click', function(){
			var switchUrl='http://localhost:8080/springSecurity/j_spring_security_switch_user?j_username=director';
			$.post(switchUrl);
			return true;
		});
	});
</script>

<h2>Welcome</h2>
<h3><c:out value="${msg}"/></h3>
<a id="switchUserLink" href="<c:url value='/movie/titanic_1980'/>">See Detail</a>
<h4>Age : <c:out value="${age}"/></h4>
<h4>Genre : <c:out value="${genre}"/></h4>
<a href="<c:url value='/springSecurity/logout'/>">Logout</a>