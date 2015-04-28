<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<form method="post" action="post">
	Content: <input type="text" name="postContent" style="width:25%" /><br/>
	<input type="submit" value="Post" />
</form>
<br/><a id="exitUserLink" href="<c:url value='/home'/>">Home (<sec:authentication property="principal.username"/>)</a><br/>

<table border="1">
	<tr>
		<th>User</th>
		<th>Content</th>
	</tr>
	
	<c:forEach items="${posts}" var="post">
		<tr>
			<td>${post.user.userName}</td>
			<td>${post.content}</td>
		</tr>
	</c:forEach>
	
</table>