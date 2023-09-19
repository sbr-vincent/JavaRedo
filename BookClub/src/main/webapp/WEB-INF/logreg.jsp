<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books.</p>

		<h2>Register</h2>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<form:errors path="name" class="text-danger" />
			<div>
				<form:label path="name">Name:</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<form:errors path="email" class="text-danger" />
			<div>
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" />
			</div>
			<form:errors path="password" class="text-danger" />
			<div>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password" class="form-control" />
			</div>
			<form:errors path="confirm" class="text-danger" />
			<div>
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input type="password" path="confirm" class="form-control" />
			</div>

			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>

		<h2>Login</h2>
		<form:form action="/login" method="post" modelAttribute="newLogin">

			<form:errors path="email" class="text-danger" />
			<div>
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" />
			</div>
			<form:errors path="password" class="text-danger" />
			<div>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password" class="form-control" />
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>