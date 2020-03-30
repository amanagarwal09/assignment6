<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
	<div class="container">
	<h1>Student Report</h1>
	<table border="1" width="70%" height="50%">
	<caption>Students</caption>
			<thead>
				<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Course</th>
				<th>HouseNo</th>
				<th>City</th>
				<th></th>
				<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${list }">
				<tr>
				<td>${s.id }</td>
				<td>${s.name }
				<td>${s.course }
				<td>${s.address.houseNo }
				<td>${s.address.city }
				<td><a href="/update?id=${s.id }">Update</a></td>
				<td><a href="/delete?id=${s.id }">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="/insert">Add
				Student</a>
		</div>
	</div>
</body>
</html>