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

	<%-- <%@ include file="header.html"  %> --%>

	<div class="container">
		<header class="row col-sm-12">
		<div class="page-header">
			<h1 class="police_titre">Ajouter un client</h1>
		</div>
		</header>

		<!--colonne de gauche-->
		<div class="row col-sm-12">
			<nav class="col-sm-3">

			<ul class="nav nav-pills nav-stacked" id="menu">
				<h3>Menu</h3>
				<li><a href="formulaireAjout.jsp">Ajout client</a></li>
				<li><a href="formulaireSuppression.jsp">Suppression client</a></li>
				<!-- <li><a href="update.jsp">Update compte</a></li> -->

			</ul>
			</nav>



			<div
				style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
				<form:form method="POST" action="soumettreFormAjouter"
					modelAttribute="clientForm">
					<table>

						<tr>
							<td><form:label path="nom">Nom du client</form:label></td>
							<td><form:input path="nom" /></td>
						</tr>

						<tr>
							<td><br /> <br /></td>
						</tr>

						<tr>
							<td><form:label path="prenom">Prenom du client</form:label></td>
							<td><form:input path="prenom" /></td>
						</tr>

						<tr>
							<td><form:label path="adresse">Adresse du client</form:label></td>
							<td><form:input path="adresse" /></td>
						</tr>


						<tr>
							<td><form:label path="ville">Ville du client</form:label></td>
							<td><form:input path="ville" /></td>
						</tr>

						<tr>
							<td><form:label path="telephone">Telephone du client</form:label></td>
							<td><form:input path="telephone" /></td>
						</tr>

						<tr>
							<td><form:label path="code_postal">code postal du client</form:label></td>
							<td><form:input path="code_postal" /></td>
						</tr>
						<tr>
							<td><br /> <br /></td>
						</tr>
						<tr>
							<td><form:label path="reference_client">Référence du client</form:label></td>
							<td><form:input path="reference_client" /></td>
						</tr>


						<tr>
							<td><br /> <br /></td>
						</tr>
						<tr>
							<td><form:label path="pConseiller.reference_conseiller">Référence de l'agence à modifier</form:label></td>
							<td><form:select path="pConseiller.reference_conseiller">
									<c:forEach var="conseiller" items="${conseillerListe}">
										<option value=${conseiller.reference_conseiller}>${conseiller.getReference_conseiller()}</option>
									</c:forEach>
								</form:select></td>
						</tr>


						<tr><td><form:radiobutton path="humain_0_entreprise_1" value="false"/>Humain</td>
						<td><form:radiobutton path="humain_0_entreprise_1" value="true"/>Entreprise</td>
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

		</div>
		<!--pied de page-->
		<footer class="row col-sm-12"> Accès aux opérations sur
		client client </footer>
	</div>


</body>
</html>