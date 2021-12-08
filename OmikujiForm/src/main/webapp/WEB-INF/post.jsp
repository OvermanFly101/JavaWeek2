<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/css/postStyle.css">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Fortune</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div class="post-fortune">
		<p>In ${number} years, you will live in ${city} with ${person} as your roommate, ${career} for a living. The next time you see a ${animal}, you will have good luck. ${somethingNice} </p>
	</div>
	<a href="localhost:8080">Go Back</a>
</body>
</html>