<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Book</title>
</head>
<body>
	<h1>All books</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>#Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${ books }">
				<tr>
					<td><c:out value="${oneBook.id }"></c:out></td>
					<td><a href="/book/${oneBook.id }"><c:out value="${oneBook.title }"></a></c:out></td>
					<td><c:out value="${oneBook.language }"></c:out></td>
					<td><c:out value="${oneBook.numberOfPages }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>