<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter Information of Student</h1>
	${msg }

	<form:form action="insert" method="post" modelAttribute="student">

<table border="1" width="50%" height="50%">
<tr>
<td>
		<form:label path="id">Id</form:label>
</td>
<td>
		<form:input path="id" />
</td>
</tr>
<tr>
<td>
		<form:label path="name">Name</form:label>
</td>
<td>
		<form:input path="name" />
</td>
</tr>
<tr>
<td>	
		<form:label path="course">Course</form:label>
</td>
<td>
		<form:input path="course" />
</td>
</tr>
<tr>
<td>	
		<form:label path="address.houseNo">House No</form:label>
</td>
<td>
		<form:input path="address.houseNo" />
</td>
</tr>
<tr>
<td>	
		<form:label path="address.city">City</form:label>
</td>
<td>		
		<form:input path="address.city" />
</td>
</tr>
</table>
		<input type="submit" name="submit" value="submit" />
	</form:form>
	<a href="/">GO TO HOME</a>
	<a href="findAll">GO TO DISPLAY PAGE</a>
</body>
</html>