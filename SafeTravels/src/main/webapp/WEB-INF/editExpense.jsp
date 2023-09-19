<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go Back</a>
	<form:form action="/expense/update/${expense.id}" method="post"
		modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<form:label path="vendor">Vendor:</form:label>
			<form:input path="vendor" />
			<form:errors path="vendor" />
		</div>
		<div>
			<form:label path="amount">Amount:</form:label>
			<form:input type="number" path="amount" />
			<form:errors path="amount" />
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:textarea path="description" />
			<form:errors path="description" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>