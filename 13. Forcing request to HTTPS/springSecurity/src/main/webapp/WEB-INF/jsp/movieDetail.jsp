<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script>
	$(function(){
		$('#exitUserLink').on('click', function(){
			var exitUrl='https://localhost:8080/springSecurity/j_spring_security_exit_user';
			$.post(exitUrl);
			return true;
		});
	});
</script>

<table>
	<tr>
		<td>
			<a id="exitUserLink" href="<c:url value='/home'/>">Home</a>
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
		<td><b>Budget : </b></td>
		<td>${movie.budget}</td>
	</tr>
	<tr>
		<td><b>Year : </b></td>
		<td>${movie.year}</td>
	</tr>
</table>