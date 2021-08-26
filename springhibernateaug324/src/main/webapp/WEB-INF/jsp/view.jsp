<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
th{
background :black;
color:white;
}
</style>
</head>
<body>
<h1>Employee Records</h1>
	<br>
	<table border="2" width="100%">
		<tr>
			<th>Employee code</th>
			<th>Employee name</th>
			<th>Desgination</th>
			<th>Email</th>
		</tr>
		<form:forEach var="tab" items="${ data}">
			<tr>
				<td>${tab.empcode }</td>
				<td>${tab.empname}</td>
				<td>${tab.designation}</td>
				<td>${tab.email}</td>
			</tr>

			<tr>
		</form:forEach>


	</table>
	<br>
	
</body>
</html>