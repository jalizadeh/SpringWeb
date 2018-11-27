<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Cars</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Car ID</th>
				<th>Manufacturer</th>
				<th>Model</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td><c:out value="${car.carid}"/></td>
					<td><c:out value="${car.manufacturer}"/></td>
					<td><c:out value="${car.model}"/></td>
					<td><a href="CarController?action=edit&carid=<c:out value="${car.carid}"/>">Update</a></td>
					<td><a href="CarController?action=delete&carid=<c:out value="${car.carid}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="CarController?action=insert">Add New Car</a></p>
</body>
</html>