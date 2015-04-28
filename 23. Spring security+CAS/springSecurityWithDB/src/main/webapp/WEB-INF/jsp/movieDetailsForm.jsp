<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	$(function(){
		initializeMovieDetailsSuibmit();
	});
	
	function initializeMovieDetailsSuibmit(){
		$('#movieDetailsForm').ajaxForm({
				url: "<c:url value='/movie/showMovieDetails'/>",
				beforeSubmit: function(){
					$('#movieDetailsDiv').show();
				},
				target: '#movieDetailsDiv',
				success: function(){
					initializeMovieDetailsSuibmit();
				},
				//resetForm: true
		});
	}
</script>

<form id="movieDetailsForm" action="#">
	Movie Code : <input type="text" name="movieCode" />
	<input type="submit" value="Submit"/>
</form>

<div id="movieDetailsDiv" style="display:none">
	<jsp:include page="/WEB-INF/jsp/movieDetail.jsp"/>
</div>