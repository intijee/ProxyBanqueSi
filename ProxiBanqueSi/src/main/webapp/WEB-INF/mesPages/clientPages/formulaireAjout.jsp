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

			<section class="col-sm-9">

			<div class="panel panel-default">

				<div class="panel-body">

					<form class="form-horizontal" action="afficherFormAjouter"
						method="post">
						<div class="form-group">
							<form:label class="control-label col-sm-5" for="nom">Nom du
								client:</form:label>
							<div class="col-sm-5">
								<input type="text" name="nom" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="prenom">Prénom
								du client:</label>
							<div class="col-sm-5">
								<input type="text" name="prenom" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="adresse">Adresse</label>
							<div class="col-sm-5">
								<input type="text" name="adresse" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="code_postal">Code
								postal</label>
							<div class="col-sm-5">
								<input type="text" name="code_postal" value="100"
									class="form-group" />
							</div>
						</div>
						<!--     <div class="form-group">
     	<label class="control-label col-sm-5" for="humain_0_entreprise_1">Type de client : humain 0, entreprise 1</label>
     	 <div class="col-sm-5">
     	<input type="text" name="humain_0_entreprise_1" class="form-group" />
     	</div> -->
						<!--     </div> -->
						<div class="form-group">
							<label class="control-label col-sm-5" for="ville">Ville</label>
							<div class="col-sm-5">
								<input type="text" name="ville" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="telephone">telephone</label>
							<div class="col-sm-5">
								<input type="text" name="telephone" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="reference_client">Référence
								Client</label>
							<div class="col-sm-5">
								<input type="text" name="reference_client" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="pconseiller.reference_conseiller">Référence
								Conseiller</label>
							<div class="col-sm-5">
								<input type="text" name="pconseiller.reference_conseiller" class="form-group" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="solde">Type de
								client :</label>
							<div class="col-sm-5">
								<select name="type" size="1" class="form-group"><option
										name="humain">humain</option>
									<option name="entreprise">entreprise</option></select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-5">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>
					</form>

				</div>
			</div>


			</section>

		</div>
		<!--pied de page-->
		<footer class="row col-sm-12"> Accès aux opérations sur client
		client </footer>
	</div>


</body>
</html>