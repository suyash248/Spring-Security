<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1 style="color:red">
	Access Denied!!!
</h1>
<a id="exitUserLink" href="<c:url value='/home'/>">
	Home (<sec:authentication property="principal.username"/>)
</a>