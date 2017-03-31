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

<h1>Simuler un pret</h1>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 20px">
		<form:form method="POST" action="soumettreFormSimulation"
			modelAttribute="simulationForm">
			<table>
			
				<tr>
		<td><form:label path="pClient.reference_client">Client</form:label></td>
		<td><form:select cssClass="form-control"
				path="pClient.reference_client">
				<c:forEach var="client" items="${listeClient}">
					<option value=${client.reference_client}>${client.nom}
						${client.prenom}</option>
				</c:forEach>
			</form:select></td>
	</tr>

				<tr>
					<td><form:label path="revenue_client">Revenu du client</form:label></td>
					<td><form:input path="revenue_client" /></td>
				</tr>

			
				<tr>
					<td><form:label path="somme_pret">Somme à emprunter</form:label></td>
					<td><form:input path="somme_pret" /></td>
				</tr>

				<tr>
					<td><form:label path="duree_mois">Duree du pret</form:label></td>
					<td><form:input path="duree_mois" /></td>
				</tr>
				
					<tr>
					<td colspan="2"><input type="submit" class="btn btn-default" value="Ajouter"
						style="margin-left: 120px"></td>
				</tr>


</table>
</form:form>
</div>

<h1>Resultats de la simulation</h1>
<br/>
	<table class="table table-hover">
	
		<tr>
			<th>Client</th>
			<th>Somme Désirée</th>
			<th>Durée (Mois)</th>
			<th>Mensualités</th>
			<th>Somme total à rembourser</th>
		</tr>

	
		<tr>
			<td>${pret.pClient.reference_client}</td>
			<td>${pret.somme_pret}</td>
			<td>${pret.duree_mois}</td>
			<td>${pret.mensualites}</td>
			<td>${pret.cout_pret}</td>
		</tr>

	</table>



</body>
</html>