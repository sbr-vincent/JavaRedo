<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Book</h1>
	<form:form action="/api/books/${book.id}" method="post"
		modelAttribute="book">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="title">Title</form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:textarea path="description" />
			<form:errors path="description" />
		</div>
		<div>
			<form:label path="language">Language</form:label>
			<form:input path="language" />
			<form:errors path="language" />
		</div>
		<div>
			<form:label path="numberOfPages">Pages</form:label>
			<form:input type="number" path="numberOfPages" />
			<form:errors path="numberOfPages" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>