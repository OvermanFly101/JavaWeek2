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
	<h1>Omikuji Form!</h1>
    <form action='/processFortune' method='GET' class="d-flex flex-column bd-highlight">
	<label>Pick any number from 5 to 25.</label>
    	<input type="number" name='number'>
	<label>Enter the name of any city.</label>
    	<input type="text" name='city'>
	<label>Enter the name of any real person.</label>
    	<input type='text' name='person'>
	<label>Enter professional endeavor or hobby.</label>
    	<input type='text' name='career'>
    <label>Enter any type of living thing.</label>
    	<input type='text' name='animal'>
    <label>Say something nice to someone.</label>
    	<input type='text' name='somethingNice'>
    	<input type='submit' value='Send'>
    </form>

	
</body>
</html>