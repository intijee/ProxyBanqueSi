<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="bootstrap/js/jquery-3.1.1.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

</head>
<body>

<div class="container">
<header class="row col-sm-12">
        <div class="page-header">
 <h2 class="police_titre">Afficher les clients</h2>
        </div>
    </header>
    
   <a href="accueil.jsp">Retour vers Accueil</a><br/>
   
<form action="accueil" method="get">
<p><input type="submit"  value="valider" /></p>
</form>

	<table class="table table-bordered">

<!-- affichage de la liste des clients  -->
<h3>Client: </h3>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Adresse</th>
				<th>Ville</th>
				<th>Code Postal</th>
				<th>telephone</th>
				<th>Référence client</th>
<!-- 				<th>Référence conseiller</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="client" items="${listeClient}">
				<tr>
					<th>${client.id}</th>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td>${client.adresse}</td>
					<th>${client.ville}</th>
					<td>${client.code_postal}</td>
					<td>${client.telephone}</td>
					<td>${client.reference_client}</td>
<!-- 					<td>${client.conseiller_id_fk}</td> -->
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>