<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<h2 class="title">Your Gold: ${treasure}</h2>
	<div class="flex">
		<form action="/clickGold">
			<div class="box">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="location" value="farm"/>
				<input type="submit" value="Find Gold!"/>
			</div>	
		</form>
		<form action="/clickGold">
			<div class="box">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="location" value="cave"/>
				<input type="submit" value="Find Gold!"/>
			</div>
		</form>
		<form action="/clickGold">
			<div class="box">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="location" value="house"/>
				<input type="submit" value="Find Gold!"/>
			</div>
		</form>
		<form action="/clickGold">	
			<div class="box">
				<h2>Casino!</h2>
				<p>(earn/lose 0-50 gold)</p>
				<input type="hidden" name="location" value="casino"/>
				<input type="submit" value="Find Gold!"/>
			</div>	
		</form>
	</div>	
	<h2 class="title">Activities:</h2>
	<div>
		<c:forEach var="activity" items="${activities}">
			<p>${activity}</p>
      	</c:forEach>
	</div>
</body>
</html>