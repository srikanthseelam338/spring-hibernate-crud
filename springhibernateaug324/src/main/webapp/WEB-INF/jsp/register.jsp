<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Register Page</h1><br/>
	<form:form action="store" method="post" modelAttribute="bean">
	    enter code :<form:input path="empcode"/><br><br>
		Enter name : <form:input path="empname"/><br/><br/>
		Enter designation : <form:input path="designation"/><br/><br/>
		Enter mail : <form:input path="email"/><br/><br/>
		<input type="submit" value="Register">
	</form:form>
	<br/>
	<h2>${msg }</h2>
</body>
</html>