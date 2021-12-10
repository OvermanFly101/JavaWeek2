<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>All Books</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Language</th>
				<th scope="col"># Pages</th>
			</tr>
		</thead>
		<tbody>
      		<c:forEach var="book" items="${books}">
      			<tr>
      				<td>${book.id}</td>
      				<td><a href="/book/${book.id}">${book.title}</a></td>
      				<td>${book.description}</td>
      				<td>${book.numberOfPages}</td>

      			</tr>
      		</c:forEach>
		</tbody>
	</table>
</body>
</html>