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
	<link rel="stylesheet" type="text/css" href="/css/styleDisplay.css">
	<title>DashBoard</title>
</head>
<body>
	<div>
		<div class="flex">
			<h1>Welcome ${userName}!</h1>
			<a href="/logout">logout</a>
		</div>
		<div class="flex">
			<h3>Books from everyone's shelves:</h3>
			<a href="/books/new">+ Add a book to my shelf</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.id}</td>
						<td><a href="/book/${book.id}">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.user.userName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>