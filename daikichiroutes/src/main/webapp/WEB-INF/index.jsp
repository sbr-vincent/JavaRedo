<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/daikichi/omikuji/form" method="post">
		<div>
			<label for="number">Pick any number from 5 to 25</label>
			<input type="number" name="number"/>
		</div>
		
		<div>
			<label for="city">Enter the name of any city.</label>
			<input type="text" name="city"/>
		</div>
		
		<div>
			<label for="name">Enter the name of any real person</label>
			<input type="text" name="name"/>
		</div>
		
		<div>
			<label for="hobby">Enter professional endeavor or hobby:</label>
			<input type="text" name="hobby"/>
		</div>
		
		<div>
			<label for="creature">Enter any type of living thing.</label>
			<input type="text" name="creature"/>
		</div>
		
		<div>
			<label for="comment">Say something nice to someone:</label>
			<textarea name="comment"></textarea>
		</div>
		
		<p>Send and show a friend</p>
		
		<input type="submit" value="Send" />
	
	
	</form>
</body>
</html>