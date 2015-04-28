<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Admin Page</h1>

<a href="<s:url value='home/'/>">Home(<sec:authentication property="principal.username"/>)</a> | <a href="<s:url value='/home/logout'/>">Logout</a>