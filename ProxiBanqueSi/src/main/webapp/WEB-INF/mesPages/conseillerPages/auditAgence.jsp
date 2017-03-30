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


	<h1>Liste des comptes Humains</h1>
	<table class="table table-hover">
		<tr>
			<th>Numéro de compte</th>
			<th>Solde</th>
			<th>Date d'ouverture du compte</th>
			<th>Référence du client</th>
		</tr>

		<tr>
			<td><c:forEach var="compteHumain" items="${humainListe}">
					<tr>
						<td>${compteHumain.numero}</td>
						<td>${compteHumain.solde}</td>
						<td>${compteHumain.date_ouverture}</td>
						<td>${compteHumain.pClient.reference_client}</td>
					</tr>
				</c:forEach>
	</table>
	
	
		<h1>Liste des comptes Entreprise</h1>
	<table class="table table-hover">
		<tr>
			<th>Numéro de compte</th>
			<th>Solde</th>
			<th>Date d'ouverture du compte</th>
			<th>Référence du client</th>
		</tr>

		<tr>
			<td><c:forEach var="compteEntreprise" items="${entrepriseListe}">
					<tr>
						<td>${compteEntreprise.numero}</td>
						<td>${compteEntreprise.solde}</td>
						<td>${compteEntreprise.date_ouverture}</td>
						<td>${compteEntreprise.pClient.reference_client}</td>
					</tr>
				</c:forEach>
	</table>

</body>
</html>