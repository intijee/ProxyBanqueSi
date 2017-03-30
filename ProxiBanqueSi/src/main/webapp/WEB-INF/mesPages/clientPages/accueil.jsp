<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="bootstrap/js/jquery-3.1.1.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

</head>
<body>


	<h1>Liste des clients</h1>
	<table class="table table-hover">



		<thead>
			<tr>
				<th>Type de client</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Adresse</th>
				<th>Ville</th>
				<th>Code Postal</th>
				<th>telephone</th>
				<th>Référence client</th>
				<th>Référence du conseiller</th>
				<!-- 				<th>Référence conseiller</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="client" items="${clientListe}">
				<tr>
					<td><c:if test="${client.humain_0_entreprise_1 == false}">Humain</c:if><c:if test="${client.humain_0_entreprise_1 == true}">Entreprise</c:if></td>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td>${client.adresse}</td>
					<td>${client.ville}</td>
					<td>${client.code_postal}</td>
					<td>${client.telephone}</td>
					<td>${client.reference_client}</td>
					<td>${client.pConseiller.reference_conseiller}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>