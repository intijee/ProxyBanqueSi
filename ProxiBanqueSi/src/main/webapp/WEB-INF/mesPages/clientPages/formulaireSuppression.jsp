<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<h1 class="police_titre">Supprimer un client</h1>
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

					<form class="form-horizontal" action="afficherFormSupprimer"
						method="post">
						<div class="form-group">
							<label class="control-label col-sm-5" for="reference_client">Référence du
								client:</label>
							<div class="col-sm-5">
								<input type="text" name="reference_client" class="form-group" />
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