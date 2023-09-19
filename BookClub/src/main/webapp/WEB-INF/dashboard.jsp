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
<title>Book Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<nav>
			<div>
				<h1>
					Welcome
					<c:out value="${userName }"></c:out>
				</h1>
				<p>Join our growing community.</p>
			</div>
			<div>
				<p> <a href="/logout">logout</a> </p>
				<p> <a href="/books/new">+ Add a book to my shelf!</a> </p>
				
			</div>
		</nav>
		<main>
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
				<c:forEach var="oneBook" items="${bookList}">
					<tr>
						<td> <c:out value="${oneBook.id }"></c:out> </td>
						<td> <a href="/books/${oneBook.id}"><c:out value="${oneBook.title }"></c:out></a> </td>
						<td> <c:out value="${oneBook.author }"></c:out> </td>
						<td> <c:out value="${oneBook.user.name }"></c:out> </td>
					</tr>
				</c:forEach>
			
			</table>
		</main>



	</div>
</body>
</html>