<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body>
	<h1>
		Your Gold:
		<c:out value="${count }"></c:out>
	</h1>

	<main>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="type" value="farm" />
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<input type="submit" value="Submit" />
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="type" value="cave" />
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<input type="submit" value="Submit" />
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="type" value="house" />
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<input type="submit" value="Submit" />
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="type" value="quest" />
				<h2>Quest</h2>
				<p>(earns 0-50 gold)</p>
				<input type="submit" value="Submit" />
			</form>
		</div>
	</main>
	<footer>
		<h2>Activities</h2>
		<div>
			<c:forEach var="oneActivity" items="${activities}">
				<p>
					<c:out value="${oneActivity}"></c:out>
				</p>
			</c:forEach>
		</div>
	</footer>
</body>
</html>