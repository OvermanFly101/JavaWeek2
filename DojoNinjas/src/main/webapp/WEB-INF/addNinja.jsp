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
	<link rel="stylesheet" type="text/css" href="/css/styleNinja.css">
	<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>New Ninja</h1>
		<form:form action="/ninja/new" method="post" modelAttribute="ninja">
			<form:label path="dojo" for="formControlInput" class="form-label">Dojo:</form:label>
			<form:select path="dojo" class="form-select" aria-label="Default select">
				<c:forEach var="dojo" items="${dojo}">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="dojo" class="text-danger"></form:errors>
			<form:label path="first_name" for="formControlInput" class="form-label">First Name:</form:label>
			<form:input path="first_name" type="text" class="form-control" id="formControlInput"/>
			<form:errors path="first_name" class="text-danger"></form:errors>
			
			<form:label path="last_name" for="formControlInput" class="form-label">Last Name:</form:label>
			<form:input path="last_name" type="text" class="form-control" id="formControlInput"/>
			<form:errors path="last_name" class="text-danger"></form:errors>

			<form:label path="age" for="formControlInput" class="form-label">Age:</form:label>
			<form:input path="age" type="number" class="form-control" id="formControlInput"/>
			<form:errors path="age" class="text-danger"></form:errors>
			
			<button type="submit" class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>