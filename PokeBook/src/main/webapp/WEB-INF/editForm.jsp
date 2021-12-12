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
	<link rel="stylesheet" type="text/css" href="/css/editStyle.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>PokeBook</title>
</head>
<body>
	<div class="flex">
		<h1>Update Expense:</h1>
		<a href="/pokebook">Go back</a>
	</div>
	<form:form action="/poke/${poke.id}/edit" method="POST" modelAttribute="poke">
		<input type="hidden" name="_method" value="put"/>

		<form:label path="name" for="formControlInput" class="form-label">Expense Name:</form:label>
			<form:input path="name" class="form-control" id="formControlInput" />
			<form:errors path="name" class="error"/>
		
		<form:label path="vendor" for="formControlInput" class="form-label">Vendor:</form:label>
			<form:input path="vendor" class="form-control" id="formControlInput" />
			<form:errors path="vendor" class="error"></form:errors>
		
		<form:label path="amount" for="formControlInput" class="form-label">Amount:</form:label>
			<form:input type="number" path="amount" class="form-control" id="formControlInput" />
			<form:errors path="amount" class="error"></form:errors>
		
		<form:label path="description" for="formControlInput" class="form-label">Description:</form:label>
			<form:input path="description" class="form-control" id="formControlInput" />
			<form:errors path="description" class="error"></form:errors>
		
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>