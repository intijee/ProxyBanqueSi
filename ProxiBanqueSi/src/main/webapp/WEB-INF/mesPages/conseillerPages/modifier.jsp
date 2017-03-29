<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modifier conseiller</title>
<script type="text/javascript"
	src='<c:url value="/resources/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/jquery-3.1.1.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/resources/bootstrap.css"/>' />
</head>
<body>
	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreModifier"
			modelAttribute="modifierForm">
			<table>

				<tr><td><form:label path="reference_conseiller">Référence du conseiller à modifier</form:label></td>
					<td><form:select path="reference_conseiller">
							<c:forEach var="conseiller" items="${conseillerListe}">
								<option value=${conseiller.reference_conseiller}>${conseiller.getReference_conseiller()}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="nom">nom</form:label></td>
					<td><form:input path="nom" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>

				<tr>
					<td><form:label path="prenom">Prénom</form:label></td>
					<td><form:input path="prenom" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>



				<tr><td><form:label path="pAgence.reference_agence">Référence de l'agence à modifier</form:label></td>
					<td><form:select path="pAgence.reference_agence">
							<c:forEach var="agence" items="${agenceListe}">
								<option value=${agence.reference_agence}>${agence.getReference_agence()}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>

					<td><br /> <br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Modifier"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>
</body>
</html>