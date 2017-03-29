<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Informations de l'Agence</h1>
	<table>
	
		<tr>
			<th>date creation</th>
			<th>Nom du gerant</th>
			<th>R�f�rence de l'agence</th>
			<th>R�f�rence du g�rant</th>
		</tr>

		<tr>
			<td><c:forEach var="agence" items="${listeAgence}">
		<tr>
			<td>${agence.date_creation}</td>
			<td>${agence.nom_gerant}</td>
			<td>${agence.reference_agence}</td>
			<td>${agence.reference_gerant}</td>
		</tr>
</c:forEach>
	</table>

</body>
</html>