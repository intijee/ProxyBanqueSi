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

<h1>Ajouter un client</h1>

	<div
		style="width: 400px; height: 500px; margin: auto; margin-top: 20px">
		<form:form method="POST" action="soumettreFormAjouter"
			modelAttribute="clientForm">
			<table>

				<tr>
					<td><form:label path="nom">Nom du client</form:label></td>
					<td><form:input path="nom" /></td>
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

>
				<tr>
					<td><form:label path="pConseiller.reference_conseiller">Référence du conseiller à modifier</form:label></td>
					<td><form:select path="pConseiller.reference_conseiller">
							<c:forEach var="conseiller" items="${conseillerListe}">
								<option value=${conseiller.reference_conseiller}>${conseiller.getReference_conseiller()}</option>
							</c:forEach>
						</form:select></td>
				</tr>


				<tr>
					<td><form:radiobutton path="humain_0_entreprise_1"
							value="false" />Humain</td>
					<td><form:radiobutton path="humain_0_entreprise_1"
							value="true" />Entreprise</td>
				</tr>

				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-info" value="Ajouter"
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


