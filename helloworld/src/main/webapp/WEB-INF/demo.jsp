<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	<h1>Hello World</h1>
	<% for(int i = 0; i < 5; i++) { %>
        <h1><%= i %></h1>
    <% } %>
	<p>The time is: <%= new Date() %></p>
	
	<h1>Two plus two is:</h1>
	<h2><c:out value="${2+2}"></c:out></h2>
</body>
</html>