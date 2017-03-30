<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Liste des actions en bourse</h1>

	<table>
		<tr>
			<th>Nom de la compagnie</th>
			<th>Cours de l'action</th>
		</tr>

		<tr>
			<td><c:forEach var="action" items="${actionListe}">
			<tr>
			<td>${action.nom}</td>
			<td>${action.cours}</td>
			</tr>
			</c:forEach></td>
		</tr>

	</table>

	
</body>
</html>