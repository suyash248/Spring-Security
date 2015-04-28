<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>Welcome</h2>
<a id="exitUserLink" href="<c:url value='/home'/>">Home (<sec:authentication property="principal.username"/>)</a>
<h3><c:out value="${msg}"/></h3>
<h4>Genre : <c:out value="${genre}"/></h4>
<h4>Authorities : </h4>
<c:forEach items="${authorities}" var="auth">
	<h5><c:out value="${auth.authority}"/></h5>
</c:forEach>

<a href="<c:url value='/logout'/>">Logout</a>