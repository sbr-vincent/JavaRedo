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
<title>Dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<h1>New Dojo</h1>

	<form:form action="/dojo/create" method="post" modelAttribute="newDojo">
		<form:errors path="dojoName" class="text-danger"></form:errors>
		<div>
			<form:label path="dojoName">Name</form:label>
			<form:input path="dojoName" class="form-control"/>
		</div>
		
		<button type="submit" class="btn btn-success">Create</button>
	</form:form>
</body>
</html>

