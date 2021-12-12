<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Poke Details</h1>
		<a href="/pokebook">Go back</a>
	</div>
	<div>
		<h3>Expense Name: ${poke.name}</h3>
		<h3>Expense Details: ${poke.description}</h3>
		<h3>Vendor: ${poke.vendor}</h3>
		<h3>Amount spent: $${poke.amount}</h3>
	</div>
</body>
</html>