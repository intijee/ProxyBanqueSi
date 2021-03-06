<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil gestion des comptes</title>

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
						style="padding: 5px; background: linear-gradient(to right, RGBA(64, 0, 64, 0.50), RGBA(255, 255, 255, 0.10)); color: gold; font-family: monospace;">
						<ul class="nav nav-pills">
							<li role="presentation"><a href="${pageContext.request.contextPath}">Accueil</a></li>
									<li role="presentation"><a
								href="${pageContext.request.contextPath}/conseiller/accueilConseiller">Conseillers</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/client/accueil">Clients</a></li>
							<li role="presentation" class="active"><a
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
									<a href="listeComptes"
										class="list-group-item list-group-item-warning">Accueil
										Liste</a> <a href="${pageContext.request.contextPath}/compte/afficheAjoutCompte"
										class="list-group-item list-group-item-warning">Ajouter un
										compte</a> <a href="${pageContext.request.contextPath}/compte/afficheModifierCompte"
										class="list-group-item list-group-item-warning">Modifier
										un compte</a> <a href="${pageContext.request.contextPath}/compte/afficheSupprimerCompte"
										class="list-group-item list-group-item-warning">Supprimer
										un compte</a> <a href="${pageContext.request.contextPath}/compte/afficheOperation"
										class="list-group-item list-group-item-warning">Effectuer
										une op�ration</a>


								</div>

							</div>


						</div>
						<div class="col-xs-10" id="maincontent">


							<h1>Liste des comptes</h1>
							<table class="table table-hover">
								<tr>
									<th>Num�ro de compte</th>
									<th>Solde</th>
									<th>Date d'ouverture du compte</th>
									<th>R�f�rence du client</th>
									<th>supprimer | modifier</th>
								</tr>

								<tr>
									<td><c:forEach var="compte" items="${comptesListe}">
											<tr>
												<td>${compte.numero}</td>
												<td>${compte.solde}</td>
												<td>${compte.date_ouverture}</td>
												<td>${compte.pClient.reference_client}</td>
												<td><a
													href="${pageContext.request.contextPath}/compte/supprimerCompteAffiche/${compte.id_compte}">Supprimer</a>
													| <a href="${pageContext.request.contextPath}/compte/modifierCompteAffiche/${compte.id_compte}">modifier</a>
												</td>
											</tr>
										</c:forEach>
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