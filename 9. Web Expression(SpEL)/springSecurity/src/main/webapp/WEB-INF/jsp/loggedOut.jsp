<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${msg!=null}">
	<p style="color:red"><c:out value="${msg}"/></p>
</c:if>
<br/><a href="login">Login</a>