<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un compte</title>
</head>
<body>
	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreModifierCompte"
			modelAttribute="compteForm">
			<table>
				<tr>
					<td><form:select path="id_compte">
							<c:forEach var="compte" items="${listeComptes}">
								<option value=${compte.id_compte}>${compte.id_compte}</option>
							</c:forEach>
						</form:select></td>
				</tr>	
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
					<td><form:label path="pClient.reference_client">r�f�rence du client</form:label></td>
					<td><form:input path="pClient.reference_client"/></td>
				</tr>
				<tr>
					<td><form:select path="pClient.reference_client">
							<c:forEach var="client" items="${listeClients}">
								<option value=${client.reference_client}>${client.nom}
									${client.prenom}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><form:radiobutton path="type" value="true"/> epargne </td>
					<td><form:radiobutton path="type" value="false"/> courant</td>
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