<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/styleDojo.css">
	<title>Add Dojo</title>
</head>
<body>
	<div>
		<h1>New Dojo</h1>
		<form:form action="/dojo/new" method="post" modelAttribute="dojo">
			<form:label path="name" for="formControlInput" class="form-label">Name:</form:label>
			<form:input path="name" type="text" class="form-control" id="formControlInput"></form:input>
			<form:errors path="name" class="text-danger"></form:errors>
			
			<button type="submit" class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>