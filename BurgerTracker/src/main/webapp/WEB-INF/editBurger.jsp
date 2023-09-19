<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Burger</title>
</head>
<body>
	<h1>Edit Burger</h1>
	<a href="/">Go Back</a>
	<form:form action="/burger/update/${burger.id}" method="post"
		modelAttribute="burger">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="burgerName">Burger Name:</form:label>
			<form:input path="burgerName" />
			<form:errors path="burgerName" />
		</div>
		<div>
			<form:label path="restaurantName">Restaurant Name:</form:label>
			<form:input path="restaurantName" />
			<form:errors path="restaurantName" />
		</div>
		<div>
			<form:label path="rating">Rating:</form:label>
			<form:input type="number" path="rating" />
			<form:errors path="rating" />
		</div>
		<div>
			<form:label path="notes">Notes</form:label>
			<form:textarea path="notes" />
			<form:errors path="notes" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>