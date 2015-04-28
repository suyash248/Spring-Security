<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>Welcome</h2>
<a id="exitUserLink" href="<c:url value='/home'/>">Home (<sec:authentication property="principal.username"/>)</a>
<h3><c:out value="${msg}"/></h3>
<h4>Genre : <c:out value="${genre}"/></h4>
<h4>Authorities : </h4>
Individual Authorities : <c:out value="${individualAuthorities}" /><br/>
Inherited Authorities : <c:out value="${inheritedAuthorities}" /><br/>