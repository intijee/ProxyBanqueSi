<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajouter agence</title>
<script type="text/javascript"
	src='<c:url value="/resources/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/jquery-3.1.1.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/resources/bootstrap.css"/>' />
</head>
<body>
	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreFormAjouterAgence"
			modelAttribute="agenceForm">
			<table>

				<tr>
					<td><form:label path="reference_agence">Référence de l'agence</form:label></td>
					<td><form:input path="reference_agence" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>

				<tr>
					<td><form:label path="nom_gerant">Nom du gérant</form:label></td>
					<td><form:input path="nom_gerant" /></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="password_gerant">Mot de passe du gérant</form:label></td>
					<td><form:input path="password_gerant" /></td>
				</tr>
				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td><form:label path="reference_gerant">Référence du gérant</form:label></td>
					<td><form:input path="reference_gerant" /></td>
				</tr>
				<tr>
					<td><br /> <br /></td>
				</tr>
			
				
			<tr><td><form:label path="date_creation">Date de Creation</form:label></td>
			<td><form:input path="date_creation" type="date"/></td>


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