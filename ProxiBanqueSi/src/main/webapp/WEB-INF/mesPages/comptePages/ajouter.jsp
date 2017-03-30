<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- JQuery libraries-->
<script type="text/javascript" src='<c:url value="/scripts/jquery.js"/>'></script>

<script type="text/javascript" src='<c:url value="/scripts/test.js"/>'></script>



<title>Ajouter un compte</title>

</head>
<body>
	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreAjoutCompte"
			modelAttribute="compteForm">
			<table>

				<tr>
					<td><form:label path="numero">num�ro du compte </form:label></td>
					<td><form:input path="numero" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="solde">Solde du compte</form:label></td>
					<td><form:input path="solde" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="date_ouverture">date d'ouverture du compte</form:label></td>
					<td><form:input path="date_ouverture" type="date" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
				<td><form:label path="pClient.reference_client">r�f�rence du proprietaire du compte</form:label></td>
					<td><form:select path="pClient.reference_client">
							<c:forEach var="client" items="${listeClients}">
								<option value=${client.reference_client}>${client.nom}
									${client.prenom}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><form:radiobutton path="type" value="true" onclick="hideDecouvert()"/> epargne </td>
					<td><form:radiobutton path="type" value="false" onclick="hideTaux()"/> courant</td>
				</tr>
				
				<tr>
					<td><form:label path="taux">Taux du compte</form:label></td>
					<td><form:input id="taux" path="taux" disabled="true"/></td>
				</tr>
				
				<tr>
					<td><form:label path="decouvert">d�couvert autoris�</form:label></td>
					<td><form:input id="decouvert" path="decouvert"/></td>
				</tr>
				
				

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Ajouter"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>


</body>
</html>