<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- JQuery libraries-->
<script type="text/javascript" src="scripts/jquery.js"></script>

<!-- Bootstrap libraries-->
<script type="text/javascript" src=scripts/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">

<!-- ref vers feuilles css -->
<link rel="stylesheet" href="style/style.css">

</head>
<body>
<div class="container-fluid" style="background-image: url('style/images/New-York-City.jpg');">
	<div class="row">
	<div  class="container" id="header">
		<div  class="col-xs-2" >
			<img id="building" alt="kong" src="style/images/building2.png" align="left"><h1 id="title" style="color:#ffda28 ;  font-size: x-large; text-align: center;"  >$KY-$CRAPPER <br/>BANK</h1>
		</div>
			<div  class="col-xs-10" >
			<nav class="navbar navbar-inverse" id="navbar" style="padding :5px;background:linear-gradient(to right, RGBA(64,0,64,0.50), RGBA(255,255,255,0.10))  ; color: gold ;">
					<ul class="nav nav-pills">
						<li role="presentation"><a href="/accueil">Accueil</a></li>
						<li role="presentation"><a href="/client">Clients</a></li>
						<li role="presentation"><a href="/bien">Comptes</a></li>
					</ul>
				</nav>
			</div>
	</div>
		<div  class="container">
				<div class="row">
	
<div  class="col-xs-12" style="height: 525px;" >
<div class="col-xs-2" id="leftmenu">
				<div class="col-xs-12" style="margin-top: 15px">

				<div class="list-group">
					<a href="/contrat" class="list-group-item list-group-item-warning">Accueil Liste</a>
  					<a href="/ajouterContrat" class="list-group-item list-group-item-warning">Ajouter</a>
  					<a href="/modifierContrat" class="list-group-item list-group-item-warning">Modifier</a>
  					<a href="/supprimerContrat" class="list-group-item list-group-item-warning">Supprimer</a>
  					<a href="/chercherContrat" class="list-group-item list-group-item-warning">Chercher</a>
				</div>
				
		</div>
		

</div>	
<div class="col-xs-10" id="maincontent">

</div>		
</div>
			</div>
		</div>
	
	<div class="col-xs-12" id="footer">	
			<div class="row">

				<h1 style="color: #ffda28;" >Website Footer</h1>
			</div>
	</div>
	</div>
</div>
</body>
</html>