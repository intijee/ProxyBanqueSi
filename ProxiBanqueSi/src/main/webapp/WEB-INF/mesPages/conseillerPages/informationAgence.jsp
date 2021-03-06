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
						<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/conseiller/accueilConseiller">Conseillers</a></li>
						<li role="presentation"><a href="${pageContext.request.contextPath}/client/accueil">Clients</a></li>
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
					<a href="accueilConseiller" class="list-group-item list-group-item-warning">Accueil Liste</a>
  					<a href="ajouter" class="list-group-item list-group-item-warning">Ajouter</a>
  					<a href="ajouterAgence" class="list-group-item list-group-item-warning">Ajouter Agence</a>
  					<a href="accueilAgence" class="list-group-item list-group-item-warning">Infos Agence</a>
  					<a href="modifier" class="list-group-item list-group-item-warning">Modifier</a>
  					<a href="supprimer" class="list-group-item list-group-item-warning">Supprimer</a>
  					
 
				</div>
				
		</div>
		

</div>	
<div class="col-xs-10" id="maincontent">

<h1>Informations de l'Agence</h1>
<br/>
	<table class="table table-hover">
	
		<tr>
			<th>date creation</th>
			<th>Nom du gerant</th>
			<th>R�f�rence de l'agence</th>
			<th>R�f�rence du g�rant</th>
		</tr>

		<tr>
			<td><c:forEach var="agence" items="${agenceListe}">
		<tr>
			<td>${agence.date_creation}</td>
			<td>${agence.nom_gerant}</td>
			<td>${agence.reference_agence}</td>
			<td>${agence.reference_gerant}</td>
		</tr>
</c:forEach>
	</table>
	
	
		<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 50px">
		<form:form method="POST" action="auditAgence"
			modelAttribute="auditForm">
			<table>

				<tr><td><form:label path="reference_agence">R�f�rence de l'agence � auditer</form:label></td>
					<td><form:select path="reference_agence">
							<c:forEach var="agence" items="${agenceListe}">
								<option value=${agence.reference_agence}>${agence.getReference_agence()}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><br /> <br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Auditer"
						style="margin-left: 120px"></td>
				</tr>

			</table>

		</form:form>

	</div>

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