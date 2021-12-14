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
	<link rel="stylesheet" type="text/css" href="/css/styleShow.css">
	<title>DashBoard</title>
</head>
<body>
 	<div>
 		<h1>${dojo.name} Ninjas</h1>
 		<table class="table">
 			<thead>
 				<tr>
 					<th scope="col">First Name</th>
 					<th scope="col">Last Name</th>
 					<th scope="col">Age</th>
 				</tr>
 			</thead>
 			<tbody>
 					<c:forEach var="ninja" items="${dojo.ninjas}">
 						<tr>
 							<td>${ninja.first_name}</td>
 							<td>${ninja.last_name}</td>
 							<td>${ninja.age}</td>
 						</tr>
 					</c:forEach>
 			</tbody>
 		</table>
 	</div>
</body>
</html>