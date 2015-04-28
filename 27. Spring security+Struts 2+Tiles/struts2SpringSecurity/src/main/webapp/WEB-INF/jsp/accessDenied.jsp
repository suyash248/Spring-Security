<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
    </head>
    <body>
        <h1 style="color:red">Access Denied for ${pageContext.request.userPrincipal.name}!!!</h1>
        <a href="<s:url value='/home/'/>">Home(<sec:authentication property="principal.username"/>)</a> | <a href="<s:url value='/home/logout'/>">Logout</a>
    </body>
</html>