<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Home Page</h1>

<s:set var="url">
	<s:url value="/admin/"/>
</s:set>

<s:a href="%{url}">Admin</s:a> | <a href="<s:url value='/home/logout'/>">Logout</a>