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
	<link rel="stylesheet" type="text/css" href="/css/styleLogin.css">
	<title>Login & Register</title>
</head>
<body>
	<h1>Book Club!</h1>
	<div class="flex">
		<div class="register">
    		<form:form action="/register" method="post" modelAttribute="newUser">
        		<div class="form-group">
            		<label for="formControlInput" class="form-label">User Name:</label>
            		<form:input path="userName" class="form-control" id="formControlInput"/>
            		<form:errors path="userName" class="text-danger" />
        		</div>
        		<div class="form-group">
            		<label>Email:</label>
            		<form:input path="email" class="form-control" id="formControlInput"/>
            		<form:errors path="email" class="text-danger" />
        		</div>
        		<div class="form-group">
            		<label for="formControlInput" class="form-label">Password:</label>
            		<form:password path="password" class="form-control" id="formControlInput"/>
            		<form:errors path="password" class="text-danger" />
        		</div>
        		<div class="form-group">
            		<label for="formControlInput" class="form-label">Confirm Password:</label>
            		<form:password path="confirm" class="form-control" id="formControlInput"/>
            		<form:errors path="confirm" class="text-danger" />
        		</div>
        		<input type="submit" value="Register" class="btn btn-primary" />
    		</form:form>
    	</div>
    	<div class="login">
    		<form:form action="/login" method="post" modelAttribute="newLogin">
        		<div class="form-group">
            		<label for="formControlInput" class="form-label">Email:</label>
            		<form:input path="email" class="form-control" id="formControlInput"/>
            		<form:errors path="email" class="text-danger" />
        		</div>
        		<div class="form-group">
            		<label for="formControlInput" class="form-label">Password:</label>
            		<form:password path="password" class="form-control" id="formControlInput"/>
            		<form:errors path="password" class="text-danger" />
        		</div>
        		<input type="submit" value="Login" class="btn btn-success" />
    		</form:form>
    	</div>
	</div>

</body>
</html>