<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supprimer un compte</title>
</head>
<body>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="soumettreSupprimerCompte"
			modelAttribute="compteForm">
			<table>

				<tr>
					<td><form:select path="compte.numero">
							<c:forEach var="compte" items="${listeComptes}">
								<option value=${compte.numero}>${compte.numero}</option>
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