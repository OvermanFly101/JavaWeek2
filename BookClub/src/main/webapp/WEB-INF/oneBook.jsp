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
	<link rel="stylesheet" type="text/css" href="/css/styleBook.css">
	<title>Show Book</title>
</head>
<body>
	<div>
		<div class="flex">
			<h1>${book.title}</h1>
			<a href="/books">back to the shelves</a>
		</div>
		<h3>${book.user.userName} read ${book.title} by ${book.author}.</h3>
		<p>Here are ${book.user.userName} thoughts:</p>
		<div class="thoughts">
			<p>${book.thoughts}</p>
		</div>
		<div>
			<c:if test="${userName == book.user.userName}"><a href="/books/${book.id}/edit">edit</a></c:if>
		</div>
	</div>
</body>
</html>