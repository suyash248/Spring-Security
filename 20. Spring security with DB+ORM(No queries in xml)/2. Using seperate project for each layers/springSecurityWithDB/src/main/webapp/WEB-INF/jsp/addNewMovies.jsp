<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script>
	$(function(){
		initializeAddNewMoviesSuibmit();
	});
	
	function initializeAddNewMoviesSuibmit(){
		$('#movieDetailsForm').ajaxForm({
				method: 'POST',
				url: "<c:url value='/movie/addNewMovies'/>",
				target: '#newMoviesDiv',
				success: function(res){
					console.log("RES : "+$.parseJSON(res));
					//$('#newMoviesDiv').html(res);
					$('#newMoviesDiv').show();
					initializeAddNewMoviesSuibmit();
				},
				error: function(){
					console.log('ERROR');
				}
				//resetForm: true
		});
	}
</script>

<a href="<c:url value='/home'/>">
	Home (<sec:authentication property="principal.username"/>)
</a><br/>
<form id="movieDetailsForm" action="#">
	Name of movies(comma separated) : <input type="text" name="moviesCsv" />
	<input type="submit" value="Submit"/>
</form>

<div id="newMoviesDiv" style="display:none;color:red">
	
</div>