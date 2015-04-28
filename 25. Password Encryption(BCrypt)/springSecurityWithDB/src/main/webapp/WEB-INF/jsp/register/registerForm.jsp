<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Sign Up</title>
</head>
<jsp:include page="/WEB-INF/jsp/jsIncludes.jsp"/>
<body>
	<script>
		$(function(){
			initializeRegisterSubmit();
		});
		
		function initializeRegisterSubmit(){
			$('#registerForm').ajaxForm({
				url: "<c:url value='/submitRegister'/>",
				beforeSubmit: function(){
					if($('#passTf').val()!=$('#confirmPassTf').val()){
						$('#msgErrDiv').html('<p style="color:red">Passwords don\'t match</p>').show();
						return false;
					}
				},
				success: function(res){
					$('#msgErrDiv').html('<p style="color:green">'+res+'</p>').show();
					initializeRegisterSubmit();
				}
			});
		}
	</script>
	<div id="msgErrDiv" style="display:none"></div>
	<form id="registerForm" action="submitRegister" method="post">
		<table>
			<tr><td>Username <input type="text" name="userName" required="required"/></td></tr>
			<tr><td>Password <input id="passTf" type="password" name="userPass" required="required"/></td></tr>
			<tr><td>Confirm Password <input id="confirmPassTf" type="password" required="required"/></td></tr>
			<tr><td><input type="submit" value="Register"/></td></tr>
		</table>
		<br/><a href="<c:url value='/login'/>">Login</a>
	</form>
</body>
</html>