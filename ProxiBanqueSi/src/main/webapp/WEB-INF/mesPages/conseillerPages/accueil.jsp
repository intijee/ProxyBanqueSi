<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajouter conseiller</title>


</head>
<body>
	<h1>Liste des conseillers de ProxyBanque</h1>
	<table>
		<tr>
			<th>R�f�rence du conseiller</th>
			<th>Nom</th>
			<th>Pr�nom</th>
			<th>R�f�rence de l'agence</th>
		</tr>

		<tr>
			<td><c:forEach var="conseiller" items="${conseillerListe}">
					<tr>
						<td>${conseiller.reference_conseiller}</td>
						<td>${conseiller.nom}</td>
						<td>${conseiller.prenom}</td>
						<td>${conseiller.pAgence.reference_agence}</td>
					</tr>
				</c:forEach>
	</table>
</body>
</html>