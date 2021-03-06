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
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>PokeBook</title>
</head>
<body>
	<h1>PokeBook</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Expense</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${pokes}">
				<tr>
					<td><a href="/poke/${p.id}">${p.name}</a></td>
					<td>${p.vendor}</td>
					<td>${p.amount}</td>
					<td><a href="/poke/${p.id}/edit">edit</a></td>
					<td>
						<form action="/poke/${p.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<button>Delete</button>
						</form>
					</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	<h1>Track an expense:</h1>
	<form:form action="/createPoke" method="POST" modelAttribute="pokeBook">
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