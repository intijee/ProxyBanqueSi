<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil gestion des comptes</title>

<!-- JQuery libraries-->
<script type="text/javascript" src="scripts/jquery.js"></script>

<!-- Bootstrap libraries-->
<script type="text/javascript" src="scripts/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">


<!-- ref vers feuilles css -->
<link rel="stylesheet" href="style/style.css">

</head>
<body>
	<h1>Liste des comptes</h1>
	<table class="table table-hover">
		<tr>
			<th>Numéro de compte</th>
			<th>Solde</th>
			<th>Date d'ouverture du compte</th>
			<th>Référence du client</th>
			<th>supprimer | modifier</th>
		</tr>

		<tr>
			<td><c:forEach var="compte" items="${comptesListe}">
					<tr>
						<td>${compte.numero}</td>
						<td>${compte.solde}</td>
						<td>${compte.date_ouverture}</td>
						<td>${compte.pClient.reference_client}</td>
						<td></td>
					</tr>
				</c:forEach>
	</table>
</body>
</html>