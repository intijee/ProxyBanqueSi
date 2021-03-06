<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- JQuery libraries-->
<script type="text/javascript" src='<c:url value="/scripts/jquery.js"/>'></script>

<!-- Bootstrap libraries-->
<script type="text/javascript"
	src='<c:url value="/scripts/bootstrap.js"/>'></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/style/bootstrap.css"/>'>


<!-- ref vers feuilles css -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/style/style.css"/>'>


<!-- ref vers feuilles js -->
<script type="text/javascript" src='<c:url value="/scripts/script.js"/>'></script>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="container" id="header">
				<div class="col-xs-2">
					<img id="building" alt="kong"
						src='<c:url value="/style/images/building2.png"/>' align="left">
					<h1 id="title"
						style="color: #ffda28; font-size: x-large; text-align: center;">
						$KY-$CRAPPER <br />BANK
					</h1>
				</div>
				<div class="col-xs-10">
					<nav class="navbar navbar-inverse" id="navbar"
						style="padding :5px;background:linear-gradient(to right, RGBA(64,0,64,0.50), RGBA(255,255,255,0.10))  ; color: gold ;font-family: monospace;">
					<ul class="nav nav-pills">
						<li role="presentation"><a
							href="${pageContext.request.contextPath}/index.jsp">Accueil</a></li>
						<li role="presentation"><a
							href="${pageContext.request.contextPath}/conseiller/accueilConseiller">Conseillers</a></li>
						<li role="presentation" class="active"><a
							href="${pageContext.request.contextPath}/client/accueil">Clients</a></li>
						<li role="presentation"><a
							href="${pageContext.request.contextPath}/compte/listeComptes">Comptes</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<br />
			<div class="container">
				<div class="row">

					<div class="col-xs-12" style="height: 525px;">
						<div class="col-xs-2" id="leftmenu">
							<div class="col-xs-12" style="margin-top: 15px">

								<div class="list-group">
									<<a href="accueil"
										class="list-group-item list-group-item-warning">Accueil
										Liste</a> <a href="afficherFormAjouter"
										class="list-group-item list-group-item-warning">Ajouter</a> <a
										href="affichFormModifier"
										class="list-group-item list-group-item-warning">Modifier</a> <a
										href="affichFormSupprimer"
										class="list-group-item list-group-item-warning">Supprimer</a>
									<a href="fortune"
										class="list-group-item list-group-item-warning">Fortune</a> <a
										href="action" class="list-group-item list-group-item-warning">Bourse</a>
									<a href="simulation"
										class="list-group-item list-group-item-warning">Simulation-Pret</a>

								</div>

							</div>


						</div>
						<div class="col-xs-10" id="maincontent">
							
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
					<td><form:label path="somme_pret">Somme � emprunter</form:label></td>
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
			<th>Somme D�sir�e</th>
			<th>Dur�e (Mois)</th>
			<th>Mensualit�s</th>
			<th>Somme total � rembourser</th>
		</tr>

	
		<tr>
			<td>${pret.pClient.reference_client}</td>
			<td>${pret.somme_pret}</td>
			<td>${pret.duree_mois}</td>
			<td>${pret.mensualites}</td>
			<td>${pret.cout_pret}</td>
		</tr>

	</table>
						</div>
					</div>
				</div>
			</div>

			<br />
			<div class="col-xs-12" id="footer">
				<div class="row">

					<h1 style="color: #ffda28;">Website Footer</h1>
				</div>
			</div>
		</div>
	</div>
</body>
</html>





