<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Car</title>
<!-- 
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js" />
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js" />
 -->
</head>
<body>

<form method="POST" action="CarController" name="formAddCar">
	Car ID: <input type="text" readonly="readonly" name="carId"
		 value="<c:out value="${car.carid}"/>" />
	<br>
	Manufacturer: <input type="text" name="manufacturer"
		 value="<c:out value="${car.manufacturer}"/>" />
	<br>
	Model: <input type="text"  name="model"
		 value="<c:out value="${car.model}"/>" />
	<br>
	<input type="submit" value="submit">
</form >

</body>
</html>