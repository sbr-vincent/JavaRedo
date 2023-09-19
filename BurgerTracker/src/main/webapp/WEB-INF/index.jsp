<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBurger" items="${ burgers }">
				<tr>
					<td><c:out value="${oneBurger.burgerName }"></c:out></td>
					<td><c:out value="${oneBurger.restaurantName }"></c:out></td>
					<td><c:out value="${oneBurger.rating }"></c:out></td>
					<td> <a href="/burger/edit/${oneBurger.id}">Edit</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form:form action="/burger/create" method="post" modelAttribute="burger">
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