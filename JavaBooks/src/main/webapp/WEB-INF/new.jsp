<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>New Book</h1>
	<form:form action="/api/books" method="post" modelAttribute="book">
		<p>
			<form:label path="title">Title</form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:textarea path="description" />
			<form:errors path="description" />
		</p>
		<p>
			<form:label path="language">Language</form:label>
			<form:input path="language" />
			<form:errors path="language" />
		</p>
		<p>
			<form:label path="numberOfPages">Pages</form:label>
			<form:input type="number" path="numberOfPages" />
			<form:errors path="numberOfPages" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>