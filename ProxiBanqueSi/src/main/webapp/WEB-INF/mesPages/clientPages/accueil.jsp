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
<script type="text/javascript" src='<c:url value="/scripts/bootstrap.js"/>'></script>
<link rel="stylesheet" type="text/css" href='<c:url value="/style/bootstrap.css"/>'>


<!-- ref vers feuilles css -->
<link rel="stylesheet" type="text/css" href='<c:url value="/style/style.css"/>'>


<!-- ref vers feuilles js -->
<script type="text/javascript" src='<c:url value="/scripts/script.js"/>'></script>

</head>
<body>
<div class="container-fluid">
	<div class="row">
	<div  class="container" id="header">
		<div  class="col-xs-2" >
		<img id="building" alt="kong" src='<c:url value="/style/images/building2.png"/>' align="left"><h1 id="title" style="color:#ffda28 ;  font-size: x-large; text-align: center;"  >$KY-$CRAPPER <br/>BANK</h1>
		</div>
			<div  class="col-xs-10" >
			<nav class="navbar navbar-inverse" id="navbar" style="padding :5px;background:linear-gradient(to right, RGBA(64,0,64,0.50), RGBA(255,255,255,0.10))  ; color: gold ;font-family: monospace;">
					<ul class="nav nav-pills">
						<li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Accueil</a></li>
						<li role="presentation" ><a href="${pageContext.request.contextPath}/conseiller/accueilConseiller">Conseillers</a></li>
						<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/client/accueil">Clients</a></li>
						<li role="presentation"><a href="${pageContext.request.contextPath}/compte/listeComptes">Comptes</a></li>
					</ul>
				</nav>
			</div>
	</div>
	<br/>
		<div  class="container">
				<div class="row">
	
<div  class="col-xs-12" style="height: 525px;" >
<div class="col-xs-2" id="leftmenu">
				<div class="col-xs-12" style="margin-top: 15px">

				<div class="list-group">
					<a href="accueil" class="list-group-item list-group-item-warning">Accueil Liste</a>
  					<a href="afficherFormAjouter" class="list-group-item list-group-item-warning">Ajouter</a>
  					<a href="affichFormModifier" class="list-group-item list-group-item-warning">Modifier</a>
  					<a href="affichFormSupprimer" class="list-group-item list-group-item-warning">Supprimer</a>
 
				</div>
				
		</div>
		

</div>	
<div class="col-xs-10" id="maincontent">

<h1>Liste des clients</h1>
	<br/>
	<table class="table table-hover">



		<thead>
			<tr>
				<th>Type de client</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Adresse</th>
				<th>Ville</th>
				<th>Code Postal</th>
				<th>telephone</th>
				<th>Référence client</th>
				<th>Référence du conseiller</th>
				<!-- 				<th>Référence conseiller</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="client" items="${clientListe}">
				<tr>
					<td><c:if test="${client.humain_0_entreprise_1 == false}">Humain</c:if><c:if test="${client.humain_0_entreprise_1 == true}">Entreprise</c:if></td>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td>${client.adresse}</td>
					<td>${client.ville}</td>
					<td>${client.code_postal}</td>
					<td>${client.telephone}</td>
					<td>${client.reference_client}</td>
					<td>${client.pConseiller.reference_conseiller}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</div>		
</div>
			</div>
		</div>

<br/>
	<div class="col-xs-12" id="footer">	
			<div class="row">

				<h1 style="color: #ffda28;" >Website Footer</h1>
			</div>
	</div>
	</div>
</div>
</body>
</html>

