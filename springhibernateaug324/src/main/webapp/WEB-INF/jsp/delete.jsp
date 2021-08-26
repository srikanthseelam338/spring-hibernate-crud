<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> delete data Page</h1><br/>
	<form:form action="delete" method="post" modelAttribute="bean2">
	    enter code :<form:input path="empcode"/><br>
		<input type="submit" value="delete">
	</form:form>
	<br/>
	
</body>
</html>