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
<title>Dojo with Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<h1>
		<c:out value="${dojo.dojoName }" />
		Location Ninjas
	</h1>
	<table class="table table-striped">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>

		<c:forEach var="ninja" items="${dojo.ninjas }">
			<tr>
				<td>
					<c:out value="${ninja.firstName }"></c:out>
				</td>
				<td>
					<c:out value="${ninja.lastName }"></c:out>
				</td>
				<td>
					<c:out value="${ninja.age }"></c:out>
				</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>