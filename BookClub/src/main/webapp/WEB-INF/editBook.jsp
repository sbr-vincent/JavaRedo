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
<title>Create a Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>Change your Entry</h1>
		<p>
			<a href="/books">back to the shelves</a>
		</p>

		<form:form action="/books/update/${oneBook.id }" method="post" modelAttribute="oneBook">
			<input type="hidden" name="_method" value="put">
			<form:errors path="title" class="text-danger" />
			<div>
				<form:label path="title">Title:</form:label>
				<form:input path="title" class="form-control" />
			</div>
			<form:errors path="author" class="text-danger" />
			<div>
				<form:label path="author">Author:</form:label>
				<form:input path="author" class="form-control" />
			</div>
			<form:errors path="thoughts" class="text-danger" />
			<div>
				<form:label path="thoughts">My Thoughts:</form:label>
				<form:input path="thoughts" class="form-control" />
			</div>
			
			<input type="hidden" name="user" value="${userId}" />

			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>

	</div>
</body>
</html>