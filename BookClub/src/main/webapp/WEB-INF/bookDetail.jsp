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
<title>Book Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>
			<c:out value="${oneBook.title }"></c:out>
		</h1>
		<p>
			<a href="/books">back to the shelves</a>
		</p>

		<c:if test="${oneBook.user.id==userId}">
			<p>
				You read
				<c:out value="${oneBook.title }. Here are your thoughts."></c:out>
			</p>
		</c:if>
		<c:if test="${oneBook.user.id!=userId}">
			<p>
				<c:out value="${oneBook.user.name }" />
				read
				<c:out value="${oneBook.title }" />
				by
				<c:out value="${ oneBook.author }"></c:out>
			</p>
			<p>
				Here are
				<c:out value="${oneBook.user.name }" />
				's thoughts:
			</p>
		</c:if>
		<hr>
		<p>
			<c:out value="${oneBook.thoughts }" />
		</p>
		<hr>
		<c:if test="${oneBook.user.id==userId}">
			<p class="btn btn-warning">
				<a href="/books/${oneBook.id}/edit">Edit</a>
			</p>

			<form action="/books/delete/${oneBook.id }" method="post" >
				<input type="hidden" name="_method" value="delete" />
				<button type="submit" class="btn btn-danger">Delete</button>
			</form>

		</c:if>




	</div>
</body>
</html>