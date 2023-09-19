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
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneExpense" items="${ expenses }">
				<tr>
					<td><a href="/expense/${oneExpense.id }"><c:out value="${oneExpense.name }"></c:out></a></td>
					<td><c:out value="${oneExpense.vendor }"></c:out></td>
					<td><c:out value="${oneExpense.amount }"></c:out></td>
					<td><a href="/expense/${oneExpense.id }/edit">Edit</a></td>
					<td>
						<form action="/expense/delete/${oneExpense.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button type="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form:form action="/expense/create" method="post"
		modelAttribute="expense">
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