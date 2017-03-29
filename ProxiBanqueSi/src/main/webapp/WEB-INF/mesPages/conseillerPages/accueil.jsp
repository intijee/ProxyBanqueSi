<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajouter conseiller</title>
<script type="text/javascript"
	src='<c:url value="/resources/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/jquery-3.1.1.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/resources/bootstrap.css"/>' />
</head>
<body>
	<h1>Liste des conseillers de ProxyBanque</h1>
	<table class="table table-hover">
		<tr>
			<th>Référence du conseiller</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Référence de l'agence</th>
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