<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreFormSupprimer"
			modelAttribute="supprimerForm">
			<table>

				<tr>
					<td><form:label path="reference_client">Référence du client à supprimer</form:label></td>
					<td><form:select path="reference_client">
							<c:forEach var="client" items="${clientListe}">
								<option value=${client.reference_client}>${conseiller.getReference_client()}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Supprimer"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>
</body>
</html>