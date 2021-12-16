<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/styleEdit.css">
	<title>Edit Book</title>
</head>
<body>
		<div>
		<div class="flex">
			<h1>Change your Entry!</h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put"/>
			
			<form:errors path="title"/>
			<form:errors path="author"/>
			<form:errors path="thoughts"/>
			
			<form:label path="title" for="formControlInput" class="form-label">Title:</form:label>
			<form:input path="title" class="form-control" id="formControlInput"/>
			
			<form:label path="author" for="formControlInput" class="form-label">Author:</form:label>
			<form:input path="author" type="text" class="form-control" id="formControlInput"/>
			
			<form:label path="thoughts" for="formControlInput" class="form-label">Thoughts:</form:label>
			<form:input path="thoughts" type="textarea" class="form-control" id="formControlInput" style="height: 100px"/>
			
			<form:input type="hidden" path="user" value="${user_id}"/>
			<input type="submit" value="Submit" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>