<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operation bancaire</title>
</head>
<body>

<h1>Effectuer un dépôt :</h1>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreDepotCompte"
			modelAttribute="compteForm1">
			<table>
				<tr>
					<td><br /> <br />Compte à créditer</td>
				</tr>
				<tr>
					<td><form:select path="assoCompte.id_compte">
							<c:forEach var="c" items="${listeComptes}">
								<option value=${c.id_compte}># ${c.numero} ; solde : ${c.solde} &euro; </option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="somme">Somme</form:label></td>
					<td><form:input path="somme" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Déposer"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>
	
<h1>Effectuer un retrait :</h1>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreRetraitCompte"
			modelAttribute="compteForm2">
			<table>
				<tr>
					<td><br /> <br />Compte à débiter :</td>
				</tr>
				<tr>
					<td><form:select path="assoCompte.id_compte">
							<c:forEach var="c" items="${listeComptes}">
								<option value=${c.id_compte}># ${c.numero} ; solde : ${c.solde} &euro; </option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="somme">Somme</form:label></td>
					<td><form:input path="somme" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Retirer"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>
	
	<h1>Effectuer un virement</h1>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreVirementCompte"
			modelAttribute="compteForm3">
			<table>
				<tr>
					<td><br /> <br />Compte à débiter :</td>
				</tr>
				<tr>
					<td><form:select path="assoCompte.id_compte">
							<c:forEach var="c" items="${listeComptes}">
								<option value=${c.id_compte}># ${c.numero} ; solde : ${c.solde} &euro; </option>
							</c:forEach>
						</form:select></td>
				</tr>
				
				<tr>
					<td><br /> <br />Compte à créditer :</td>
				</tr>
				<tr>
					<td><form:select path="assoCredite.id_compte">
							<c:forEach var="c" items="${listeComptes}">
								<option value=${c.id_compte}># ${c.numero} ; solde : ${c.solde} &euro; </option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="somme">Somme</form:label></td>
					<td><form:input path="somme" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="effectuer le virement"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>


</body>
</html>