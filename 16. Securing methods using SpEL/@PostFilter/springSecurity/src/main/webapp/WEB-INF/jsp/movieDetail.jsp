<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table>
	<tr>
		<td>
			<a id="exitUserLink" href="<c:url value='/home'/>">
			Home (<sec:authentication property="principal.username"/>)
			</a>
		</td>
	</tr>
	<tr>
		<td><b>Title : </b></td>
		<td>${movie.title}</td>
	</tr>
	<tr>
		<td><b>Starcast : </b></td>
		<td>${movie.starcast}</td>
	</tr>
	<tr>
		<td><b>Director : </b></td>
		<td>${movie.director}</td>
	</tr>
	<tr>
		<td><b>Year : </b></td>
		<td>${movie.year}</td>
	</tr>
	<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin">
		<tr>
			<td><b>Budget : </b></td>
			<td>${movie.budget}</td>
		</tr>
	</sec:authorize>
	<c:if test="${isAdmin}">
		<tr><td style="color:red">User Type : ADMIN</td></tr>
	</c:if>
</table>