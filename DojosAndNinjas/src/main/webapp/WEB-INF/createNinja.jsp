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
<title>Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<h1>New Ninja</h1>

	<form:form action="/ninja/create" method="post"
		modelAttribute="newNinja">
		<div>
			<form:label path="dojo">Dojo:</form:label>
			<form:select path="dojo" class="form-control">
				<c:forEach var="oneDojo" items="${ dojoList }">
					<option value="${oneDojo.id }">
						<c:out value="${oneDojo.dojoName }"></c:out>
					</option>
				</c:forEach>
			</form:select>
		</div>

		<form:errors path="firstName" class="text-danger"></form:errors>
		<div>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" class="form-control" />
		</div>
		<form:errors path="lastName" class="text-danger"></form:errors>
		<div>
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" class="form-control" />
		</div>
		<form:errors path="age" class="text-danger"></form:errors>
		<div>
			<form:label path="age">Age</form:label>
			<form:input path="age" class="form-control" />
		</div>

		<button type="submit" class="btn btn-success">Create</button>
	</form:form>
</body>
</html>